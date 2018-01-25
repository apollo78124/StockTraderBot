
import java.time.LocalTime;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;

public class stockSimulatorAutomation{

	public static double stockValueRead = 0;
	
	public static double boughtPrice = 0;
	
	public static double numberSoldToday = 0;
	
	public static double operand = 0;
	
	public static double lowest = 0;
	
	public static double highest = 0;
	
	public static double previous = 0;
	
	public static int index = 0;
    
	public static double cumulativePercentage = 0;
	
	public static double cumulativeDifference = 0;
	
	public static LocalTime closingTime;
	
	public static boolean ifbought = false;

	
	public static double renewStockValue(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(1200);
		
		return Double.parseDouble(driver.findElement(By.id("quotePrice")).getText());
	}
	

	public static void buyStock(double limit) throws InterruptedException {
		
		String limitText = Double.toString(limit);
		
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/이은학/Downloads/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.investopedia.com/accounts/login.aspx/");
		
		WebElement loginput = driver.findElement(By.id("edit-email"));
		loginput.sendKeys("98apollo@naver.com");
		
		WebElement passwordInput = driver.findElement(By.id("edit-password"));
		passwordInput.sendKeys("bcitstockpractice");
		
		WebElement logInButton = driver.findElement(By.tagName("form"));
		logInButton.submit();
		
		driver.get("https://www.investopedia.com/simulator/trade/tradestock.aspx");
		
		WebElement symbol = driver.findElement(By.name("symbolTextbox"));
		symbol.sendKeys("TSLA");
		
		Select buyOrSell = new Select(driver.findElement(By.id("transactionTypeDropDown")));
		buyOrSell.selectByVisibleText("Buy");
		
		WebElement quantityTextbox = driver.findElement(By.id("quantityTextbox"));
		quantityTextbox.sendKeys("40");

		WebElement radioBtn = driver.findElement(By.id("limitRadioButton"));
		radioBtn.click();
		
		WebElement limitSection = driver.findElement(By.name("limitPriceTextBox"));
		limitSection.sendKeys(limitText);
		
		WebElement previewButton = driver.findElement(By.tagName("form"));
		previewButton.submit();
		
		previewButton = driver.findElement(By.tagName("form"));
		
		previewButton.submit();
		
		previewButton = driver.findElement(By.tagName("form"));
		
		previewButton.submit();
		
		boughtPrice = limit * 20;
		operand = limit;
		ifbought = true;
		
		driver.close();
	}
	
	public static void sellStock(double limit) throws InterruptedException {
	
		String limitText = Double.toString(limit);
	
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/이은학/Downloads/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.investopedia.com/accounts/login.aspx/");
		
		WebElement loginput = driver.findElement(By.id("edit-email"));
		loginput.sendKeys("98apollo@naver.com");
		
		WebElement passwordInput = driver.findElement(By.id("edit-password"));
		passwordInput.sendKeys("bcitstockpractice");
		
		WebElement logInButton = driver.findElement(By.tagName("form"));
		logInButton.submit();
		
		driver.get("https://www.investopedia.com/simulator/trade/tradestock.aspx");
		
		WebElement symbol = driver.findElement(By.name("symbolTextbox"));
		symbol.sendKeys("TSLA");
		
		Select buyOrSell = new Select(driver.findElement(By.id("transactionTypeDropDown")));
		buyOrSell.selectByVisibleText("Sell");
		
		WebElement quantityTextbox = driver.findElement(By.id("quantityTextbox"));
		quantityTextbox.sendKeys("40");
		
		WebElement radioBtn = driver.findElement(By.id("limitRadioButton"));
		radioBtn.click();
		
		WebElement limitSection = driver.findElement(By.name("limitPriceTextBox"));
		limitSection.sendKeys(limitText);
		
		WebElement previewButton = driver.findElement(By.tagName("form"));
		previewButton.submit();
		
		previewButton = driver.findElement(By.tagName("form"));
		
		previewButton.submit();
		
		previewButton = driver.findElement(By.tagName("form"));
		
		previewButton.submit();
		
		numberSoldToday++;
		operand = limit;
		ifbought = false;
		
		driver.close();
	}
	
