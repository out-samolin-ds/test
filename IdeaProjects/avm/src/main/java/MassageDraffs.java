
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.logging.Logger;


//div[contains(@id,'b-letters')]//[contains(text(),'testpflb')]
//div[contains(@id,'b-letters')]//[contains(text(),'testpflb')]

public class MassageDraffs {
WebDriver webDriver;
    private static final Logger log = Logger.getAnonymousLogger();
    private By MessageDraffs = By.xpath("//*[@id=\"b-nav_folders\"]/div/div[4]/a/span");
    private By DrafssMessage = By.xpath("//*[@id=\"b-letters\"]/div[1]/div[5]/div/div[2]/div[1]/div/a/div[4]/div[3]/div[1]/div/span");
    private By WhoMessage = By.cssSelector(".js-input:nth-child(6)");
    private By SubjectMessage = By.name("Subject");
    private By SaveDraffsOk = By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[6]/div/a");

    public MassageDraffs(WebDriver webDriver) {
        this.webDriver=webDriver;
    }


    public void messegeDraffsClick (){
        new WebDriverWait(this.webDriver,10).until(ExpectedConditions.elementToBeClickable(SaveDraffsOk));
        this.webDriver.findElement(MessageDraffs).click();
        log.info("Нажата кнопка Черновики");
    }

    public void checMessageDraffs (String text){
        Assert.assertTrue(this.webDriver.findElement(DrafssMessage).getText().contains(text));

    }
    public void openDraffsMessage () {
        this.webDriver.findElement(DrafssMessage).click();
        log.info("Открыть черновик");
        Assert.assertNotNull(this.webDriver.findElement(WhoMessage).getText());
        log.info("Черновик успешно открыт");
    }
    public void checkDraffs (String text) {

        try {this.webDriver.findElement(By.xpath("//*[@id='b-letters']//*[text()='"+text+"']")); }
        catch (NoSuchElementException e){
            log.info("Черновик не найден");
        }
    }
}

