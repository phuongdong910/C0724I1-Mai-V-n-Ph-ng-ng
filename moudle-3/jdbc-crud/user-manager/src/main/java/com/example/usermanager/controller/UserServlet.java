package com.example.usermanager.controller;

import com.example.usermanager.model.DAO.UserDAO;
import com.example.usermanager.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name  = "UserServlet", urlPatterns = "/users")
public  class UserServlet extends HttpServlet {
    private static final  long serialVersionUID = 1L;
    private UserDAO userDAO;

    public  void init(){
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    insertUser(request, reponse);
                    break;
                case "edit":
                    updateUser (request, response);
                    break;
            }
        }catch (SQLException ex) {
            throw  new ServletException(ex);
        }
    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    deleteUser(request,response);
                    break;
                    default:
                        listUser(request, response);
                        break;
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private  void listUser(HttpServletRequest request, HttpServletResponse response)
        throws SQLException,ServletException, IOException{
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher dispatcher  = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException,ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser (HttpServletRequest request, HttpServletResponse response)
        throws SQLException,ServletException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        userDAO.insertUser(newUser);
        RequestDispatcher dispatcher  = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }


}