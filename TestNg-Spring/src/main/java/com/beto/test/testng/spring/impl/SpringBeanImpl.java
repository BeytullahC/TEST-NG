package com.beto.test.testng.spring.impl;

import com.beto.test.testng.spring.SpringBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by 912867 on 04.05.2015.
 */
@Service
public class SpringBeanImpl implements SpringBean {

    @Override
    public String generate() {
        return "feedback@yoursite.com";
    }

}
