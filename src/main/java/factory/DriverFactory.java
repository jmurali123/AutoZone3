package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    public static WebDriver initializeDriver(String browser)  {
        WebDriver driver=null;
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options= new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("start-maximized");

               // driver=new RemoteWebDriver(new URL("http://192.168.0.129:4444"), options);
                driver= new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
              //  driver=new RemoteWebDriver(new URL("http://192.168.0.129:4444"), firefoxOptions);
                driver= new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
                break;
            default:
                System.out.println("Invalid browser "+browser);
                break;
        }
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }
}
