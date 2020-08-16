import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewProducts {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Scanner inFile1;
		String userName = "";
		String password = "";
		String mainUrl = "";
		String productUrl = "";
		String newAdapterUrl = "";
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
		ProcessFiles dataProcessor = new ProcessFiles();
		HashMap<String, Adapter> processedData = dataProcessor.getData();
		
		Thread.sleep(4000);
		Iterator hmIterator = processedData.entrySet().iterator(); 
		  
  
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            Adapter tempAdapter = (Adapter) mapElement.getValue();
			try {
				
				driver1.get(newAdapterUrl);
				Thread.sleep(3000);
				/**
				//Title
				WebElement titleInput = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[1]/div[2]/input"));
				titleInput.sendKeys(tempAdapter.getTitle());
				
				
				//Add C7400
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
				
				
				//Add C7200
				addRelatedProduct = driver1.findElement(By.xpath("//*[@id=\"fields-productRelatedProducts\"]/div[2]"));
				addRelatedProduct.click();
				Thread.sleep(5000);
				relatedProductSearch = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div[3]/input"));
				relatedProductSearch.click();
				relatedProductSearch.clear();
				relatedProductSearch.sendKeys("C7200");
				Thread.sleep(2000);
				selectRelatedProduct = driver1.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div/span"));
				selectRelatedProduct.click();
				Thread.sleep(2000);
				selectProductFinalButton = driver1.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]"));
				selectProductFinalButton.click();
				Thread.sleep(3000);
				
				
				//Add C7400er
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
				
				//Placeholder image
				WebElement addImage = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[8]/div[2]/div/div[2]/div[1]/div[1]"));
				addImage.click();
				Thread.sleep(3000);
				WebElement selectImage = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[8]/div[2]/div/div[1]/div/div[4]/div/div[2]/div/div[2]"));
				selectImage.click();
				Thread.sleep(3000);
				WebElement adapterImage = driver1.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/div/div[2]/span"));
				adapterImage.click();
				Thread.sleep(3000);
				WebElement selectIamgeButton = driver1.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div[2]"));
				selectIamgeButton.click();
				Thread.sleep(3000);
				
				//Unlimited checkbox
				WebElement unlimitedCheckBox = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[2]/div/div[3]/div[3]/div[2]/div/div[2]/label"));
				unlimitedCheckBox.click();
				Thread.sleep(3000);
				
				//US price
				WebElement uspriceInput = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/div/input"));
				uspriceInput.sendKeys(tempAdapter.USPrice);
				
				//SKU
				WebElement skuInput = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[2]/div/div[3]/div[1]/div[2]/input"));
				skuInput.sendKeys(tempAdapter.getSKU());
				
				//Canadian Price
				WebElement cadPriceInput = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[2]/div/div[3]/div[2]/div[2]/input"));
				cadPriceInput.sendKeys(tempAdapter.CADPrice);
				*/
				/**
				 * Product Description
				 */
				
				WebElement productDescription = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[6]/div[2]/div/div[2]"));
				//productDescription.click();
				for(String company : tempAdapter.getCompany()) {
					productDescription.sendKeys(company + " ");
				}
				int i = 0;
				for(String battery : tempAdapter.getBatteryModels()) {
					productDescription.sendKeys(battery);
					if (i > 0) {
						productDescription.sendKeys(", ");
					}
					i++;
				}
				productDescription.sendKeys("\n");
				i = 0;
				for(String chem : tempAdapter.getChem()) {
					productDescription.sendKeys("Chemistry: " + chem);
					if (i > 0) {
						productDescription.sendKeys(", ");
					}
					i++;
				}
				productDescription.sendKeys("\n");
				
				//Saving
				WebElement saveButton = driver1.findElement(By.xpath("/html/body/div[1]/div/div[3]/main/form/div[1]/header/div[2]/div[2]/input"));
				//saveButton.click();
				Thread.sleep(4000);
				
				
				
			} catch (Exception e) {
				System.out.println("Adapter " + tempAdapter.getSKU()+ " didn't finish correctly");
				System.out.println(e);
				Thread.sleep(80000);
				/**
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
				*/
			} finally {
			}
		}
	}

}
