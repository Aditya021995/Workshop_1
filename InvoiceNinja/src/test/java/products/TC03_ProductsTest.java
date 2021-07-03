package products;
/***
 * @author Pradnya
 */

import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import genericLibrary.ExcelUtil;
import genericLibrary.ListenerImplementationClass;
import pomRepository.HomePage;
import pomRepository.ProductPage;


@Listeners(ListenerImplementationClass.class)
public class TC03_ProductsTest extends BaseTest{

	@Test
	public void createProduct() throws InterruptedException {
		ExcelUtil ex=new ExcelUtil();

		//=========================Step 1: Click on Products Link==========================================================
		HomePage  homepage =new HomePage(driver);
		homepage.getProductsLink().click();
		String Product_PageTitle="Products | Invoice Ninja";
		Assert.assertEquals(driver.getTitle(),Product_PageTitle,"Product Page is not displayed");


		//==========================Step 2:Click on Create new Product button================================================
		ProductPage productPage=new ProductPage(driver);
		productPage.getCreateNewProductButton().click();
		String CreateProduct_PageTitle="Add Product | Invoice Ninja";
		Assert.assertEquals(driver.getTitle(),CreateProduct_PageTitle,"Create Product Page is not displayed");

		//=============================Step 3: Enter valid INput in respective textfield====================================
		String productName = ex.readStringDataFromExcel("Products", 0, 0);
		productPage.getProductNameTextfield().sendKeys(productName);
		Assert.assertEquals(productPage.getProductNameTextfield().getAttribute("value"),productName,"Product Name is not enterded correctly");		

		String note = ex.readStringDataFromExcel("Products", 1, 0);
		productPage.getNotesTextfield().sendKeys(note);
		Assert.assertEquals(productPage.getNotesTextfield().getAttribute("value"),note,"Note is not enterded correctly");

		int cost = (int) ex.readNumberDataFromExcel("Products", 2, 0);
		productPage.getCostTextfield().sendKeys(""+cost+"");
		Assert.assertEquals(productPage.getCostTextfield().getAttribute("value"),""+cost+"","Cost is not enterded correctly");

		Thread.sleep(3000);

		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100);");

		//======================Step 4: Click on Save Button========================================================================
		productPage.getSaveButton().click();

		////=========================Step 5: Click on Products Link==========================================================
		homepage.getProductsLink().click();
		Assert.assertEquals(driver.getTitle(),Product_PageTitle,"Product Page is not displayed");
		Reporter.log("Product Created Successfully",true);
	}

} 