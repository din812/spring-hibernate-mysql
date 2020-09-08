package ru.din.springHibernateMysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.din.springHibernateMysql.dao.SomeDataDAO;
import ru.din.springHibernateMysql.model.SomeData;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SomeDataServiceImpl implements SomeDataService {

    private SomeDataDAO someDataDAO;

    @Override
    @Transactional
    public List<SomeData> allData() {
        return someDataDAO.allData();
    }

    @Override
    @Transactional
    public void create(SomeData someData) {
        someDataDAO.create(someData);
    }

    @Override
    @Transactional
    public SomeData readById(int id) {
        return someDataDAO.readById(id);
    }

    @Override
    @Transactional
    public void update(SomeData someData) {
        someDataDAO.update(someData);
    }

    @Override
    @Transactional
    public void delete(SomeData someData) {
        someDataDAO.delete(someData);
    }

    @Autowired
    public void setSomeDataDAO(SomeDataDAO someDataDAO) {
        this.someDataDAO = someDataDAO;
    }
}
