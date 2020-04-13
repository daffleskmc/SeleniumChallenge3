Pre-Conditions (Manual Step):
Go to capsulecrm.com
Create a free account
Ex: http://naveenlabs.capsulecrm.com
https://daffles.capsulecrm.com
dapdap123

Test Case 1:
go to this url -https://daffles.capsulecrm.com/login?
Login with correct credentials
2) click on person icon and add a person
3) click on cases icon
4) click on Add Case button
5) Create a new case with the added person
6) Verify the correct case got created for the same person
7) verify the case status: Open
8) close the browser

Test Case 2:
1) go to this url -https://naveenlabs.capsulecrm.com/login?
a. Login with correct credentials
2) click on account name at left top corner
3) go to account settings
4) Verify Account Settings page header
5) Click on each link available at left panel:
	Account Settings
Account
Invoices
Export
Appearance
Mail Drop Box
Users
Opportunities
Tracks
Task Categories
Custom Fields
Tags
Integrations
Trash

6). After clicking on each link, verify the page header
7) Click on Appearance and upload a logo image
8) Click on Users : Add New User and verify the same user
9) Click on Opportunities : Add new milestone and verify the same
10) Click on Tracks : Add new track and verify the same
11) Click on Task Categories : Add new category and verify the same
12) Click on Tags : Add new milestone and verify the same
13) Click on Integrations and verify total number of Configure buttons
14) close the browser

---------------------------
-- Issues encountered
---------------------------
1. Test Ignored when running test case with data provider
Solution: Create excel file from one drive / excel online

2. Test ignored - check sheet name if correct


---------------------------
-- Daily Updates
---------------------------
18-Feb : completed Test Case 1, added Logger but seems not working
19-Feb : to do test case 2

resumed
6-Mar : steps 1-4 done
8-Mar : step 5 - error below


org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of Proxy element for: DefaultElementLocator 'By.xpath: //h1[@class='sp-page__title']' (tried for 100 second(s) with 500 MILLISECONDS interval)

	at com.sel.qa.util.CRMUtil.waitForElementToBeVisible(CRMUtil.java:161)
	at com.sel.qa.pages.CRMAccountSettingsPage.clickSubMenu(CRMAccountSettingsPage.java:78)
	at com.qa.tests.CRMTestCase2.verifyAccountSettingsTest(CRMTestCase2.java:54)

14-Mar : step 6-7 done
15-Mar : step 8
21-Mar : step 9
22-Mar : step 10 - done on 25th Mar
26-Mar : step 11 - done
29-Mar : step 12-13 COMPLETED
"# SeleniumChallenge3" 
