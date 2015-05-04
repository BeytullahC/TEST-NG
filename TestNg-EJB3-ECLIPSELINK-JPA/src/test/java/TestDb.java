import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.ejb.beans.dao.CountriesDaoSessionBean;
import testng.entities.Countries;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by 912867 on 30.04.2015.
 */
public class TestDb {


    private static EJBContainer container;
    private static Context ctx;
    private static final String COUNTRY_TEST_ID = "TR";
    private static CountriesDaoSessionBean daoSessionBean;

    @BeforeClass
    public static void setup() throws IOException, NamingException {

        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root",
                "./src/test/resources/glassfish");
        container = EJBContainer.createEJBContainer(properties);
        ctx = container.getContext();
        daoSessionBean = (CountriesDaoSessionBean)
                ctx.lookup("java:global/classes/countriesDaoSessionEJB");
    }

    @Test
    public void TestSave() {
        Countries country = new Countries();
        country.setCountryId("TR");
        country.setCountryName("TURKEY");
        daoSessionBean.save(country);
        System.out.println("TEST OK");
    }

    @Test
    public void testTeamService() throws NamingException {

        CountriesDaoSessionBean teamEjb = (CountriesDaoSessionBean) ctx
                .lookup("java:global/classes/countriesDaoSessionEJB");
        Countries country = teamEjb.test(COUNTRY_TEST_ID);
        assertEquals(COUNTRY_TEST_ID, country.getCountryId());
        System.out.println("TEST OK2 " + country);
    }

    @AfterClass
    public static void teardown() {
        container.close();

    }

}
