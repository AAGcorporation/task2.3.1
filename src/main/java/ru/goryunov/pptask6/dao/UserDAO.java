package ru.goryunov.pptask6.dao;

import ru.goryunov.pptask6.model.User;

import java.util.List;
// ЗДЕСЬ все РОВНО
public interface UserDAO {
    List<User> allUsers(); //показать всех
    void add(User user); //добавить
    void delete(User user); // удалить
    void edit(User user); // редактировать
    User getById(int id); // поиск по id
}
