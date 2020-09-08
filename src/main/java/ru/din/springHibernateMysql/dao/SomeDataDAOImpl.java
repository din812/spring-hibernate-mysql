package ru.din.springHibernateMysql.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.din.springHibernateMysql.model.SomeData;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SomeDataDAOImpl implements SomeDataDAO {

    private static Map<Integer, SomeData> data = new HashMap<>();
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SomeData> allData() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SomeData ").list();
    }

    @Override
    public void create(SomeData someData) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(someData);
    }

    @Override
    public SomeData readById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(SomeData.class, id);
    }

    @Override
    public void update(SomeData someData) {
        Session session = sessionFactory.getCurrentSession();
        session.update(someData);
    }

    @Override
    public void delete(SomeData someData) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(someData);
    }
}
