package com.example.productdiscountcaculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String productDescription = req.getParameter("productDescription");
    String listPriceString = req.getParameter("listPrice");
    String discountPercentString = req.getParameter("discountPercent");

    // chuyen  đổi giá trị tu chuoi sang so thuc
        double listPrice = Double.parseDouble(listPriceString);
        double discountPercent = Double.parseDouble(discountPercentString);
        // Tính toán lượng chiết khau và giá sau khi chiết khấu
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPirce = listPrice - discountAmount;

        // Đưa các giá tri tinh toan vao request
        req.setAttribute("productDescription", productDescription);
        req.setAttribute("listPrice", listPrice);
        req.setAttribute("discountPercent", discountPercent);
        req.setAttribute("discountAmount", discountAmount);
        req.setAttribute("discountPrice", discountPirce);

        // Chuyển den trang hien thi ket qua
        req.getRequestDispatcher("display-discount.jsp").forward(req, resp);
    }
}