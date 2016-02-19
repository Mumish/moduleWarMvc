package by.it.academy.dao;

import by.it.academy.pojos.Person;

import java.util.List;

/**
 * Created by yslabko on 024 24 мар 2015.
 */
public interface IPersonDao <T> extends Dao<T> {
    List<T> getPersons();
}
