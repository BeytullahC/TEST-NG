import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.ejb.beans.TestBean;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import static org.testng.Assert.*;

/**
 * Created by 912867 on 30.04.2015.
 */
public class TestEjb {
    private static EJBContainer ejbContainer;

    private static Context ctx;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Instantiate an embeddable EJB container and search the
        // JVM class path for eligible EJB modules or directories
        ejbContainer = EJBContainer.createEJBContainer();

        // Get a naming context for session bean lookups
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Shutdown the embeddable container
        ejbContainer.close();
    }

    @Test
    public void hello() throws NamingException {
        // Retrieve a reference to the session bean using a portable
        // global JNDI name
        TestBean helloWorld = (TestBean)
                ctx.lookup("java:global/classes/TestBean");

        // Do your tests
        assertNotNull(helloWorld);
        String expected = "World";
        String hello = helloWorld.hello(expected);
        System.out.println("RESPONSE : " +hello);
        assertNotNull(hello);
        assertTrue(hello.endsWith(expected));
    }
}
