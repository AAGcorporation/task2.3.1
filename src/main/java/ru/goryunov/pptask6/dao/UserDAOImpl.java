package ru.goryunov.pptask6.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.goryunov.pptask6.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :userId");
        query.setParameter("userId", user.getId());
        query.executeUpdate();
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
