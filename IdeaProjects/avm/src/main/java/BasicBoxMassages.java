import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicBoxMassages {
     WebDriver webDriver;
     private By clickNewMessage = By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span");
     private By logOut = By.id("PH_logoutLink");
     private By LogOk = By.id("PH_user-email");

     public BasicBoxMassages(WebDriver webDriver) {
          this.webDriver=webDriver;
     }


     public void OpenCreateMessege (){
          this.webDriver.findElement(clickNewMessage).click();
     }
     public void logOK(){
          this.webDriver.findElement(LogOk);
     }
     public void exitMail (){this.webDriver.findElement(logOut).click();}
}
