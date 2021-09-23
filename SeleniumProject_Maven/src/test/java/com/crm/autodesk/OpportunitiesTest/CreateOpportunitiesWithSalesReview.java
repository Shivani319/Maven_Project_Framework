package com.crm.autodesk.OpportunitiesTest;


import org.testng.annotations.Test;

import com.crm.autodesk.GenericLibraries.BaseClass;
import com.crm.autodesk.elementRepository.CreateOpportunitiesPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OpportunitiesPage;
import com.crm.autodesk.elementRepository.SearchOpportinitiesPage;


public class CreateOpportunitiesWithSalesReview extends BaseClass {
		//WebDriver driver;
		@Test
		public void createOpportunitiesWithSalesReviewTest() throws Throwable {
			// navigate to opportunities page
			String oppName = exlib.getExcelData("sheet1", 9, 2);
			String salesType = exlib.getExcelData("Sheet1", 9, 4);
			//navigate to opportuntities page
			
			HomePage hp = new HomePage(driver);
			hp.clickOnOpportunities();
			
			//click on opportunities page

			OpportunitiesPage oppP = new OpportunitiesPage(driver);
	        oppP.clickonCreateOppImg();

			// create opportunities
			CreateOpportunitiesPage createOppP = new CreateOpportunitiesPage(driver);
			createOppP.createOpportunitiesWithSalesStage(oppName, salesType);
			
			
			
            createOppP.clickonCreateRelToOrgImg(driver);
			
			SearchOpportinitiesPage sop= new SearchOpportinitiesPage(driver);
			sop.createSearchOrganization();
			Thread.sleep(1500);
			wlib.switchToWindow(driver, "EditView");
			createOppP.getSaveBtn().click();
			
		
			
			
			//createOppP.saveCreateOpportunitiesData();
			
			

}
}