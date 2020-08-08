import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class VideoToMP3 {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int songNumber;
		String[] links;
		String skipButton = "Skip this page (no tags)";
		Scanner scn = new Scanner(System.in);
		boolean pageTurn = false;
		
		System.out.println("How many songs?");
		songNumber = scn.nextInt();
		links = new String[songNumber];
		
		for (int i = 0; i < songNumber; i++) {
			System.out.println("Paste the link");
			links[i] = scn.next();
		}
		
		for (int i = 0; i < songNumber; i++) {
			System.setProperty("webdriver.chrome.driver", 
					"chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();

			driver.get("http://convert2mp3.net/en/");
			
			WebElement url = driver.findElement(By.name("url"));
			url.sendKeys(links[i]);
			WebElement convertForm = driver.findElement(By.id("convertForm"));
			convertForm.submit();
		
			do {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[contains(text(),'Skip this')]")).click();
					pageTurn = true;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					;
				}
				
			} while (!pageTurn); 
			
			do {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[contains(text(),'Download')]")).click();
					pageTurn = true;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					;
				}
				
			} while (!pageTurn); 
				
		}
	}

}
