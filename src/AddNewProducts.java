import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewProducts {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner inFile1;
		String userName = "";
		String password = "";
		String mainUrl = "";
		String productUrl = "";
		ArrayList<String> adapters = new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver", 
				"./chromedriver.exe");
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get(mainUrl);
		
		Thread.sleep(1000);
		WebElement loginput = driver1.findElement(By.id("loginName"));
		loginput.sendKeys(userName);
		
		Thread.sleep(200);
		
		WebElement passwordInput = driver1.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		
		Thread.sleep(500); 
		
		WebElement logInButton = driver1.findElement(By.id("login-form"));
		logInButton.submit();
		
		inFile1 = new Scanner(new File("ExistingAdapter.txt"));
		while(inFile1.hasNextLine()) {
            adapters.add(inFile1.nextLine());
        }
		inFile1.close();
		
		Thread.sleep(4000);
		
		for(String adapterTitle : adapters) {
			try {
				
				driver1.get(productUrl);
				Thread.sleep(4000);
				
				WebElement adapterButton = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[2]/div[2]/div/nav/ul/li[5]/a/span"));
				adapterButton.click();
				Thread.sleep(3000);
				
				WebElement addProductButton = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[1]/header/div[3]/div/a"));
				addProductButton.click();
				Thread.sleep(3000);
				
				//Saving
				WebElement saveButton = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[1]/header/div[2]/div[2]/input"));
				saveButton.click();
				Thread.sleep(4000);
				
				
				
			} catch (Exception e) {
				System.out.println("Adapter " + adapterTitle + " didn't finish correctly");
				System.out.println(e);

				driver1.close();
				
				driver1 = new ChromeDriver();
				driver1.get(mainUrl);
				
				Thread.sleep(4000);
				loginput = driver1.findElement(By.id("loginName"));
				loginput.sendKeys(userName);
				
				passwordInput = driver1.findElement(By.id("password"));
				passwordInput.sendKeys(password);
				
				logInButton = driver1.findElement(By.id("login-form"));
				logInButton.submit();
				Thread.sleep(4000);
			} finally {
			}
		}
	}

}
