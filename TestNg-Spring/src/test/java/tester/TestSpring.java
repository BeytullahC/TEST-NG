package tester;

import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.beto.test.testng.spring.SpringBean;
import com.beto.test.testng.spring.config.SpringConfig;

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
