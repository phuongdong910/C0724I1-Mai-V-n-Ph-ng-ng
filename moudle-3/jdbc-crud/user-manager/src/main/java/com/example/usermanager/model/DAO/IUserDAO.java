package com.example.usermanager.model.DAO;

import com.example.usermanager.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public  void insertUser(User user) throws SQLException;
    public User  selectUser(int id);
    public List<User> selectAllUsers();
    public  boolean deleteUser(int id) throws SQLException;

}
