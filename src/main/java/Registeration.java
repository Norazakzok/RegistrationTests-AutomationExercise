import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Registeration {
    WebDriver driver;
    public Registeration(WebDriver driver){
        this.driver=driver;
    }


    public WebElement Name(){
        return driver.findElement(By.cssSelector(".signup-form > form:nth-child(2) > input:nth-child(2)"));
    }

    public WebElement EmailAddress(){
        return driver.findElement(By.cssSelector(".signup-form > form:nth-child(2) > input:nth-child(3)"));
    }
    public WebElement Title(){
        return driver.findElement(By.id("uniform-id_gender2"));
    }
    public WebElement Password(){
        return driver.findElement(By.id("password"));
    }
    public WebElement DateOfBirthDay() {
        return driver.findElement(By.id("days"));
    }

    public WebElement DateOfBirthMonth() {
        return driver.findElement(By.id("months"));
    }

    public WebElement DateOfBirthYear() {
        return driver.findElement(By.id("years"));
    }

    public void SelectDateOfBirth(String day, String month, String year) {
        Select dayDropdown = new Select(DateOfBirthDay());
        dayDropdown.selectByVisibleText(day);

        Select monthDropdown = new Select(DateOfBirthMonth());
        monthDropdown.selectByVisibleText(month);

        Select yearDropdown = new Select(DateOfBirthYear());
        yearDropdown.selectByVisibleText(year);
    }

    public WebElement NewsletterCheckbox() {
        return driver.findElement(By.id("newsletter"));
    }

    public WebElement OffersCheckbox() {
        return driver.findElement(By.id("optin"));
    }

    public WebElement FirstName() {
        return driver.findElement(By.id("first_name"));
    }

    public WebElement LastName() {
        return driver.findElement(By.id("last_name"));
    }

    public WebElement Company() {
        return driver.findElement(By.id("company"));
    }

    public WebElement Address1() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement Address2() {
        return driver.findElement(By.id("address2"));
    }

    public WebElement Country() {
        return driver.findElement(By.id("country"));
    }

    public WebElement State() {
        return driver.findElement(By.id("state"));
    }

    public WebElement City() {
        return driver.findElement(By.id("city"));
    }

    public WebElement ZipCode() {
        return driver.findElement(By.id("zipcode"));
    }

    public WebElement MobileNumber() {
        return driver.findElement(By.id("mobile_number"));
    }


    public void RegisterSteps (WebDriver driver, String Name, String EmailAddress) {
        Name().sendKeys(Name);
        EmailAddress().sendKeys(EmailAddress);
        EmailAddress().sendKeys(Keys.ENTER);
    }
    public void InformationSteps(WebDriver driver, String password, String day, String month, String year, String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        // Click on the title (Mr., Mrs.)
        Title().click();

        // Enter password
        Password().sendKeys(password);

        // Select date of birth
        SelectDateOfBirth(day, month, year);

        // Click newsletter
        WebElement newsletterCheckbox = NewsletterCheckbox();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", newsletterCheckbox);

        // Click offersCheckbox
        WebElement offersCheckbox = OffersCheckbox();
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].click();", offersCheckbox);

        // Fill in first name, last name, and company
        FirstName().sendKeys(firstName);
        LastName().sendKeys(lastName);
        Company().sendKeys(company);

        // Fill in address information
        Address1().sendKeys(address1);
        Address2().sendKeys(address2);
        Country().sendKeys(country);
        State().sendKeys(state);
        City().sendKeys(city);
        ZipCode().sendKeys(zipCode);

        // Enter mobile number
        MobileNumber().sendKeys(mobileNumber);
        MobileNumber().sendKeys(Keys.ENTER);
    }




}



