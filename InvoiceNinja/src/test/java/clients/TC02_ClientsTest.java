package clients;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import pomRepository.ClientsPage;
import pomRepository.HomePage;
import pomRepository.NewClientsPage;
/***
 * 
 * @author Ashwini M A
 *
 */
@Listeners
public class TC02_ClientsTest extends BaseTest {
     @Test
    public void editClient() {
    	 
    	//========Step1:Click on "clients" link=========//
    	 
	   HomePage homepage=new HomePage(driver);
       homepage.getClientLink().click();
       String expectedClientsPageTitle = "Clients | Invoice Ninja";
       Assert.assertEquals(driver.getTitle(),expectedClientsPageTitle,"Clients page is not displayed");
       Reporter.log("Clients page is displayed",true);
    
       //========Step2:Click on new select drop down and click on "edit clients"=======//
       
       ClientsPage clientspage=new ClientsPage(driver);
       Actions actions=new Actions(driver);
       actions.moveToElement(driver.findElement(By.xpath("//center[@style='min-width:100px']"))).perform();
       clientspage.getselectDropdown().click();
       clientspage.geteditClient().click();
       String expectedEditClientsPageTitle = "Edit Client | Invoice Ninja";
       Assert.assertEquals(driver.getTitle(),expectedEditClientsPageTitle,"Edit Clients page is not displayed");
       Reporter.log("Edit Clients page is displayed",true);
       
       //========Step3:Enter valid data in contacts box and click on "save" button========//
       
       NewClientsPage newclients=new NewClientsPage(driver);
       String firstName = readExcelData.readStringDataFromExcel("Clients", 1, 4);
       newclients.getfirstName().sendKeys(firstName);
       
       String LastName = readExcelData.readStringDataFromExcel("Clients", 1, 5);
       newclients.getLastName().sendKeys(LastName);
       
       double phone = readExcelData.readNumberDataFromExcel("Clients", 1,6);
       newclients.getphone1().sendKeys(""+phone+"");
       
       newclients.getSaveButton().click();
       String expectedViewClientPageTitle = "View Client | Invoice Ninja";
       Assert.assertEquals(driver.getTitle(),expectedViewClientPageTitle,"Information is not saved");
       Reporter.log("Information is saved",true);
       
}
}

