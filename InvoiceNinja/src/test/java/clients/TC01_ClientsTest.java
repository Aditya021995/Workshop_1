package clients;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import genericLibrary.ExcelUtil;
import pomRepository.ClientsPage;
import pomRepository.HomePage;
import pomRepository.NewClientsPage;
/***
 * 
 * @author Ashwini M A
 *
 */
@Listeners
public class TC01_ClientsTest extends BaseTest{
	
	@Test
	public void clients() {
		
		 ExcelUtil readExcelData=new ExcelUtil();
		
		//Step1:Click on "clients" link
		 
		HomePage homepage=new HomePage(driver);
        homepage.getClientLink().click();
        String expectedClientsPageTitle = "Clients | Invoice Ninja";
        Assert.assertEquals(driver.getTitle(),expectedClientsPageTitle,"Clients page is not displayed");
        Reporter.log("Clients page is displayed",true);
        
        //Step2:Click on "new clients" button
        
        ClientsPage clientspage=new ClientsPage(driver);
        clientspage.getnewClients().click();
        String expectedNewClientPageTitle = "New Client | Invoice Ninja";
        Assert.assertEquals(driver.getTitle(),expectedNewClientPageTitle,"New Clients page is not displayed");
        Reporter.log("New Clients page is displayed",true);
        
        //Step3:Enter valid data in details box and click on "save" button
        
        NewClientsPage newclient =new NewClientsPage(driver);
        String name = readExcelData.readStringDataFromExcel("Clients", 1, 0);
        newclient.getName().sendKeys(name);
        
        double idNumber = readExcelData.readNumberDataFromExcel("Clients", 1,1);
        newclient.getIdNumber().sendKeys(""+idNumber+"");
        
        double vatNumber = readExcelData.readNumberDataFromExcel("Clients", 1, 2);
        newclient.getVatNumber().sendKeys(""+vatNumber+"");
        
        double phone = readExcelData.readNumberDataFromExcel("Clients", 1, 3);
        newclient.getphone1().sendKeys(""+phone+"");
        
        newclient.getSaveButton().click();	
        String expectedViewClientPageTitle = "View Client | Invoice Ninja";
        Assert.assertEquals(driver.getTitle(),expectedViewClientPageTitle,"Information is not saved");
        Reporter.log("Information is saved",true);
        
	}
}

