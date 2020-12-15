import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditCategories {

	public static void main(String[] args) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String userName = "davidlee78124@gmail.com";
				String password = "callofduty98";
				String mainUrl = "https://10885d7a64.nxcli.net/admin/";
				String AdapterUrl = "https://10885d7a64.nxcli.net/admin/commerce/products/adapters";
				String row = "";
				String sku = "";
				String category = "";
				BufferedReader txtReader = new BufferedReader(new FileReader("../AdapterCategories.txt"));

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
				Thread.sleep(4000);
				
				while ((row = txtReader.readLine()) != null) {
				    
					try {
						
						driver1.get(AdapterUrl);
						Thread.sleep(3000);
						String[] data = row.split(";");
						sku = data[0];
						category = data[1];
						if (category.equals("Data collection")) {
							category = "Logistics";
						}
						if (category.equals("Medical")) {
							category = "Healthcare";
						}
						if (category.equals("Notebook")) {
							category = "Logistics";
						}
						if (category.equals("PDA")) {
							category = "Logistics";
						}
						if (category.equals("Radio")) {
							category = "Public Safety";
						}
						if (category.equals("Avionic")) {
							category = "Military";
						}
						if (category.equals("Misc")) {
							category = "Logistics";
						}
						if (category.equals("Broadcast")) {
							category = "Public Safety";
						}
						System.out.println(sku + ";" + category);
						
						WebElement searchBar = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[1]/header/div[2]/div[2]/input"));
						searchBar.sendKeys(sku);
						Thread.sleep(3000);
						WebElement adapter = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[2]/div[3]/div/div[1]/div[1]/div/table/tbody/tr/td[2]/div/div/span/a"));
						adapter.click();
						Thread.sleep(1000);
						WebElement details = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/nav/ul/li[2]/a"));
						details.click();
						Thread.sleep(1000);
						WebElement categoryField = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[2]/div[7]/div[2]/input"));
						categoryField.clear();
						categoryField.sendKeys(category);
						WebElement saveButton = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[1]/header/div[2]/div[2]/input"));
						saveButton.click();
						Thread.sleep(4000);
						WebElement saveConfirmSearchBar = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[1]/header/div[2]/div[2]/input"));
						saveConfirmSearchBar.click();
						
					} catch (Exception e) {
						System.out.println("Adapter " + row + " didn't finish correctly");
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
