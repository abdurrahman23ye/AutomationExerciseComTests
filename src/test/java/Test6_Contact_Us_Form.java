import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Test6_Contact_Us_Form {




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
        public void test1() throws InterruptedException, AWTException {


            Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());

            driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

            Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed());

            driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ali");
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ali@gmail.com");
            driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("olaylar olaylar");
            driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("mesaj");

            JavascriptExecutor xy= (JavascriptExecutor) driver;

            xy.executeScript("window.scrollBy(0,1000)");

            WebElement file=driver.findElement(By.xpath("//input[@type='file']"));

            file.
                    sendKeys("C:\\Users\\asus\\IdeaProjects\\AutomationExerciseComTests\\src\\test\\java\\290.txt");

            driver.findElement(By.xpath("//input[@type='submit']")).click();

            driver.switchTo().alert().accept();

            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());
            driver.findElement(By.xpath("//span")).click();

            Assert.assertTrue(driver.findElement(By.xpath("//html")).isEnabled());


















        }

    }