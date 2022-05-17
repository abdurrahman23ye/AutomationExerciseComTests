import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test5_RegisterUserWithExistingEmail {


    WebDriver driver;


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.automationexercise.com/");

    }

    @After
    public void tearsDown() {

        driver.close();
    }




    @Test
    public void test1() {


        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]")).isDisplayed());

        WebElement signUpButon=driver.
                findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));



        WebElement name= driver.findElement(By.xpath("//input[@type='text' and @data-qa='signup-name']"));

        name.click();

        name.sendKeys("abdurrahman");

        WebElement eMail= driver.findElement(By.xpath("//input[@type='email' and @data-qa='signup-email']"));

        eMail.click();

        eMail.sendKeys("abdurrahman.kursicin@gmail.com6");

        signUpButon.click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@style]")).isDisplayed());
    }

}
