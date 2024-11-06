package com.example.showlistcustomers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyen Van A", "01/01/1990", "Hanoi", "imageA.jpg"));
        customers.add(new Customer("Le Thi B", "02/02/1992", "Danang", "imageB.jpg"));
        customers.add(new Customer("Tran Van C", "03/03/1993", "HCMC", "imageC.jpg"));
        customers.add(new Customer("Pham Thi D", "04/04/1994", "Hue", "imageD.jpg"));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }
}
