package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class RegisterPage extends BasePage{


    @FindBy(xpath = "//*[@class='martfury-login-tabs']//a[text()='Register']")
    private WebElement registerSectionLink;

    @FindBy(css="#reg_username")
    private WebElement regUsernameTextBox;

    @FindBy(css="#reg_email")
    private WebElement regEmailTextBox;

    @FindBy(css="#reg_password")
    private WebElement regPasswordTextBox;

    @FindBy(css="button[name='register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[text()='Weak - Please enter a stronger password.']")
    private List<WebElement> isPasswdWeakLabel;

    public RegisterPage(WebDriver driver) {
       super(driver);
    }



    public void switch_to_registersection() {
        wait.until(ExpectedConditions.visibilityOf(registerSectionLink));
        wait.until(ExpectedConditions.elementToBeClickable(registerSectionLink));
        registerSectionLink.click();
    }

    public void enter_regUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(regUsernameTextBox));
        regUsernameTextBox.sendKeys(username);
    }

    public void enter_regEmailaddress(String regEmail){
        wait.until(ExpectedConditions.visibilityOf(regEmailTextBox));
        regEmailTextBox.sendKeys(regEmail);
    }

    public void enter_regPassword(String regPassword){
        wait.until(ExpectedConditions.visibilityOf(regPasswordTextBox));
        regPasswordTextBox.sendKeys(regPassword);
    }

    public void sign_up(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }

    public boolean isPasswordWeak(){
      if(isPasswdWeakLabel.size()==0){
          return false;
      }
      return true;
    }
}