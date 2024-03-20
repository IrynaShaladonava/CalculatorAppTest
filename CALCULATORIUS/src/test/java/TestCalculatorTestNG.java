import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalculatorTestNG {

    @BeforeClass
    public void setUp() {
        try {
            TestCalculator.setup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown() {
        TestCalculator.driver.quit();
    }


    @Test(priority = 2)
    public void testLoginNegative() {
        TestCalculator.logInNegative();
        Assert.assertFalse(TestCalculator.driver.getPageSource().contains("Error"), "Login negative test failed.");
    }

    @Test(priority = 3)
    public void testLoginPositive() {
        TestCalculator.logInPositive();
        Assert.assertTrue(TestCalculator.driver.getTitle().equals("Skaičiuotuvas"), "Login positive test failed.");
    }

    @Test(priority = 4)
    public void testSendOperationsPositive() {
        TestCalculator.clearFields();
        TestCalculator.sendOperationsPositive();
        Assert.assertFalse(TestCalculator.driver.findElement(By.tagName("h4")).getText().contains("Result"), "Send operations positive test failed.");
    }

    @Test(priority = 5)
    public void testSendOperationsNegative() {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TestCalculator.clearFields();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        TestCalculator.sendOperationsNegative();

        Assert.assertFalse(TestCalculator.driver.getPageSource().contains("Error"), "Send operations negative test failed.");
    }

    @Test(priority = 6)
    public void testDeleteOperationNegative() {
        TestCalculator.goBack();
        TestCalculator.deleteOperationNegative();
        Assert.assertFalse(TestCalculator.driver.getPageSource().contains("Error"), "Delete operation negative test failed.");
    }

    @Test(priority = 7)
    public void testDeleteOperation() {
        TestCalculator.deleteOperation();
        Assert.assertFalse(TestCalculator.driver.findElements(By.partialLinkText("Trinti")).isEmpty(), "Delete operation test failed.");
    }
}

//    @Test (priority = 1)
//    public void testCreateAccountButton() {
//        TestCalculator.createAccountButton();
//        Assert.assertTrue(TestCalculator.driver.getCurrentUrl().endsWith("/registruoti"), "Create account button test failed.");
//    }
//
//    @Test(dependsOnMethods = {"testCreateAccountButton"})
//    public void testSendIncorrectKeys() {
//        TestCalculator.sendIncorrectKeys();
//        TestCalculator.clickSukurtiButton();
//        TestCalculator.checkErrors();
//    }
//
//    @Test(dependsOnMethods = {"testSendIncorrectKeys"})
//    public void testSendCorrectKeys() {
//        TestCalculator.sendCorrectKeys();
//        TestCalculator.clickSukurtiCorrectButton();
//        TestCalculator.checkRegistrationSuccess();
//    }
//
//    @Test(dependsOnMethods = {"testSendCorrectKeys"})
//    public void testLogout() {
//        TestCalculator.logOut();
//        Assert.assertTrue(TestCalculator.driver.getCurrentUrl().endsWith("/prisijungti"), "Logout test failed.");
//    }
//}