	public static void logIn() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/이은학/Downloads/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.investopedia.com/accounts/login.aspx/");
		
		WebElement loginput = driver.findElement(By.id("edit-email"));
		loginput.sendKeys("98apollo@naver.com");
		
		WebElement passwordInput = driver.findElement(By.id("edit-password"));
		passwordInput.sendKeys("bcitstockpractice");
		
		WebElement logInButton = driver.findElement(By.tagName("form"));
		logInButton.submit();
		
		driver.get("https://www.investopedia.com/simulator/trade/tradestock.aspx");
		
	}
	
	public static boolean checkBuy(WebDriver driver) throws InterruptedException {
		
			Thread.sleep(9000);
			
			WebElement valueElement = driver.findElement(By.id("quotePrice"));
			String stringValue = valueElement.getText();
			
			return ifbought;
		
	}
	
	public static void checkSell() {
		
	}
	
	public static double getStockValueRead() {
		return stockValueRead;
	}

	public static double getLow() {
		return lowest;
	}

	public static double getPrevious() {
		return previous;
	}

	public static int getIndex() {
		return index;
	}

	public static void main(String[] args) throws InterruptedException {
			
			String yesOrNo;
			double priceEntered = 0;
			System.setProperty("webdriver.chrome.driver", 
				"./chromedriver_win32/chromedriver.exe");
			
			Scanner scn = new Scanner(System.in);
			System.out.println("Did you buy previously? (y/n)");
			yesOrNo = scn.nextLine();
			
			if (yesOrNo.equals("y")) {
				System.out.println("Price when bought: ");
				priceEntered = scn.nextDouble();
			}
			
			
			DecimalFormat fmt = new DecimalFormat("0.000");
		
			WebDriver driver1 = new ChromeDriver();
			
			driver1.get("https://www.investopedia.com/markets/stocks/tsla/");
			
			stockValueRead = stockSimulatorAutomation.renewStockValue(driver1);
			
			previous = stockValueRead;
			
			if (yesOrNo.equals("y")) {
				operand = priceEntered;
				ifbought = true;
			} else {
				operand = stockValueRead;
				ifbought = false;
			}
			

			double percentage = (stockValueRead / previous - 1) * 100;
			double difference = stockValueRead - previous;
			
			lowest = stockValueRead;
			highest = stockValueRead;
			
			cumulativePercentage = (stockValueRead / operand - 1) * 100;
			cumulativeDifference = stockValueRead - operand;
			
			System.out.println("[" + LocalTime.now() + "] Price: $" + stockValueRead + ", Short: " + fmt.format(percentage) + "% , " 
					+ "Total Perc: " + fmt.format(cumulativePercentage) + "%, " 
					+ "Lowest: " + lowest + ", Highest: " + highest 
					+", Bought?: " + ifbought + ", " + index);
			index++;
			
			while (LocalTime.now().isBefore(closingTime.of(13, 15))) {
				
				try {
					stockValueRead = stockSimulatorAutomation.renewStockValue(driver1);
					
					if (previous != stockValueRead) {
						
						percentage = (stockValueRead / previous - 1) * 100;
						difference = stockValueRead - previous;
						cumulativePercentage = (stockValueRead / operand - 1) * 100;
						cumulativeDifference = stockValueRead - operand;
						
						if (stockValueRead < lowest) {
							lowest = stockValueRead;
						}
						
						if (stockValueRead > highest) {
							highest = stockValueRead;							
						}
						
						System.out.println("[" + LocalTime.now() + "] Price: $" + stockValueRead + ", Short: " + fmt.format(percentage) + "% , " 
								+ "Total Perc: " + fmt.format(cumulativePercentage) + "%, " 
								+ "Lowest: " + lowest + ", Highest: " + highest 
								+", Bought?: " + ifbought + ", " + index);
						index++;
						
						
						
						if (cumulativePercentage < -0.4 && !ifbought) {
							buyStock(stockValueRead);
							
						}
						
						if (cumulativePercentage > 0.4 && ifbought) {
							sellStock(stockValueRead);
							
						}
						
						previous = stockValueRead;
						
							} else {
								;
							}
				} catch (NumberFormatException e) {
					System.out.println("Can't be read this time. ");
				}
				
			}

	}
	
}



