import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.InputFromsPage;



public class Main {

static WebDriver driver;



public static void main(String[] args) {



System.setProperty("webdriver.chrome.driver", "D:\\SeleniumAutomation\\ChromeDriver\\chromedriver.exe");

driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



// Navigate the URL.

driver.navigate().to("http://www.seleniumeasy.com/test/");



// Click to menu bar to get input forms

driver.findElement(By.xpath(InputFromsPage.inputFromsMenu)).click();

driver.findElement(By.xpath(InputFromsPage.simpleFromDemo)).click();



// Pass the data in the input field.

driver.findElement(By.xpath(InputFromsPage.inputMSG)).sendKeys("Hello");



// Get the button text

String BtnText = driver.findElement(By.xpath(InputFromsPage.showButton)).getText();

try {



// Call the write method

TestListener.write("DataFiles\\testData.xlsx", BtnText);

} catch (InvalidFormatException e) {

// TODO Auto-generated catch block

e.printStackTrace();

} catch (IOException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

driver.findElement(By.xpath(InputFromsPage.showButton)).click();



}



}