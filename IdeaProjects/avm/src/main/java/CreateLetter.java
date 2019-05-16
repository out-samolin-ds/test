import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.logging.Logger;

public class CreateLetter{
WebDriver webDriver;

    // Elements
    private static final Logger log = Logger.getAnonymousLogger();
    private By WhoMessage = By.cssSelector(".js-input:nth-child(6)");
    private By SubjectMessage = By.name("Subject");
    private By TextMessage = By.id("tinymce");
    private By SendMessageClick = By.xpath("//div[contains(@class,'b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut')]//span");
    private By SendMessageOK = By.xpath("//div[contains(@class, 'message-sent__title')]");
    private By save = By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[2]/div/div[3]/div[1]/div");
    private By saveDraff = By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[2]/div/div[3]/div[2]/a[1]");
    private By WhoMessageDraffs = By.xpath("//*[@id=\"toolkit-155772266247944composeForm\"]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/span[2]/span[2]");

    public CreateLetter(WebDriver webDriver) {
        this.webDriver=webDriver;

    }


    public void setMessage (String who, String subject, String text) {
        this.webDriver.findElement(WhoMessage).sendKeys(who);
        log.info("Заполено поле от Кому ");
        this.webDriver.findElement(SubjectMessage).sendKeys(subject);
        log.info("Заполнено поле Тема");
        this.webDriver.switchTo().frame(0).findElement(TextMessage).sendKeys(text);
        log.info("Заполнен текст письма");
        this.webDriver.switchTo().window(this.webDriver.getWindowHandle());
    }


    public void sendClick (){

        this.webDriver.findElement(SendMessageClick).click();
        log.info("Нажата кнопка отправить");
    }

    public void sendMessageNorm (){
        Assert.assertTrue(this.webDriver.findElement(SendMessageOK).getText().equals("Ваше письмо отправлено. Перейти во Входящие"));
        log.info("Письмо отправлено");
    }
    public void saveClick (){this.webDriver.findElement(save).click();
        log.info("Нажата кнопка Сохранить");

    }
    public void saveDraffClick () {this.webDriver.findElement(saveDraff).click();
        log.info("Нажата кнопка Сохранить в чернавиках ");
    }

    public void checkMessageSubjectText (String message,String subject,String text){
        Assert.assertTrue(this.webDriver.findElement(WhoMessageDraffs).getText().equals(message));
        log.info("Прверка по полю Кому - успшна");
        Assert.assertTrue(this.webDriver.findElement(SubjectMessage).getText().equals(subject));
        log.info("Прверка по полю Тема - успшна");
        Assert.assertTrue(this.webDriver.findElement(TextMessage).getText().equals(text+" -- Jonatan Vilmus"));
        log.info("Прверка по полю Текст письма - успшна");

    }

}
