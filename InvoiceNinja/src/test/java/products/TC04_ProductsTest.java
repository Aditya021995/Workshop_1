package products;
/***
 * @author Pradnya
 */


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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
public class TC04_ProductsTest extends BaseTest {

	@Test
	public void cloneProduct() throws InterruptedException {
		ExcelUtil ex=new ExcelUtil();

		//=========================Step 1: Click on Products Link==========================================================
		HomePage  homepage =new HomePage(driver);
		homepage.getProductsLink().click();
		String Product_PageTitle="Products | Invoice Ninja";
		Assert.assertEquals(driver.getTitle(),Product_PageTitle,"Product Page is not displayed");



		//=============Step 2 :move curser to created product============================================================
		ProductPage productPage=new ProductPage(driver);
		Actions action=new Actions(driver);	
		action.moveToElement(productPage.getCreatedProduct()).perform();

		//=================Step 3:click on select button===================================================================
		productPage.getSelectButton().click();
		//============Step 4:click on clone product link=============================================================
		productPage.getCloneProductLink().click();
		String clonePageTitle = "Edit Product | Invoice Ninja";
		Assert.assertEquals(driver.getTitle(),clonePageTitle,"Clone Product Page is not displayed");


		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100);");

		//======================Step 5: Click on Save Button========================================================================
		productPage.getSaveButton().click();

		////=========================Step 6: Click on Products Link==========================================================
		homepage.getProductsLink().click();
		Assert.assertEquals(driver.getTitle(),Product_PageTitle,"Product Page is not displayed");
		Reporter.log("Product Cloned Successfully",true);





	}
}
