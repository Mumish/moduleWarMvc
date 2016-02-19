package by.it.academy.dao;

import by.it.academy.pojos.Person;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DaoTest{

    @Autowired
    private PersonDao personDao;

    @Test
    public void addPerson() {
        Person p = new Person();
        p.setName("Yuli");
        p.setSurname("Slabko");
        p.setAge(30);
        Person persistent = personDao.add(p);
        assertNotNull(persistent.getId());
        persistent = personDao.get(Person.class, persistent.getId());
        assertEquals("Person not persist", p, persistent);
    }
    
    @After
    public void deletePerson() {
        List<Person> list = personDao.getPersons();              
        int size = list.size();
        if (list.size() > 0) {
            Person persistent = list.get(0);
            personDao.delete(persistent);
            assertNotSame(personDao.getPersons().size(), size);
        }
    }
}
