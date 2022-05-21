package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Assert;

public class zenGoClass {

	WebDriver driver;

	public void launchbrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.zenGo.com/");
	}

	public void zenGoVerify() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "ZenGo - Simple & Secure Crypto Wallet App";
		// System.out.println(driver.getTitle());
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		if (ActualTitle.equals(ExpectedTitle))
			System.out.println("The zenGo site displayed succussfully");
		else
			System.out.println("The zenGo site displayed failed");

	}

	public void searchEthereum() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("nav-toggle")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu-item-12609")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"zengo-coins\"]/tr[2]/td[2]/span[1]/a")).click();
	}

	public void ethereumWalletVerify() {
		String url = driver.getCurrentUrl();
		if (url.equals("https://zengo.com/assets/ethereum-wallet/"))
			System.out.println("Successfully redirected");
		else
			System.out.println("redirecte failed");
	}

	public void logoVerify() {
		WebElement i = driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/header/div[1]/p[1]/a/img"));
		Boolean pres = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
		if (pres)
			System.out.println("Logo present");
		else
			System.out.println("Logo not present");

	}

	public void homePageBack() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://www.zenGo.com/");
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		zenGoClass zenGo = new zenGoClass();
		zenGo.launchbrowser();
		zenGo.zenGoVerify();
		zenGo.searchEthereum();
		zenGo.ethereumWalletVerify();
		zenGo.logoVerify();
		zenGo.homePageBack();
		zenGo.closeBrowser();
	}

}
