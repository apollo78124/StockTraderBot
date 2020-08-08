import java.io.File;
import java.io.FileNotFoundException;
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
		ArrayList<String> adapters = new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver", 
				"./chromedriver.exe");
		inFile1 = new Scanner(new File("ExistingAdapter.txt"));
		while(inFile1.hasNextLine()) {
            adapters.add(inFile1.nextLine());
        }
		inFile1.close();
		WebDriver driver1 = new ChromeDriver();
		
		  // Let the user actually see something!
		
		
		for(String adapterTitle : adapters) {
			try {
				driver1 = new ChromeDriver();
				driver1.get("");
				
				Thread.sleep(1000);
				WebElement loginput = driver1.findElement(By.id("loginName"));
				loginput.sendKeys("");
				
				Thread.sleep(200);
				
				WebElement passwordInput = driver1.findElement(By.id("password"));
				passwordInput.sendKeys("");
				
				Thread.sleep(500); 
				
				WebElement logInButton = driver1.findElement(By.id("login-form"));
				logInButton.submit();
				
				
				Thread.sleep(3000);
				
				driver1.get("");
				Thread.sleep(4000);
				WebElement searchbar = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/div[1]/header/div[2]/div[2]/input"));

				searchbar.sendKeys(adapterTitle);
				Thread.sleep(3000);
				
				/**
				 * image populater
				WebElement adapter = driver1.findElement(By.xpath("/html/body/div/div/div[3]/main/div[2]/div[3]/div/div[1]/div[1]/div/table/tbody/tr/td[2]/div/div/span/a"));
				adapter.click();
				Thread.sleep(3000);
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
				Thread.sleep(3000);
				WebElement relatedProductSearch = driver1.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[2]/div[1]/div[3]/input"));
				relatedProductSearch.sendKeys("C7200");
				Thread.sleep(3000);
				WebElement selectRelatedProduct = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div/span"));
				selectRelatedProduct.click();
				Thread.sleep(3000);
				WebElement selectProductFinalButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectProductFinalButton.click();
				Thread.sleep(3000);
				
				
				addRelatedProduct = driver1.findElement(By.xpath("//*[@id=\"fields-productRelatedProducts\"]/div[2]"));
				addRelatedProduct.click();
				Thread.sleep(3000);
				relatedProductSearch = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[3]/input"));
				relatedProductSearch.sendKeys("C7400");
				Thread.sleep(3000);
				selectRelatedProduct = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div/span"));
				selectRelatedProduct.click();
				Thread.sleep(3000);
				selectProductFinalButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectProductFinalButton.click();
				Thread.sleep(3000);
				
				
				addRelatedProduct = driver1.findElement(By.xpath("//*[@id=\"fields-productRelatedProducts\"]/div[2]"));
				addRelatedProduct.click();
				Thread.sleep(3000);
				relatedProductSearch = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[3]/input"));
				relatedProductSearch.sendKeys("C7400");
				Thread.sleep(3000);
				selectRelatedProduct = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div/span"));
				selectRelatedProduct.click();
				Thread.sleep(3000);
				selectProductFinalButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectProductFinalButton.click();
				Thread.sleep(3000);
				
				WebElement saveButton = driver1.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[2]/input"));
				saveButton.click();
				Thread.sleep(5000);
				
				
				
			} catch (Exception e) {
				System.out.println("Adapter " + adapterTitle + " didn't finish correctly");
				System.out.println(e);
			} finally {
				driver1.close();
			}
		}
		
		
	}

}
