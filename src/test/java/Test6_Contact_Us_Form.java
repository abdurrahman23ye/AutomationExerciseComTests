import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        public void test1() throws InterruptedException {


            Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());

            driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

            Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed());

            driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ali");
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ali@");
            driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("olaylar olaylar");
            driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("mesaj");
            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@type='file']")).click();


        }

    }