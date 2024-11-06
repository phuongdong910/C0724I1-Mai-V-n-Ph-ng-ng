package model.service;


import java.util.List;

public interface IUserService {

    List<User> findAllUsers();

    User findUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    void insertUpdateUseTransaction();
}