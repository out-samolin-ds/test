import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String args[ ]) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        webDriver.get("https://mail.ru/?from=logout");
        webDriver.findElement(By.id("mailbox:login")).sendKeys("testpflb");
        webDriver.findElement(By.id("mailbox:password")).sendKeys("test219011");
        webDriver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input")).click();

        webDriver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span")).click();
        webDriver.findElement(By.cssSelector(".js-input:nth-child(6)")).sendKeys("testpflb@mail.ru");
        webDriver.findElement(By.name("Subject")).sendKeys("test");
        webDriver.findElement(By.xpath("//td[contains(@class, 'mceIframeContainer')]/iframe"));
        webDriver.switchTo().frame(0).findElement(By.id("tinymce")).sendKeys("tratata");
        webDriver.findElement(By.cssSelector("#b-toolbar__right .b-toolbar__item_ .b-toolbar__btn__text")).click();




        }

    }

