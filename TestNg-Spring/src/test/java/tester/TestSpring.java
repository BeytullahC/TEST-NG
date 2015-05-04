package tester;

import com.beto.test.testng.spring.SpringBean;
import com.beto.test.testng.spring.config.SpringConfig;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 * Created by 912867 on 04.05.2015.
 */

@Test
@ContextConfiguration(classes = SpringConfig.class)
public class TestSpring extends AbstractTestNGSpringContextTests {

    @Autowired
    private SpringBean springBean;

    @Test()
    public void testBean() {
        System.out.println(springBean.generate());
        assertNotNull(springBean);
    }
}
