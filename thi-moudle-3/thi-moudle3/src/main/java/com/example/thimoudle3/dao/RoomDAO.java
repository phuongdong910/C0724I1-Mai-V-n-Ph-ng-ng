package com.example.thimoudle3.dao;



import com.example.thimoudle3.connection.JDBCConnection;
import com.example.thimoudle3.model.entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    // Phương thức tìm tất cả các phòng trọ
    public List<Room> findAllRooms() {
        List<Room> rooms = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Room");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int roomId = resultSet.getInt("roomId");
                    String tenantName = resultSet.getString("tenantName");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Date startDate = resultSet.getDate("startDate");
                    int paymentTypeId = resultSet.getInt("paymentTypeId");
                    String notes = resultSet.getString("notes");
                    rooms.add(new Room(roomId, tenantName, phoneNumber, startDate, paymentTypeId, notes));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rooms;
    }

    // Phương thức tìm phòng trọ theo roomId
    public Room findRoomById(int roomId) {
        Room room = null;
        Connection connection = JDBCConnection.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Room WHERE roomId = ?");
                preparedStatement.setInt(1, roomId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String tenantName = resultSet.getString("tenantName");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Date startDate = resultSet.getDate("startDate");
                    int paymentTypeId = resultSet.getInt("paymentTypeId");
                    String notes = resultSet.getString("notes");
                    room = new Room(roomId, tenantName, phoneNumber, startDate, paymentTypeId, notes);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return room;
    }

    // Phương thức tìm phòng trọ theo tên người thuê
    public List<Room> findRoomByName(String tenantName) {
        List<Room> rooms = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Room WHERE tenantName LIKE ?");
                preparedStatement.setString(1, "%" + tenantName + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int roomId = resultSet.getInt("roomId");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    Date startDate = resultSet.getDate("startDate");
                    int paymentTypeId = resultSet.getInt("paymentTypeId");
                    String notes = resultSet.getString("notes");
                    rooms.add(new Room(roomId, tenantName, phoneNumber, startDate, paymentTypeId, notes));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rooms;
    }

    // Phương thức thêm phòng trọ mới
    public void addRoom(Room room) {
        Connection connection = JDBCConnection.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO Room (tenantName, phoneNumber, startDate, paymentTypeId, notes) VALUES (?, ?, ?, ?, ?)"
                );
                preparedStatement.setString(1, room.getTenantName());
                preparedStatement.setString(2, room.getPhoneNumber());
                preparedStatement.setDate(3, Date.valueOf(room.getStartDate()));
                preparedStatement.setInt(4, room.getPaymentMethodId());
                preparedStatement.setString(5, room.getNote());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Phương thức xóa phòng trọ
    public void deleteRoom(int roomId) {
        Connection connection = JDBCConnection.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Room WHERE roomId = ?");
                preparedStatement.setInt(1, roomId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
