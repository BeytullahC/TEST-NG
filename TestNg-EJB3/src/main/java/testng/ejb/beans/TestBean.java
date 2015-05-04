package testng.ejb.beans;

import javax.ejb.Stateless;

/**
 * Created by 912867 on 29.04.2015.
 */
@Stateless
public class TestBean {
    public String hello(String message) {
        return "Hello " + message;
    }
}
