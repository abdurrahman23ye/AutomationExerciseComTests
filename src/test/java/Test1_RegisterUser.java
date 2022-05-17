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

public class Test1_RegisterUser {

    WebDriver driver;


    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.automationexercise.com/");

    }

    @After
    public void tearsDown(){

        driver.close();
    }



    @Test
    public void test1(){

        WebElement homePage=driver.findElement(By.xpath("//html"));

        Assert.assertTrue(homePage.isDisplayed());


       WebElement login=driver.findElement(By.xpath("//a[@href='/login']"));

       login.click();

        WebElement signUpButon=driver.
                findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));


        Assert.assertTrue(signUpButon.isDisplayed());

       WebElement name= driver.findElement(By.xpath("//input[@type='text' and @data-qa='signup-name']"));

       name.click();

        name.sendKeys("abdurrahman");

        WebElement eMail= driver.findElement(By.xpath("//input[@type='email' and @data-qa='signup-email']"));

        eMail.click();

        eMail.sendKeys("abdurrahman.kursicin@gmail.com6");

        signUpButon.click();

        driver.findElement(By.xpath("//input[@type='radio' and @name='title']")).click();
        driver.findElement(By.xpath("//input[@type='password' and @id='password']")).click();
        driver.findElement(By.xpath("//input[@type='password' and @id='password']")).sendKeys("sifre");

        driver.findElement(By.xpath("//select[@data-qa='days' and @id='days']")).sendKeys("10");
        driver.findElement(By.xpath("//select[@data-qa='months' and @id='months']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@data-qa='years' and @id='years']")).sendKeys("1990");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='first_name']")).sendKeys("yusuf");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='last_name']")).sendKeys("soyisim");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='company']")).sendKeys("firma");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='address']")).sendKeys("Istanbul");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='address2']")).sendKeys("Turkey");
        driver.findElement(By.xpath("//select[@data-qa='country']")).sendKeys("Canada");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='state']")).sendKeys("State yok");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='city']")).sendKeys("Elazig");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='zipcode']")).sendKeys("34100");
        driver.findElement(By.xpath("//input[@type='text' and @data-qa='mobile_number']")).sendKeys("344545100");
     driver.findElement(By.xpath("//button[@type='submit']")).click();

     Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());

     driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

     Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'abdurrahman')]")).isDisplayed());

        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

       Assert.assertTrue( driver.findElement(By.xpath("//button[@class='btn btn-danger']")).isDisplayed());

        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();


    }
}
