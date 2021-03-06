package org.joguzmandev.demo.test;

import org.joguzmandev.demo.base.BaseTest;
import org.joguzmandev.demo.listener.BaseListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.admin.ViewCompanyStructurePage;
import pages.admin.ViewSystemUsersPage;
import pages.auth.LoginPage;
import pages.dashboard.DashboardPage;

@Listeners(value = BaseListener.class)
public class CreateStructureOrganizationTest extends BaseTest {

    @Test(priority = 1)
    public void test_create_structure_organization_with_all_empty_fields() {
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        ViewSystemUsersPage adminMenu = dashboardPage.clickToGoAdminMenu();

        ViewCompanyStructurePage companyStructureMenu = adminMenu.clickToStructureSubMenuLink();

        companyStructureMenu.clickEditButton();
        companyStructureMenu.clickRootTreeLink();

        String unitId= "";
        String unitName = "";
        String unitDescription = "";

       String actualResult =
               companyStructureMenu.addNewUnitStructureWithAtLeastEmptyFields(unitId,unitName,unitDescription);
       String expectedResult = "Required";

       Assert.assertEquals(actualResult,expectedResult,"Required field is empty");

    }

    @Test(priority = 1)
    public void test_create_structure_organization_with_required_field_empty(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        ViewSystemUsersPage adminMenu = dashboardPage.clickToGoAdminMenu();

        ViewCompanyStructurePage companyStructureMenu = adminMenu.clickToStructureSubMenuLink();

        companyStructureMenu.clickEditButton();
        companyStructureMenu.clickRootTreeLink();

        String unitId= "1212";
        String unitName = "";
        String unitDescription = "Descripcion Unit";

        String actualResult =
                companyStructureMenu.addNewUnitStructureWithAtLeastEmptyFields(unitId,unitName,unitDescription);
        String expectedResult = "Required";

        Assert.assertEquals(actualResult,expectedResult,"Required field is empty");
    }

    @Test(priority = 1)
    public void test_create_structure_organization_with_required_field_not_empty(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        ViewSystemUsersPage adminMenu = dashboardPage.clickToGoAdminMenu();

        ViewCompanyStructurePage companyStructureMenu = adminMenu.clickToStructureSubMenuLink();

        companyStructureMenu.clickEditButton();
        companyStructureMenu.clickRootTreeLink();

        String unitId= "";
        String unitName = "Unit Structure demo";
        String unitDescription = "";

        String actualResult =
                companyStructureMenu.addNewUnitStructureWithRequiredFieldNotEmpty(unitId,unitName,unitDescription);

        Assert.assertEquals(actualResult,"Successfully Saved","Cannot create unit structure,it Already Exists ");
    }

    @Test(priority = 2)
    public void test_recreate_structure_organization_with_required_field_existing(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        ViewSystemUsersPage adminMenu = dashboardPage.clickToGoAdminMenu();

        ViewCompanyStructurePage companyStructureMenu = adminMenu.clickToStructureSubMenuLink();

        companyStructureMenu.clickEditButton();
        companyStructureMenu.clickRootTreeLink();

        String unitId= "";
        String unitName = "Unit Structure demo";
        String unitDescription = "";

        String actualResult =
                companyStructureMenu.addNewUnitStructureWithRequiredFieldNotEmpty(unitId,unitName,unitDescription);

        Assert.assertEquals(actualResult,"Name Already Exists","Required field not exists");
    }

    @Test(priority = 3)
    public void test_create_structure_organization_with_all_field_filled_in(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        ViewSystemUsersPage adminMenu = dashboardPage.clickToGoAdminMenu();

        ViewCompanyStructurePage companyStructureMenu = adminMenu.clickToStructureSubMenuLink();

        companyStructureMenu.clickEditButton();
        companyStructureMenu.clickRootTreeLink();

        String unitId= "001IT";
        String unitName = "IT Support";
        String unitDescription = "IT Support";

        String actualResult =
                companyStructureMenu.addNewUnitStructureWithRequiredFieldNotEmpty(unitId,unitName,unitDescription);

        Assert.assertEquals(actualResult,"Successfully Saved","Cannot create unit structure, it already exists ");
    }

    @Test(priority = 4)
    public void test_create_structure_organization_with_all_field_filled_in_and_cancel_form(){
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(this.webDriver);

        String userName = "Admin";
        String password = "admin123";

        loginPage.typeUserName(userName);
        loginPage.typePassword(password);

        DashboardPage dashboardPage = loginPage.clickLoginButtonValidCredentials();

        ViewSystemUsersPage adminMenu = dashboardPage.clickToGoAdminMenu();

        ViewCompanyStructurePage companyStructureMenu = adminMenu.clickToStructureSubMenuLink();

        companyStructureMenu.clickEditButton();
        companyStructureMenu.clickRootTreeLink();

        String unitId= "001IT";
        String unitName = "IT Support";
        String unitDescription = "IT Support";

        companyStructureMenu.addNewUnitStructureWithAllFieldsFilledInAndCancelForm(unitId,unitName,unitDescription);
    }
}
