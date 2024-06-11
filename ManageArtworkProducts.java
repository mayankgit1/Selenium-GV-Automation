package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageArtworkProducts {
	public ManageArtworkProducts(ChromeDriver driver) {
		
		ConfigReader config = new ConfigReader();
		
		String Title = config.getProperty("Title");
        String Description = config.getProperty("Description");
        String ShortDesc = config.getProperty("ShortDesc");
        String Price = config.getProperty("Price");
        String Salesprice = config.getProperty("Salesprice");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			new SideBarManageArtwork(driver);
			
			WebElement addNewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD NEW']")));
			addNewBtn.click();
			
			//Edit Product Page
			WebElement artTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_name")));
			artTitle.sendKeys(Title);
			
			WebElement artistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-select-item-option')]/div)[1]")));
			artistName.click();
			
			
		}catch(Exception e) {
			System.out.print("System Error 404");
		}
	}

}
