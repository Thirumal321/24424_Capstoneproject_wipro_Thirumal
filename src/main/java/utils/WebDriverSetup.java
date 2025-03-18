package utils;
import org.openqa.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WebDriverSetup {
	    public static WebDriver SelectDriver(String browser) {
	        WebDriver driver;
	        switch (browser.toLowerCase()) {
	            case "chrome":
	               driver =new ChromeDriver();
	                break;
	            case "edge":	               
	                driver = new EdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid browser: " + browser);
	        }
	        return driver;
	    }
	}