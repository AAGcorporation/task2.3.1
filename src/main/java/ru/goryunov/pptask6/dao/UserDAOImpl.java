package ru.goryunov.pptask6.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.goryunov.pptask6.model.User;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
            entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", user.getId());
        query.executeUpdate();
    }
    @Transactional
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
