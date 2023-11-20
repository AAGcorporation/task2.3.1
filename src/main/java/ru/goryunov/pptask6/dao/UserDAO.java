package ru.goryunov.pptask6.dao;

import ru.goryunov.pptask6.model.User;
import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(int id);
}
