package com.beto.test.testng.sh.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beto.test.testng.sh.dao.CountriesDao;
import com.beto.test.testng.sh.entities.Countries;

/**
 * Created by 912867 on 04.05.2015.
 */

@Repository
public class CountriesDaoImpl implements CountriesDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Countries test(String countryId) {

        try {
            return (Countries) sessionFactory.getCurrentSession().get(Countries.class, countryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Boolean save(Countries country) {
        sessionFactory.getCurrentSession().save(country);
        return true;
    }
}
