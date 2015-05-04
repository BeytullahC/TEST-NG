package com.beto.test.testng.sh.dao;

import com.beto.test.testng.sh.entities.Countries;

/**
 * Created by 912867 on 04.05.2015.
 */
public interface CountriesDao {

    public Countries test(String countryId);

    public Boolean save(Countries country);
}
