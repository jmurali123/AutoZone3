package hooks;

import context.DriverContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BeforeAfterHook {

//commit from DEV remote
//commit from featurebranch
    private WebDriver driver;
    private final DriverContext context;

    public BeforeAfterHook(DriverContext context){
        this.context=context;
    }

    @Before
    public void before(Scenario scenario){
        System.out.println(scenario.getName());
        driver=DriverFactory.initializeDriver(System.getProperty("browser","firefox"));
        context.driver=driver;
    }

    @After
    public void after(Scenario scenario){
        System.out.println(scenario.getName());
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()){
          final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
          scenario.attach(screenshot,"image/png","image");
        }
    }
}
