package com.example.thimoudle3.dao;

import com.example.thimoudle3.connection.JDBCConnection;
import com.example.thimoudle3.model.entity.PaymentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDAO {

    // Phương thức tìm tất cả các hình thức thanh toán
    public List<PaymentType> findAllPaymentTypes() {
        List<PaymentType> paymentTypes = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PaymentType");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("typeName");
                    paymentTypes.add(new PaymentType(id, type));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return paymentTypes;
    }
}