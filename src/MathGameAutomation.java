
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MathGameAutomation {
	
	public static String automatedLogIn(WebDriver driver, String url) throws InterruptedException {
		
		
		driver.get(url);
		Thread.sleep(1000);  // Let the user actually see something!
		
		WebElement loginput = driver.findElement(By.name("user"));
		loginput.sendKeys("a@a.a");
		
		Thread.sleep(200);
		
		WebElement passwordInput = driver.findElement(By.name("pass"));
		passwordInput.sendKeys("aaa");
		
		Thread.sleep(500); 
		
		WebElement logInButton = driver.findElement(By.tagName("form"));
		logInButton.submit();
		
		for (int i = 0; i < 20000; i++) {
			WebElement answer = driver.findElement(By.tagName("p"));
			String a = answer.getText();
			
			String result = MathGameAutomation.calculation(a);
			
			WebElement answerInput = driver.findElement(By.name("answer"));
			answerInput.sendKeys(result);
			
			Thread.sleep(5);
			
			WebElement answerButton = driver.findElement(By.tagName("form"));
			answerButton.submit();
			
		}
		
		return "Login attempt made";
	}
	
	public static String calculation(String a) {
		

		int realFirst;
		int realSecond;
		int result = 0;
		
		int i;
		for (i = 0; MathGameAutomation.isNumber(a.charAt(i)); i++) {
			;
		}
		
		String firstNumber = a.substring(0, i).trim();
		
		System.out.println(firstNumber);
		int charFirst = i;
		while (!MathGameAutomation.isNumber(a.charAt(i))) {
			i++;
		}
		
		String operand = a.substring(charFirst, i).trim();
		char realOperand = operand.charAt(0);
		
		int secondFirst = i;
		
		String secondNumber = a.substring(secondFirst, a.length()).trim();
		
		realFirst = Integer.parseInt(firstNumber);
		realSecond = Integer.parseInt(secondNumber);
		
		switch (realOperand) {
			case '-': result = realFirst - realSecond;
				break;
			
			case '+': result = realFirst + realSecond;
			break;
			case '/': result = realFirst / realSecond;
			break;
			case '*': result = realFirst * realSecond;
			break;
			
		}
		String stringresult = Integer.toString(result);
		return stringresult;
	}
	
	public static boolean isNumber(char ch) {
		return (ch >= '0' && ch <= '9');
	}
	
	public static void main(String[] args) throws InterruptedException {
		String url = "https://mathgameleechow.azurewebsites.net/login.php";
		
		System.setProperty("webdriver.chrome.driver", 
				"./chromedriver_win32/chromedriver.exe");
		
		WebDriver driver1 = new ChromeDriver();
		
		
		MathGameAutomation.automatedLogIn(driver1, url);
	
		
	}
}