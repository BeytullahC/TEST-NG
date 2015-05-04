package com.beto.test.testng.sh;

import com.beto.test.testng.sh.config.DataSourceConfig;
import com.beto.test.testng.sh.dao.CountriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by 912867 on 04.05.2015.
 */
@Test
@ContextConfiguration(classes = {DataSourceConfig.class})
@TransactionConfiguration(defaultRollback = false)
public class TestSh extends AbstractTransactionalTestNGSpringContextTests{

    @Autowired
    private CountriesDao dao;

    @Override
    @BeforeMethod(alwaysRun = true)
    protected synchronized void springTestContextBeforeTestMethod(
            Method testMethod) throws Exception {
        super.springTestContextBeforeTestMethod(testMethod);
    }

    @Override
    @AfterMethod(alwaysRun = true)
    protected synchronized void springTestContextAfterTestMethod(
            Method testMethod) throws Exception {
        super.springTestContextAfterTestMethod(testMethod);
    }

    @Test()
    public void test(){
        assertTrue(true);
    }

    @Test()
    @Rollback(
            value = true
    )

    public void TestSessionFactory(){
        assertNotEquals(null, dao);
    }

    @Test()
    public void TestCurrentSession(){
        assertNotEquals(null,dao.test("AR"));
    }


}
