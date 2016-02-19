/*
 * Copyright (C) 2015 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 013 13.01.2015
 */
package by.it.academy.services;

import by.it.academy.pojos.Person;

import javax.transaction.Transactional;
import java.util.List;

public interface IPersonService {

    List<Person> getPersons();

    Person create(Person person);

    void delete(Person person);
}
