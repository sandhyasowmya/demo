package IMSS_P1.demo;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class pgmTest extends pgm1
{
	  static WebDriver driver;
	@BeforeTest
	public void url(){
//		System.setProperty("webdriver.chrome.driver","D:\\sandhya_Wspace\\tms_script\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();	
		System.setProperty("webdriver.gecko.driver","D:\\sandhya_Wspace\\tms_script\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();

	}
	
	public void frame() throws InterruptedException
	{
		 driver.get("http://demo.automationtesting.in/Frames.html");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		//System.out.println("switched to frame");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Demo");
		driver.switchTo().frame(1);
		
	}
	
	public void autocomplete() throws InterruptedException
	{
		String textToSelect = "india";
		driver.get("http://demo.automationtesting.in/AutoComplete.html");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> el=driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for(WebElement i:el)
		{
		if(textToSelect.equalsIgnoreCase(i.getText()))
		
			{
			    i.click();
		        break;
			}
		}
		}
//		el.get(2).click();
		
	
	public void slider() throws InterruptedException{
		driver.get("http://demo.automationtesting.in/Slider.html");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement r = driver.findElement(By.xpath("//div[@id='slider']"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(r, 200, 0).perform();
	}

	
public void datepicker() throws InterruptedException
  {

	driver.get("http://demo.automationtesting.in/Datepicker.html");
	Thread.sleep(1000);
	
	Thread.sleep(3000);
//	WebDriverWait as=new WebDriverWait(driver,20);
//	WebElement wait1=as.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datepicker2']")));
//	wait1.click();
	driver.findElement(By.xpath("//input[@id='datepicker2']")).click();

	Select sc=new Select(driver.findElement(By.xpath("//select[@title='Change the month']")));
	sc.selectByVisibleText("January");
	Select year=new Select(driver.findElement(By.xpath("//select[@title='Change the year']")));
	year.selectByVisibleText("2009");
	List<WebElement> col =driver.findElements(By.tagName("td"));
	for(WebElement w:col)
	{
		if(w.getText().equals("13")){
			w.findElement(By.linkText("13")).click();
			break;
		}
	}
}

//incomplete
    
    public void DragAndDrop() throws InterruptedException {
    driver.get("http://demo.automationtesting.in/Static.html");
    driver.manage().window().maximize();
    Thread.sleep(1000);
	WebElement img1=driver.findElement(By.xpath("//img[@id='mongo']"));
	Thread.sleep(1000);
	WebElement target1=driver.findElement(By.xpath("//div[@id='droparea']"));
	Actions ActImg = new Actions(driver);
	Thread.sleep(1000);
	ActImg.dragAndDrop(img1, target1).build().perform();
	System.out.println("done");
//	Action DA= (Action) ActImg.clickAndHold(img1).moveToElement(target1).release(target1).build();
	//DA.perform();
	//ActImg.dragAndDropBy(img1, 100, 0).perform();
    }
    
    
   
public void filedownload() throws InterruptedException{
	String downloadPath = "C:/Users/sandhya/Downloads/";
	driver.get("http://demo.automationtesting.in/FileDownload.html");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	Thread.sleep(20000);
	 Assert.assertTrue(isFileDownloaded(downloadPath, "samplefile.pdf"), "Failed to download Expected document");
	 System.out.println("downloaded sucessfully");
}

	private boolean isFileDownloaded(String downloadPath, String string) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void fileupload() throws InterruptedException{
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		String r = "C:\\Users\\sandhya\\Desktop\\abababa";
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\sandhya\\Desktop\\abababa.txt");
	}
	 @Test
  public void jqueryProcessBar(){
	  driver.get("http://demo.automationtesting.in/JqueryProgressBar.html");
	  //Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
	  WebDriverWait wt = new WebDriverWait(driver, 20);
	  WebElement wt1=wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Close']")));
	  wt1.click();
	  
  }

}

