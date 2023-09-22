import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Almosafer01 {
	WebDriver driver = new ChromeDriver();
	SoftAssert myAssertions = new SoftAssert();
@BeforeTest
public void beforeTest() {
	driver.get("https://www.almosafer.com/ar");
	driver.manage().window().maximize();
	driver.findElement(By.className("cta__button")).click();
}


@Test
public void test() {
//  ("Make sure that the default currency is SAR")
    WebElement currency = driver.findElement(By.cssSelector("[data-testid='Header__CurrencySelector']"));
    String currencyText = currency.getText();
    assert currencyText.contains("SAR") : "Currency is not SAR";
    
//  ("Make sure that the default langauge is Arabic")
    WebElement language = driver.findElement(By.cssSelector("[data-testid='Header__LanguageSwitch']"));
    String languageText = language.getText();
    assert languageText.contains("English") : "Language is not Arabic";
    
//  ("Make sure that the flight tab is clicked by default")
    WebElement flights = driver.findElement(By.id("uncontrolled-tab-example-tab-flights"));
    String flightsTab = flights.getAttribute("class");
    assert flightsTab.contains("active") : "Flight tab is not active by default";
}

@AfterTest
public void afterTest() {
    driver.quit();

}
}
