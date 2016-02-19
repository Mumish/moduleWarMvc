/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 021 21.10.2014
 */
package by.it.academy.dao;

import by.it.academy.pojos.Person;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public class PersonDao extends BaseDao<Person> implements IPersonDao<Person> {

    @Autowired
    public PersonDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<Person> getPersons() {
        String hql = "from Person";
        Query query = getSession().createQuery(hql);

        return query.list();
    }
}
