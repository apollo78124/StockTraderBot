import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContentUpdater {
	

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
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
				WebElement searchbar = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/div[1]/header/div[2]/div[2]/input"));

				searchbar.sendKeys(adapterTitle);
				Thread.sleep(3000);
				
				
				WebElement adapter = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[2]/div[3]/div/div[1]/div[1]/div/table/tbody/tr/td[2]/div/div/span/a"));
				adapter.click();
				Thread.sleep(3000);
				/**
				 * image populater
				WebElement addImage = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[8]/div[2]/div/div[2]/div[1]/div[1]"));
				addImage.click();
				Thread.sleep(3000);
				WebElement selectImage = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[8]/div[2]/div/div[1]/div/div[4]/div/div[2]/div/div[2]"));
				selectImage.click();
				Thread.sleep(3000);
				WebElement adapterImage = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div[2]/span"));
				adapterImage.click();
				Thread.sleep(3000);
				WebElement selectIamgeButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectIamgeButton.click();
				Thread.sleep(3000);
				*/
				WebElement addRelatedProduct = driver1.findElement(By.xpath("//*[@id=\"fields-productRelatedProducts\"]/div[2]"));
				addRelatedProduct.click();
				Thread.sleep(5000);
				WebElement relatedProductSearch = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[3]/input"));
				relatedProductSearch.click();
				relatedProductSearch.sendKeys("C7400");
				Thread.sleep(2000);
				WebElement selectRelatedProduct = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div/span"));
				selectRelatedProduct.click();
				Thread.sleep(2000);
				WebElement selectProductFinalButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectProductFinalButton.click();
				Thread.sleep(3000);
				
				addRelatedProduct = driver1.findElement(By.xpath("//*[@id=\"fields-productRelatedProducts\"]/div[2]"));
				addRelatedProduct.click();
				Thread.sleep(5000);
				relatedProductSearch = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[3]/input"));
				relatedProductSearch.click();
				relatedProductSearch.clear();
				relatedProductSearch.sendKeys("C7400er");
				Thread.sleep(2000);
				selectRelatedProduct = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div/span"));
				selectRelatedProduct.click();
				Thread.sleep(2000);
				selectProductFinalButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectProductFinalButton.click();
				Thread.sleep(3000);
				
				//Saving
				WebElement saveButton = driver1.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[2]/input"));
				saveButton.click();
				Thread.sleep(4000);
				/**
				 * Product Description
				WebElement productDescription = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[6]/div[2]/div/textarea"));
			    
			    WebElement productDescription1 = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[6]/div[2]/div/div[2]"));
			    
			    String textagain = productDescription.getAttribute("value");
			    FileWriter myWriter = new FileWriter("descriptions.txt", true);
			    myWriter.write("\n" + textagain);
				myWriter.close();
				*/
			    //productDescription1.click();
			    //productDescription1.clear();
			    //productDescription1.sendKeys("");
				
				
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
