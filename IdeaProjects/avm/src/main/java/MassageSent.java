import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MassageSent extends BasicBoxMassages{
    private By MessageSendClick = By.xpath("//*[@id=\"b-nav_folders\"]/div/div[3]/a/span");

    public MassageSent(WebDriver webDriver) {
        super(webDriver);
    }
}
