package testng.ejb.beans.dao;

import testng.entities.Countries;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;

/**
 * Created by 912867 on 30.04.2015.
 */

@Stateless(name = "countriesDaoSessionEJB")
public class CountriesDaoSessionBean implements Serializable {

    @PersistenceContext(unitName = "HR_UNIT")
    private EntityManager em;

    public Countries test(String countryId) {
        try {
            TypedQuery<Countries> tq =
                    em.createQuery(
                            "select c \n" +
                                    "  from  Countries  c\n" +
                                    " where c.countryId=:countryId",
                            Countries.class);
            tq.setParameter("countryId", countryId);
            return tq.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Boolean save(Countries country) {
        em.persist(country);
        return true;
    }
}
