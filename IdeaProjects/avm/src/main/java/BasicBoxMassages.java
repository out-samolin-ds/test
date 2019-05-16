import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasicBoxMassages {
     WebDriver webDriver;
     private static final Logger log = Logger.getAnonymousLogger();
     private By clickNewMessage = By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span");
     private By logOut = By.id("PH_logoutLink");
     private By LogOk = By.id("PH_user-email");

     public BasicBoxMassages(WebDriver webDriver) {
          this.webDriver=webDriver;
     }


     public void OpenCreateMessege (){
          this.webDriver.findElement(clickNewMessage).click(); log.info("Кликнуть на кнопку Новое сообщение");
     }
     public void logOK(){
          this.webDriver.findElement(LogOk); log.info("Залогинился успешно");;
     }
     public void exitMail (){
          new WebDriverWait(this.webDriver,10).until(ExpectedConditions.elementToBeClickable(logOut));
          this.webDriver.findElement(logOut).click();
          log.info("Вышел из почты");
     }
}
