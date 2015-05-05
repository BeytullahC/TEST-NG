/**
 * Created by 912867 on 29.04.2015.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg {

    private List<String> list;
    private List<String> list2;

    /**
     * This method runs like a Consturoctor
     */
    @BeforeClass
    public void BeforeClass() {
        System.out.println("BEFORE CLASS METHOD RUNNED...");
    }

    /**
     * This method runs like a Destroy method.
     */
    @AfterClass
    public void Destroy() {
        System.out.println("AFTER CLASS METHOD RUNNED...");
    }

    /**
     * Run before every test Method
     */
    @BeforeMethod
    public void BeforeMethod() {
        list = new LinkedList<String>( Arrays.asList(new String[]{"test", "test2", "test3", "test4"}));
        list2 = Arrays.asList(new String[]{"test", "test2", "test3", "test4"});
       System.out.println("BEFORE METHOD RUNNED...");
    }

    @AfterMethod
    public void AfterMethod() {
        list = new ArrayList<String>();
        System.out.println("AFTER METHOD RUNNED...");
    }


    @Test
    public void TestData() {
       printListSize();
    }

    @Test
    public void TestListAddData(){
        printListSize();
        list.add("test5");
        printListSize();
    }


    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void TestError(){
        list2.add("test5");
        printListSize();
    }


    public void printListSize(){
        System.out.println("LIST SIZE : " + list.size());
    }

}

