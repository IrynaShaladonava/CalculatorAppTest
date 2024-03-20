import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestCalculator {

    public static WebDriver driver;

    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://localhost:8080/prisijungti");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

//    public static void createAccountButton(){
//
//        WebElement createAccountButton = driver.findElement(By.cssSelector("a[href='/registruoti']"));
//        createAccountButton.click();
//    }
//
//    public static void sendIncorrectKeys(){
//
//        WebElement name = driver.findElement(By.id("username"));
//        name.sendKeys("Iryna");
//
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("12");
//
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement passwordConfirm = driver.findElement(By.id("passwordConfirm"));
//        passwordConfirm.sendKeys("123");
//
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public static void clickSukurtiButton() {
//        WebElement sukurtiButton = driver.findElement(By.cssSelector("button.btn-primary")); // используем CSS-селектор
//        sukurtiButton.click();
//    }
//
//    public static void checkErrors() {
//        WebElement passwordError = driver.findElement(By.id("password.errors"));
//        String passwordErrorText = passwordError.getText();
//        System.out.println("Password errors: " + passwordErrorText);
//
//        WebElement passwordConfirmError = driver.findElement(By.id("passwordConfirm.errors"));
//        String passwordConfirmErrorText = passwordConfirmError.getText();
//        System.out.println("Password confirm errors: " + passwordConfirmErrorText);
//
//}
//
//    public static void clearForm() {
//        WebElement nameField = driver.findElement(By.id("username"));
//        nameField.clear();
//
//        WebElement passwordField = driver.findElement(By.id("password")); // Находим поле ввода пароля
//        passwordField.clear(); // Очищаем значение поля ввода
//
//        WebElement passwordConfirmField = driver.findElement(By.id("passwordConfirm")); // Находим поле ввода подтверждения пароля
//        passwordConfirmField.clear(); // Очищаем значение поля ввода
//    }
//
//    public static void sendCorrectKeys(){
//
//        WebElement nameCorrect = driver.findElement(By.id("username"));
//        nameCorrect.sendKeys("Irina");
//
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement passwordCorrect = driver.findElement(By.id("password"));
//        passwordCorrect.sendKeys("12345");
//
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement passwordCorrectConfirm = driver.findElement(By.id("passwordConfirm"));
//        passwordCorrectConfirm.sendKeys("12345");
//    }
//
//    public static void clickSukurtiCorrectButton() {
//        WebElement sukurtiButton = driver.findElement(By.cssSelector("button.btn-primary")); // используем CSS-селектор
//        sukurtiButton.click();
//    }
//
//    public static void checkRegistrationSuccess() {
//        String expectedTitle = "Skaičiuotuvas"; // Замените это на ожидаемый заголовок
//
//        String currentTitle = driver.getTitle(); // Получаем текущий заголовок страницы
//
//        if (currentTitle.equals(expectedTitle)) {
//            System.out.println("Registracija sėkminga!");
//        } else {
//            System.out.println("Klaida. Nepavyko užregistruoti.");
//        }
//    }


//    public static void logOut(){
//
//        WebElement logOutBtn = driver.findElement(By.id("logoutForm"));
//        logOutBtn.submit();
//
//    }

    public static void logInNegative(){

        WebElement logInName = driver.findElement(By.name("username"));
        logInName.sendKeys("Irina");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement logInPassword = driver.findElement(By.name("password"));
        logInPassword.sendKeys("123456");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement btnLogIn = driver.findElement(By.xpath("//button[contains(text(), 'Prisijungti')]"));
        btnLogIn.click();

    }



    public static void checkLoginResultNegative() {
        String expectedTitle = "Skaičiuotuvas"; // Ожидаемый заголовок вашей страницы
        String errorMessageXpath = "//span[contains(text(), 'Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi')]";

        if (!driver.getTitle().equals(expectedTitle)) {
            WebElement errorMessage = driver.findElement(By.xpath(errorMessageXpath));
            String errorText = errorMessage.getText();
            System.out.println("Klaida: " + errorText);
        } else {
            System.out.println("Prisijungimas sėkmingas.");
        }
    }

    public static void logInPositive(){

        WebElement logInName = driver.findElement(By.name("username"));
        logInName.sendKeys("Irina");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement logInPassword = driver.findElement(By.name("password"));
        logInPassword.sendKeys("12345");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement btnLogIn = driver.findElement(By.xpath("//button[contains(text(), 'Prisijungti')]"));
        btnLogIn.click();

    }


    public static void checkLoginResultPositive() {
        String expectedTitle = "Skaičiuotuvas"; // Ожидаемый заголовок вашей страницы
        String errorMessageXpath = "//span[contains(text(), 'Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi')]";

        if (!driver.getTitle().equals(expectedTitle)) {
            WebElement errorMessage = driver.findElement(By.xpath(errorMessageXpath));
            String errorText = errorMessage.getText();
            System.out.println("Klaida: " + errorText);
        } else {
            System.out.println("Prisijungimas sėkmingas.");
        }


    }

    public static void clearFields(){
        WebElement firstClear = driver.findElement(By.id("sk1"));
        firstClear.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement secondClear = driver.findElement(By.id("sk2"));
        secondClear.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sendOperationsNegative() {
        WebElement first = driver.findElement(By.id("sk1"));
        first.sendKeys("999");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement second = driver.findElement(By.id("sk2"));
        second.sendKeys("0");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement selectOperation = driver.findElement(By.name("zenklas"));
        Select select = new Select(selectOperation);

        select.selectByVisibleText("Dalyba");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit'][value='skaičiuoti']"));
        submitBtn.click();

        String pageSource = driver.getPageSource();
        if (pageSource.contains("Error")) {
            System.out.println("Klaida");
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void goBack(){
        driver.navigate().back();
    }

    public static void clearFieldsAgain(){
        WebElement firstClear = driver.findElement(By.id("sk1"));
        firstClear.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement secondClear = driver.findElement(By.id("sk2"));
        secondClear.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sendOperationsPositive(){
        WebElement first = driver.findElement(By.id("sk1"));
        first.sendKeys("999");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement second = driver.findElement(By.id("sk2"));
        second.sendKeys("99");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement selectOperation = driver.findElement(By.name("zenklas"));
        Select select = new Select(selectOperation);

        select.selectByVisibleText("Dalyba");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit'][value='skaičiuoti']"));
        submitBtn.click();

        WebElement resultElement = driver.findElement(By.tagName("h4"));
        String resultText = resultElement.getText();
        System.out.println("Dalybos resultatas: " + resultText);


    }

    public static void findResult(){
        WebElement resultPage = driver.findElement(By.linkText("Atliktos operacijos"));
        resultPage.click();
    }



    public static void findDivisionResultNegative() {
        List<WebElement> elements = driver.findElements(By.tagName("tr"));

        String desiredText = "9999";

        boolean found = false;
        for (WebElement element : elements) {
            if (element.getText().contains(desiredText)) {
                System.out.println("Įrašas rastas " + element.getText());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Įrašas su tekstu '" + desiredText + "' nerastas.");
        }
    }

    public static void findDivisionResult() {
        List<WebElement> elements = driver.findElements(By.tagName("tr"));

        String desiredText = "999";

        for (WebElement element : elements) {
            if (element.getText().contains(desiredText)) {
                System.out.println("Rastas įrašas: " + element.getText());
                break;
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickKeistiInLastRow() {

        WebElement lastRow = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]"));
        scrollToElement(lastRow);

        WebElement keistiButton = lastRow.findElement(By.partialLinkText("Keisti"));
        keistiButton.click();

    }

    public static void clearFieldsToRenew(){
        WebElement firstSk = driver.findElement(By.name("sk1"));
        firstSk.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement zenklas = driver.findElement(By.name("zenklas"));
        zenklas.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement secondSk = driver.findElement(By.name("sk2"));
        secondSk.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.name("rezult"));
        result.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void newInformation(){
        WebElement firstNew = driver.findElement(By.name("sk1"));
        firstNew.sendKeys("888");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement zenklasNew = driver.findElement(By.name("zenklas"));
        zenklasNew.sendKeys("+");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement secondNew = driver.findElement(By.name("sk2"));
        secondNew.sendKeys("112");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement resultNew = driver.findElement(By.name("rezult"));
        resultNew.sendKeys("1000");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement buttonRenew = driver.findElement(By.xpath("//input[@value='Atnaujinti']"));
        buttonRenew.click();

        String pageSource = driver.getPageSource();
        if (pageSource.contains("Id")) {
            System.out.println("Naujas įrašas priimtas");
        }


    }

    public static void newInformationNegative(){
        WebElement backPage = driver.findElement(By.className("button"));
        backPage.click();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void scrollToElementForNegative(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickKeistiInLastRowForNegative() {

        WebElement lastRow = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]"));
        scrollToElement(lastRow);

        WebElement keistiButton = lastRow.findElement(By.partialLinkText("Keisti"));
        keistiButton.click();

    }

    public static void clearFieldsToRenewForNegative(){
        WebElement firstSk = driver.findElement(By.name("sk1"));
        firstSk.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement zenklas = driver.findElement(By.name("zenklas"));
        zenklas.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement secondSk = driver.findElement(By.name("sk2"));
        secondSk.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.name("rezult"));
        result.clear();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void newInformationForNegative() {
        WebElement firstNew = driver.findElement(By.name("sk1"));
        firstNew.sendKeys("888");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement zenklasNew = driver.findElement(By.name("zenklas"));
        zenklasNew.sendKeys("/");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement resultNew = driver.findElement(By.name("rezult"));
        resultNew.sendKeys("1000");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement buttonRenew = driver.findElement(By.xpath("//input[@value='Atnaujinti']"));
        buttonRenew.click();

        String pageSource = driver.getPageSource();
        if (pageSource.contains("Error")) {
            System.out.println("Naujas įrašas nesėkmingas. Bandykite dar kartą.");
        }

    }

    public static void goBackAgain(){
        driver.navigate().back();
    }

    public static void deleteOperationNegative(){
        WebElement operations = driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li/a"));
        operations.click();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement lastRow = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]"));
        scrollToElement(lastRow);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement deleteButton = lastRow.findElement(By.partialLinkText("Trinti"));
        deleteButton.click();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        if (!driver.findElements(By.partialLinkText("Trinti")).isEmpty()) {
            System.out.println("Отмена удаления успешно обработана. Элемент не был удален.");
        } else {
            System.out.println("Отмена удаления не сработала. Элемент был удален некорректно.");
        }

    }

    public static void deleteOperation(){

        WebElement lastRow = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]"));
        scrollToElement(lastRow);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement deleteButton = lastRow.findElement(By.partialLinkText("Trinti"));
        deleteButton.click();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


        public static void main(String[] args) throws InterruptedException {
        setup();
//        createAccountButton();
//        sendIncorrectKeys();
//        clickSukurtiButton();
//        checkErrors();
//        clearForm();
//        sendCorrectKeys();
//        clickSukurtiCorrectButton();
//        checkRegistrationSuccess();
//        logOut();
        logInNegative();
        checkLoginResultNegative();
        logInPositive();
        checkLoginResultPositive();
        clearFields();
        sendOperationsNegative();
        goBack();
        clearFieldsAgain();
        sendOperationsPositive();
        findResult();
        findDivisionResultNegative();
        findDivisionResult();

        WebElement lastRow = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]"));
        scrollToElement(lastRow);

        clickKeistiInLastRow();
        clearFieldsToRenew();
        newInformation();
        newInformationNegative();

        WebElement lastRowNegative = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[last()]"));
        scrollToElementForNegative(lastRowNegative);

        clickKeistiInLastRowForNegative();
        clearFieldsToRenewForNegative();
        newInformationForNegative();
        goBackAgain();
        deleteOperationNegative();
        deleteOperation();

    }
}
