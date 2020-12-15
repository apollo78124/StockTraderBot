import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class VideoToMP3Second {
	private static Scanner inFile1;
	private Thread t;
	   private String threadName;
	   
	   VideoToMP3Second(String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run(String a) {
	      System.out.println("Running " +  threadName );
	      try {
	         
	    	  System.setProperty("webdriver.chrome.driver", 
						"chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				try {
					
					driver.get("https://ytmp3.cc/");
					WebElement url = driver.findElement(By.id("input"));
					url.click();
					url.sendKeys(threadName);
					WebElement convertForm = driver.findElement(By.id("submit"));
					convertForm.submit();
					Thread.sleep(20000);
					WebElement download = driver.findElement(By.linkText("Login"));
					download.click();
					
				} catch (Exception e) {
					System.out.println("Thread " +  threadName + " interrupted.");
				}
				
	    	  
	      } catch (Exception e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   /**
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	*/

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub

		int songNumber;
		String skipButton = "Skip this page (no tags)";
		Scanner scn = new Scanner(System.in);
		boolean pageTurn = false;
		System.setProperty("webdriver.chrome.driver", 
				"chromedriver.exe");
		String[] links = new String[1000];
        String[] temp= new String[0];
        
        inFile1 = new Scanner(new File("../downloadLink.txt"));
        
        int i = 0;
        while(inFile1.hasNextLine()) {
            links[i] = inFile1.nextLine();
            i++;
        }
        temp = new String[i];
        for (int j = 0; j < i; j++) {
            temp[j] = links[j];
        }
        
        links = temp;
        inFile1.close();
		WebDriver driver = new ChromeDriver();
		for (i = 0; i < links.length; i++) {
			try {
		         
					driver.get("https://ytmp3.cc/");
					Thread.sleep(3000);
					WebElement url = driver.findElement(By.id("input"));
					url.click();
					url.sendKeys(links[i]);
					WebElement convertForm = driver.findElement(By.id("submit"));
					convertForm.submit();
					Thread.sleep(10000);
					WebElement download = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/a[1]"));
					download.click();
						
					
		      } catch (Exception e) {
		         System.out.println("Thread " +  links[i] + " interrupted.");
		         driver = new ChromeDriver();
		      }
		      System.out.println("Thread " +  links[i] + " exiting.");
		}

	}

}

