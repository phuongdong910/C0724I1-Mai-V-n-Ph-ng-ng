package com.example.thimoudle3.controller;

import com.example.thimoudle3.dao.RoomDAO;
import com.example.thimoudle3.dao.PaymentTypeDAO;
import com.example.thimoudle3.model.entity.Room;
import com.example.thimoudle3.model.entity.PaymentType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {
    private RoomDAO roomDAO = new RoomDAO();
    private PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            roomDAO.deleteRoom(roomId);
        }

        // Tìm phòng theo tên người thuê nếu có search query
        String searchQuery = request.getParameter("searchQuery");
        List<Room> rooms = (searchQuery == null || searchQuery.isEmpty()) ? roomDAO.findAllRooms() : roomDAO.findRoomByName(searchQuery);

        // Tải danh sách các hình thức thanh toán để hiển thị trong form
        List<PaymentType> paymentTypes = paymentTypeDAO.findAllPaymentTypes();

        // Đưa dữ liệu vào request để forward đến view
        request.setAttribute("rooms", rooms);
        request.setAttribute("paymentTypes", paymentTypes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/roomList.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenantName = request.getParameter("tenantName");
        String phoneNumber = request.getParameter("phoneNumber");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        String notes = request.getParameter("notes");

        // Tạo một đối tượng Room từ thông tin đã nhập
        Room room = new Room();
        room.setTenantName(tenantName);
        room.setPhoneNumber(phoneNumber);
        room.setStartDate(startDate);
        room.setPaymentMethodId(paymentTypeId);
        room.setNote(notes);

        // Thêm phòng mới vào cơ sở dữ liệu
        roomDAO.addRoom(room);

        // Redirect đến trang danh sách phòng sau khi thêm thành công
        response.sendRedirect(request.getContextPath() + "/room");
    }
}
