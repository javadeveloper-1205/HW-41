package core.HW_41;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firefox {
	static Properties p = new Properties();
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		Logger.getLogger("").setLevel(Level.OFF);
		String driverPath = "";

		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "firefox.sh";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "c:\\windows\\geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");

		System.setProperty("webdriver.gecko.driver", driverPath);
		System.out.println("Browser: Firefox");
		System.out.println("===================================================");
		driver = new FirefoxDriver();
		driver.get(p.getProperty("url"));
		System.out.println("Page URI: " + driver.getCurrentUrl());
		System.out.println("Page Title: " + driver.getTitle());
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("fname_id"))))
.sendKeys(p.getProperty("fname_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("lname_id"))))
.sendKeys(p.getProperty("lname_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("email_id"))))
.sendKeys(p.getProperty("email_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("phone_id"))))
.sendKeys(p.getProperty("phone_value"));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("submit_id"))))
.click();

System.out.println("===================================================");
System.out.println("Page URI: "   + driver.getCurrentUrl());
System.out.println("Page Title: " + driver.getTitle());
System.out.println("First Name: " + driver.findElement(By.id(p.getProperty("fname_id"))).getText());
System.out.println("Last Name: "  + driver.findElement(By.id(p.getProperty("lname_id"))).getText());
System.out.println("Email: "      + driver.findElement(By.id(p.getProperty("email_id"))).getText());
System.out.println("Phone: "      + driver.findElement(By.id(p.getProperty("phone_id"))).getText());
		driver.quit();

}
}