import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrganizeCategories {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		BufferedReader csvReader = new BufferedReader(new FileReader("../CategoryUpdate.txt"));
		String row;
		String category;
		BufferedWriter writer = new BufferedWriter( 
                new FileWriter("../AdapterCategories.txt"));;
		
		String url = "";
		System.setProperty("webdriver.chrome.driver", 
				"./chromedriver.exe");
		
		WebDriver driver1 = new ChromeDriver();
		
		
		
		while ((row = csvReader.readLine()) != null) {
			try {
				
				driver1.get(url);
				writer = new BufferedWriter( 
		                new FileWriter("../AdapterCategories.txt", true));
				Thread.sleep(2000);
				WebElement searchBar = driver1.findElement(By.xpath("/html/body/section/div/div/div[1]/div[1]/label/input"));
				searchBar.sendKeys(row);
				Thread.sleep(4000);
				WebElement categoryDiv = driver1.findElement(By.xpath("/html/body/section/div/div/table/tbody/tr[1]/td[8]"));
				category = categoryDiv.getText();
				System.out.println(row +";" + category);
				writer.write(row +";" + category + "\n");
				
			} catch (Exception e) {
				System.out.println("Adapter " + row+ " didn't finish correctly");
				System.out.println(e);
				driver1.close();
				
				driver1 = new ChromeDriver();
				driver1.get(url);
				
				Thread.sleep(4000);
			} finally {
				writer.close();
			}
			
		}
	}

}
