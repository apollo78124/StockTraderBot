import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeAListOfFiles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String mainUrl = "file:///D:/Cadex%20website/partnersCanada.html";
				
				System.setProperty("webdriver.chrome.driver", 
						"./chromedriver.exe");
				
				WebDriver driver1 = new ChromeDriver();
				driver1.get(mainUrl);

				
				Thread.sleep(4000);
	}

}
