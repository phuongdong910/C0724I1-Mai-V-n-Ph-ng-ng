package com.example.showlistcustomer22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Customer> customers = new ArrayList<>();
        customers.add( new Customer("Mai Van Anh Quan", "01/01/1989", "Da nang","image.jpg" ));
        customers.add( new Customer("Mai Van Phuong Dong", "01/01/1989", "Da nang","image.jpg" ));
        customers.add( new Customer("Tuan vo dich", "01/01/1989", "Da nang","image.jpg" ));
        customers.add( new Customer("Khang vo doi", "01/01/1989", "Da nang","image.jpg" ));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
