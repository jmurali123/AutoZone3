package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css="ul>li.woocommerce-MyAccount-navigation-link--customer-logout>a")
    private WebElement logoutlink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void SignoutLinkclicked(){
        wait.until(ExpectedConditions.visibilityOf(logoutlink));
        wait.until(ExpectedConditions.elementToBeClickable(logoutlink));
        WebElement ele=logoutlink;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ele);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ele);
      //  ele.click();

    }

    public void load(String url){
        driver.get(url);
    }

}
