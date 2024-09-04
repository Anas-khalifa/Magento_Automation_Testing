import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentoWebsiteTest {
	WebDriver driver = new ChromeDriver();
	String magentoWebSite = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	String password = "123AAaa--";
	String email = "";

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.get(magentoWebSite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

//	@Test(priority = 1)
//	public void createAccountTest() {
//		WebElement createAccountPage = driver.findElement(By.linkText("Create an Account"));
//		createAccountPage.click();
//
//		WebElement firstNameInput = driver.findElement(By.id("firstname"));
//		WebElement lastNameInput = driver.findElement(By.id("lastname"));
//		WebElement emailInput = driver.findElement(By.id("email_address"));
//		WebElement passwordInput = driver.findElement(By.id("password"));
//		WebElement confirmPasswordInput = driver.findElement(By.id("password-confirmation"));
//		WebElement createAccountBtn = driver.findElement(By.xpath("//button[@title='Create an Account']"));
//
//		String[] firstnames = { "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Ivy", "Jack" };
//
//		String[] lastNames = { "Smith", "Johnson", "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White",
//				"Harris", "Martin" };
//
//		int randomFirstNameIndex = rand.nextInt(firstnames.length);
//		int randomLastNameIndex = rand.nextInt(lastNames.length);
//		int randomNumberForEmail = rand.nextInt(9876);
//
//		String pickedfirstName = firstnames[randomFirstNameIndex];
//		String pickedLastName = lastNames[randomLastNameIndex];
//		email = pickedfirstName + pickedLastName + randomNumberForEmail + "@gmail.com";
//
//		firstNameInput.sendKeys(pickedfirstName);
//		lastNameInput.sendKeys(pickedLastName);
//		emailInput.sendKeys(email);
//		passwordInput.sendKeys(password);
//		confirmPasswordInput.sendKeys(password);
//		createAccountBtn.click();
//
//	}
//
//	@Test(priority = 2)
//	public void logoutTest() {
//		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
//
//	}
//
//	@Test(priority = 3)
//	public void loginTest() throws InterruptedException {
//		
//		driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a")).click();
//		driver.findElement(By.id("email")).sendKeys(email);
//		driver.findElement(By.id("pass")).sendKeys(password);
//		driver.findElement(By.id("send2")).click();
//
//	}

//	@Test(priority = 4)
//	public void addMenItems() {
//		
//
//		driver.findElement(By.cssSelector("#ui-id-5")).click();
//
//		WebElement olContainorItems = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
//		List<WebElement> productItems = olContainorItems.findElements(By.tagName("li"));
//		int randomItem = rand.nextInt(productItems.size());
//		productItems.get(randomItem).click();
//
//		WebElement sizeContainor = driver
//				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
//		List<WebElement> sizeOption = sizeContainor.findElements(By.tagName("div"));
//		int randomSize = rand.nextInt(sizeOption.size());
//		sizeOption.get(randomSize).click();
//
//		WebElement colorContainor = driver
//				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
//		List<WebElement> colorOption = colorContainor.findElements(By.tagName("div"));
//		int randomColor = rand.nextInt(colorOption.size());
//		colorOption.get(randomColor).click();
//		
//		WebElement addToCartBtn=driver.findElement(By.id("product-addtocart-button"));
//		addToCartBtn.click();
//		
//		WebElement successMsg=driver.findElement(By.cssSelector(".message-success.success.message"));
//		
//		Assert.assertEquals(successMsg.getText().contains("You added"), true);
//
//	}
	
	@Test(priority=5)
	public void addWomenItems() throws InterruptedException {
		//Click on women page
		WebElement womenButtonPage=driver.findElement(By.cssSelector("#ui-id-4"));
		womenButtonPage.click();
		// Click on random item
		WebElement itemsContainer=driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		List<WebElement> itemsList=itemsContainer.findElements(By.tagName("li"));
		int randomItem=rand.nextInt(itemsList.size());
		itemsList.get(randomItem).click();
		//Click on random size
		WebElement sizeContainer =driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
		List<WebElement> sizesList=sizeContainer.findElements(By.tagName("div"));
		int randomSize=rand.nextInt(sizesList.size());
		sizesList.get(randomSize).click();
		//Click on random Color
		WebElement colorContainer=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> colorsList=colorContainer.findElements(By.tagName("div"));
		int randomColor=rand.nextInt(colorsList.size());
		colorsList.get(randomColor).click();
		// add random quantity
		WebElement quantity=driver.findElement(By.cssSelector("#qty"));
		int randomQuantity=rand.nextInt(1000);
		quantity.sendKeys(randomQuantity+"");
		// click on the add to cart button
		WebElement addToCartBtn=driver.findElement(By.cssSelector("#product-addtocart-button"));
		addToCartBtn.click();
				
		WebElement addedToCartMassege=driver.findElement(By.cssSelector(".message-success.success.message"));
		Assert.assertEquals(addedToCartMassege.getText().contains("You added"), true);

		Thread.sleep(3000);
		// click on review button
		WebElement reviewButton=driver.findElement(By.cssSelector("#tab-label-reviews-title"));
		reviewButton.click();
		//scroll down

		//review section
		int randomRatingValue=rand.nextInt(6);

		WebElement ratingStars=driver.findElement(By.id("Rating_"+randomRatingValue));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",ratingStars);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();",ratingStars);
		
		//add nickName
		WebElement nickName=driver.findElement(By.cssSelector("#nickname_field"));
		nickName.sendKeys("anas");
		
		WebElement summary=driver.findElement(By.cssSelector("#summary_field"));
		summary.sendKeys("summary");
		
		WebElement reviewText=driver.findElement(By.cssSelector("#review_field"));
		reviewText.sendKeys("review");
//		Thread.sleep(10000);
		
		WebElement reviewSubmitBtn=driver.findElement(By.cssSelector("button[class='action submit primary']"));
		reviewSubmitBtn.click();
		
		WebElement reviewMassege=driver.findElement(By.cssSelector(".message-success.success.message"));

		Assert.assertEquals(reviewMassege.getText().contains("You submitted"), true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
