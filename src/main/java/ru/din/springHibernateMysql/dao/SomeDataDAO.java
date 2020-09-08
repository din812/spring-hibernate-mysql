package ru.din.springHibernateMysql.dao;

import ru.din.springHibernateMysql.model.SomeData;

import java.util.List;

public interface SomeDataDAO {

    List<SomeData> allData();

    void create(SomeData someData);

    SomeData readById(int id);

    void update(SomeData someData);

    void delete(SomeData someData);

}
