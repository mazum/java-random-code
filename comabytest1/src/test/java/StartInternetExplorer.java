import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;

public class StartInternetExplorer {

    @Test
    public static void test1(){
        WebDriver driver=startInternetExplorer();
        driver.get("https://www.google.com.au/");
        driver.quit();
        //This code to handle driver.quit()/close() which doesn't close the IE Driver instance.
        try {
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
            Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver startInternetExplorer(){
        WebDriver driver;
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        InternetExplorerOptions options=new InternetExplorerOptions(capabilities);
        System.setProperty("webdriver.ie.driver","C:\\Users\\abhishek.mazumder\\Downloads\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
        driver= new InternetExplorerDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}