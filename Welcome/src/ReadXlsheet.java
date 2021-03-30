import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.InputFromsPage;
public class ReadXlsheet

{

static WebDriver driver;
public static XSSFSheet excelSheet;
public static XSSFCell cell;
public static void main(String[] args) 

	{
		
		System.setProperty("webdriver.chrome.driver","E:\\GetValet\\Practice_Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Call the method to read data from excel........ and pass two parameter path
		
		// and sheet name.
		
		excelSheet = TestListener.readExcel("DataFiles\\testData.xlsx", "Sheet1");
		
		// Navigate the URL.
		
		driver.navigate().to("http://www.seleniumeasy.com/test/");

		
		// Click to menu bar to get input forms
		
		driver.findElement(By.xpath(InputFromsPage.inputFromsMenu)).click();
		driver.findElement(By.xpath(InputFromsPage.simpleFromDemo)).click();


		
		// Get data from excelSheet.
		
		String msg = excelSheet.getRow(0).getCell(1).getStringCellValue();
		
		// Pass the data in the input field.
		
		driver.findElement(By.xpath(InputFromsPage.inputMSG)).sendKeys(msg);
		driver.findElement(By.xpath(InputFromsPage.showButton)).click();


	}

}