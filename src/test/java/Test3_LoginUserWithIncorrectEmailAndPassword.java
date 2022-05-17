import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test3_LoginUserWithIncorrectEmailAndPassword {

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
    public void tearsDown(){

        driver.close();
    }




    @Test
    public void test1() {

        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());

        driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']")).
                sendKeys("abdurrahman.sicin@gmail.com");

        driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']")).
                sendKeys("sifr");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@style='color: red;']")).isDisplayed());




    }
}