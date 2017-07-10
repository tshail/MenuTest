package Admin;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class MenuTEST extends RW{

	private static ExtentReports report;
	public synchronized static ExtentReports getReporter(String filePath) { 
	    if (report == null) {
	        report = new ExtentReports(path.concat("Report.html"));
	      
	        report
	            .addSystemInfo("Host Name", "Reshma") 
	            .addSystemInfo("Environment", "QA");
	    }
	    
	    return report;
	}


	public void admin(WebDriver driver1) throws Exception {  
		 ArrayList<Row> row1=Input_Testing.searchSheet("Admin", 0,0);
		 
		 for(int i=0;i<row1.size();i++)
			{
			 WebDriver driver = driver1;
				String url=row1.get(i).getCell(2).toString();
				
				Thread.sleep(3000);
				
				
				driver.get(url);
				
				String title=driver.getTitle();
				
				Thread.sleep(5000);
				
				//logo verificatn
				//if(LOGO.FALSE){
				try
				{
				Boolean LOGO=driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[3]/div[1]/div[1]/img")).isDisplayed();
		     // System.out.println("True"+LOGO);
			   if(LOGO.FALSE)
				{
				   String URL_Error=driver.getCurrentUrl();
					SShot (driver);
					//System.out.println(url.concat("- Fail"));
					System.out.println(URL_Error);
					
				}
				else{
					if(title.equalsIgnoreCase("Home Page"))
							{
						System.out.println(url.concat("- Access Not Available"));
					}
					else{
						System.out.println(url.concat("- Pass"));
					}
					
				}
				}catch (Exception e) {
					System.out.print(e.getMessage());
					SShot (driver);
					System.out.println(url.concat("- Fail"));
					// TODO: handle exception
				}	
				Thread.sleep(4000);
			 
			}
		//return value;

		
		
	}
		//taking screenshoit
		public String SShot (WebDriver driver1) throws IOException, AWTException 
		{
			
			//String actual = actual1;
		//	String title = title1;
			WebDriver driver = driver1;
			
	/*		
			//if(title.contentEquals(actual))
							
			
			//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(com.mongodb.MapReduceCommand.OutputType.INLINE);
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					//String ss_filename="C:\\Users\\Reshma\\workspace\\MenuTesting_ASM\\test-output\\screenshot\\"+ driver.getCurrentUrl().trim()+"_"+System.+".jpg")
					//String currentDir = System.getProperty("user.dir");
					System.out.println("Source file :"+scrFile.getAbsolutePath());
					FileUtils.copyFile(scrFile, new File("C:\\Users\\Reshma\\workspace\\MenuTesting_ASM\\test-output\\screenshot\\"+ driver.getTitle().trim()+"_"+System.currentTimeMillis()+".jpg"));
					
					//FileUtils.copyFile(scrFile, new File(currentDir +"\\screenshot\\" +System.currentTimeMillis()+".png"));
	
					System.out.println(scrFile.getAbsolutePath());
					return null;
					*/
		
	
	Robot robot = new Robot();
	
	//Rectangle captureSize = new Rectangle(Toolkit.)
	BufferedImage screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	
	ImageIO.write(screenshot, "JPG", new File ("C:\\Users\\Reshma\\workspace\\MenuTesting_ASM\\test-output\\screenshot\\"+ driver.getTitle().trim()+"_"+System.currentTimeMillis()+".jpg"));
	
	
	
	return null;
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
}
}