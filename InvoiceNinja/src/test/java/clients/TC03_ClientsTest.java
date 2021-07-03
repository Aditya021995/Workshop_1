package clients;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomRepository.ClientsPage;
import pomRepository.NewClientsPage;

public class TC03_ClientsTest extends BaseTest {

	@Test
	public void createClients(){ 

		Assert.assertEquals("Dashboard | Invoice Ninja",driver.getTitle(),"Home page is not displayed");
		Reporter.log("Home page is displayed",true);

		//Place the mouse cursor on "Clients" and click on Clients_link
		homePage.getClientLink().click();
		Assert.assertEquals("Clients | Invoice Ninja",driver.getTitle(),"Clients page is not displayed");
		Reporter.log("Clients page is displayed",true);

		//naviagate to "create new Client"page by click on new client button
		ClientsPage clientsPage = new ClientsPage(driver);
        clientsPage.getnewClients().click();
		Assert.assertEquals("New Client | Invoice Ninja",driver.getTitle(),"Create clients page is not displayed");
		Reporter.log("Create clients page is displayed",true);


		//Enter the value in to the text fields related only to "details" and click on "save button"
		NewClientsPage newClient = new NewClientsPage(driver);
		 String name = readExcelData.readStringDataFromExcel("Clients",0,0);
		double  idNumber = readExcelData.readNumberDataFromExcel("Clients",0,1);
		double vatNumber = readExcelData.readNumberDataFromExcel("Clients",0,2);
		String website = readExcelData.readStringDataFromExcel("Clients",0,3);
		double phoneNo = readExcelData.readNumberDataFromExcel("Clients",0,4);
		newClient.getName().sendKeys(name);
		newClient.getIdNumber().sendKeys(idNumber+"");
		newClient.getVatNumber().sendKeys(vatNumber+"");
		newClient.getWebsite().sendKeys(website+"");
		newClient.getPhone1().sendKeys(phoneNo+"");

		newClient.getSaveButton().click();
		Assert.assertEquals("View Client | Invoice Ninja",driver.getTitle(),"Client details are not added and clients/abc page is not displayed");
		Reporter.log("Client details are added successfully and Clients/abc page is displayed",true);
		
		driver.quit();
	}
}











