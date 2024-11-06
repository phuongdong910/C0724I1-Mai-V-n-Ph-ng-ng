package model.repository;

import model.entities.User;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserById(int userId);
    Optional<User> getUserByEmail(String email);
    boolean saveUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int userId);
}