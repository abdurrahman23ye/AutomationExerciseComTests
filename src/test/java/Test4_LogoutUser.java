import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test4_LogoutUser {

    WebDriver driver;


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.automationexercise.com/");

    }
/*
    @After
    public void tearsDown() {

        driver.close();
    }

 */


    @Test
    public void test1() {



        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String anasayfa1= driver.getCurrentUrl();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());

        driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']")).
                sendKeys("abdurrahman.kursicin@gmail.com");

        driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']")).
                sendKeys("sifre");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[*='abdurrahman']")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        String anaSayfa2=driver.getCurrentUrl();

        Assert.assertEquals(anasayfa1,anaSayfa2);




    }
}