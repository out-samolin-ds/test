import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPFLB {
    //1test
    private String login = "testpflb";
    private String password = "test219011";
    private String URL_mail = "https://mail.ru";

    //2test
    private  String who = "testpflb@mail.ru";
    private  String sabject = "test";
    private  String text = "Test Message"+ Math.random() *100;;
    WebDriver webDriver;

    // test
    private String textDraffs= text+" -- Jonatan Vilmus";

    @BeforeMethod
    public void SetUp (){
        this.webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.webDriver.get(URL_mail);
        new MailMainPage(this.webDriver).login(login,password);
    }
    @Test  //авторизация в почте
    public void LoginMail  (){
        new BasicBoxMassages(this.webDriver).logOK();

    }
    @Test //создание нового письма и письмо отправляется
    public void CreateMessage ()  {
        new BasicBoxMassages(this.webDriver).OpenCreateMessege();
        new CreateLetter(this.webDriver).setMessage(who,sabject,text);
        new CreateLetter(this.webDriver).sendClick();
        new CreateLetter(this.webDriver).sendMessageNorm();
    }
    @Test //созданное письмо корректно сохраняется в качестве черновика
    public void SaveDraffs ()  {
        new BasicBoxMassages(this.webDriver).OpenCreateMessege();
        new CreateLetter(this.webDriver).setMessage(who,sabject,text);
        new CreateLetter(this.webDriver).saveClick();
        new CreateLetter(this.webDriver).saveDraffClick();
        new MassageDraffs(this.webDriver).messegeDraffsClick();
        new MassageDraffs(this.webDriver).checMessageDraffs(text);
    }
    @Test //черновик открывается
    public void checkDraffsMessage ()  {
        new BasicBoxMassages(this.webDriver).OpenCreateMessege();
        new CreateLetter(this.webDriver).setMessage(who,sabject,text);
        new MassageDraffs(this.webDriver).messegeDraffsClick();
        new MassageDraffs(this.webDriver).openDraffsMessage();
    }

    @Test    //  в черновике корректно сохранены адресат, тема письма и тело письма
    public void checkSabjectAdressDraffs () {
        new BasicBoxMassages(this.webDriver).OpenCreateMessege();
        new CreateLetter(this.webDriver).setMessage(who,sabject,text);
        new CreateLetter(this.webDriver).saveClick();
        new CreateLetter(this.webDriver).saveDraffClick();
        new MassageDraffs(this.webDriver).messegeDraffsClick();
        new MassageDraffs(this.webDriver).openDraffsMessage();
        new CreateLetter(this.webDriver).checkMessageSubjectText(who,sabject,text);  // тут фейлится нужна доработка
    }
    @Test   // письмо удаляется из черновиков после отправки
    public void draffsSend () {
        new BasicBoxMassages(this.webDriver).OpenCreateMessege();
        new CreateLetter(this.webDriver).setMessage(who,sabject,text);
        new CreateLetter(this.webDriver).saveClick();
        new CreateLetter(this.webDriver).saveDraffClick();
        new MassageDraffs(this.webDriver).messegeDraffsClick();
        new CreateLetter(this.webDriver).sendClick();
        new CreateLetter(this.webDriver).sendMessageNorm();
        new MassageDraffs(this.webDriver).messegeDraffsClick();
        new MassageDraffs(this.webDriver).checkDraffs(textDraffs);

    }


    @Test // выход из учётной записи происходит корректно
    public void escMail () {
        new BasicBoxMassages(this.webDriver).exitMail();
    }
    @AfterMethod
    public void tearDown () {this.webDriver.close(); }
}
