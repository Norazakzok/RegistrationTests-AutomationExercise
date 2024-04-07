import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestScenarios {
    WebDriver driver ;
    Registeration Register;
    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        Register=new Registeration(driver);
        }
    @Test
    public void  RegisterUser()throws InterruptedException {
        driver.get("https://automationexercise.com/");

        //Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

        //Click on 'Signup / Login' button
        WebElement newRegister = driver.findElement(By.cssSelector(".navbar-nav > li:nth-child(4) > a:nth-child(1)"));
        newRegister.click();

        //Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/h2"));
        Assert.assertTrue(newUserSignup.isDisplayed(), "'New User Signup!' is not visible on the webpage");

        //Enter name and email address
        Register.RegisterSteps(driver,"Nora","bnbn@gmail.com");
        Thread.sleep(1000);

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement info = driver.findElement(By.cssSelector(" h2.title:nth-child(1) > b:nth-child(1)"));
        Assert.assertTrue(info.isDisplayed(), "'Enter Account Information' is not visible on the webpage");

        // Fill details
        Register.InformationSteps(driver, "yourPassword", "22", "November", "2001", "Nora", "Zakzok", "ITI", "123 El Tahrir St", "", "Egypt", "ff", "Cairo", "12345", "0123456789");
        Thread.sleep(1000);

        //Verify that 'ACCOUNT CREATED!' is visible
        WebElement acc = driver.findElement(By.cssSelector(".title > b:nth-child(1)"));
        Assert.assertTrue(acc.isDisplayed(), "'Account Created!' is not visible on the webpage");

        // Click 'Continue' button
        WebElement cont= driver.findElement(By.cssSelector("a.btn"));
        cont.click();

        Thread.sleep(1000);
        //Verify that 'Logged in as username' is visible
        WebElement login = driver.findElement(By.cssSelector(".navbar-nav > li:nth-child(10) > a:nth-child(1)"));
        Assert.assertTrue(login.isDisplayed(), "'Logged in as username' is not visible on the webpage");

        //Click 'Logout' button
        WebElement logout= driver.findElement(By.cssSelector(".navbar-nav > li:nth-child(4) > a:nth-child(1)"));
        logout.click();


        Thread.sleep(1000);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
