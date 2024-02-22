package Testng;

import Utilities.AllUtilities;
import com.epam.tat.module4.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

import org.testng.asserts.SoftAssert;

public class TestClass extends Task1 {

    Calculator calculator = new Calculator();
   static SoftAssert softAssert = new SoftAssert();;

    @BeforeClass
    public void setUp() {
       Logger log = LogManager.getLogger(AllUtilities.class);
       log.info("Calculator");
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
    }

    @Test(dataProvider = "datas", groups = "mathOperations")
    public void addition(int data1, int data2) {
        long sum = calculator.sum(data1, data2);
        Assert.assertEquals(sum, Addition(data1, data2));
    }

    @Test(dataProvider = "datas", groups = "mathOperations")
    public void subtraction(int data1, int data2) {
        long sub = calculator.sub(data1, data2);
        Assert.assertEquals(sub, Subtraction(data1, data2));
    }

    @Test(dataProvider = "datas", groups = "mathOperations")
    public void divi(int data1, int data2) {
        if (data2 != 0) {
            long div = calculator.div(data1, data2);
            Assert.assertEquals(div, division(data1, data2));
        } else {
            System.out.println("Error: Division by zero");
        }
    }

    @Test(dataProvider = "datas", groups = "mathOperations")
    public void multiply(int data1, int data2) {
        long multi = calculator.mult(data1, data2);
        Assert.assertEquals(multi, multiplication(data1, data2));
    }



    @Test(dataProvider = "datas", groups = "negativeCases")
    public void addNegative(int data1, int data2) {
        long addition = calculator.sum(data1, data2);
        int add = Addition(data1, data2);
        softAssert.assertEquals(addition, add);
    }

    @Test(dataProvider = "datas", groups = "negativeCases")
    public void subNegative(int data1, int data2) {
        long subtraction = calculator.sub(data1, data2);
        int sub = Subtraction(data1, data2);
        Assert.assertEquals(subtraction, sub);
    }


    @Test(dataProvider = "datas", groups = "negativeCases")
    public void divisionNegative(int data1, int data2) {
        double divisionResult = calculator.div(data1, data2);
        Assert.assertNotEquals(divisionResult, division(data1, data2));
    }


    @Test(dataProvider = "datas", groups = "mathOperations")
    public void percentNegative(int data1, int data2) {
        long percentage = calculator.div(data1, data2);
        Assert.assertNotEquals(String.valueOf(percentage), data1%data2);
    }

    @DataProvider(parallel = true)
    public Object[][] datas() {
        Object[][] data = new Object[1][2];
        Random random = new Random();
        data[0][0] = random.nextInt(10);
        data[0][1] = random.nextInt(100);
        return data;
    }
}
