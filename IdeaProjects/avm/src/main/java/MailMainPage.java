import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailMainPage {
    //авторизация в почте
            private WebDriver webDriver;

            private By NameBox =  By.id("mailbox:login");
            private By PasswordBox = By.id("mailbox:password");
            private By loginClick = By.xpath("//*[@id=\"mailbox:submit\"]/input");

    public MailMainPage(WebDriver webDriver){
        this.webDriver = webDriver;


    }
    public void login (String BASIC_LOG, String BASIC_PASSWORD){
        WebElement Name = this.webDriver.findElement(NameBox);
        Name.sendKeys(BASIC_LOG);
        WebElement Password = this.webDriver.findElement(PasswordBox);
        Password.sendKeys(BASIC_PASSWORD);
        this.webDriver.findElement(loginClick).click();
    }

    }


