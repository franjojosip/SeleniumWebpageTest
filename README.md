# Selenium Webpage test
> A framework for testing web application

[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/)
![Size](https://img.shields.io/github/repo-size/franjojosip/SeleniumWebpageTest)
[![Generic badge](https://img.shields.io/badge/version-dev-<COLOR>.svg)](https://shields.io/)

This is a framework for automated software testing made for Testing college project based on Java programming language in InteliJ program which can be easily managed.

---
### Instalation
- [Install InteliJ](https://www.jetbrains.com/idea/download/#section=windows)
- [Install JavaSDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

- After instalation and creating project open Maven repository to download needed dependecies on Maven link below:
JetBrains Java Anotation, WebJars, RelevantCodes, Bonigarcia, Logging.log4j, Selenium, TestNG
- [Maven Repository](https://mvnrepository.com/)
- To clone on your computer use: `git clone https://github.com/franjojosip/SeleniumWebpageTest.git`
---
**This repo contains the following tools and tehniques for creating the frame:**
- WebDriver
- WebDriverManager
- PageFactory
- Cross Browser testing
- Page object model
- Reporting
- Screenshot
- OOP
- Wait

### WebDriverManager
Allows user to run tests on different browsers and manage of the binary drivers like chromedriver, gecko...
You don't need to download the driver's binary file (.exe)

### PageFactory and Wait
Class which is used like extension in Selenium to initialize the elements which can be found on the page you are testing.
By using @FindBy annotation it will automatically look for specific WebElement. This extension is combined with Wait function which will improve time to load steps of the test and remove potential problems when test continue and fail because WebElement is not loaded on page.

### Cross Browser testing
Test web application accross multiple browsers and it will ensure that your web application work on different web browser.

### Page object model
Design pattern for enhancing automation test maintenance. It's using Object oriented class that servers as an interface to a page.

### Reporting and Screenshot
ExtentReports will help us to know what steps did test do and where was fail. If step fail it will be recorded with TakesScreenshot class and saved in your report.

![report](https://user-images.githubusercontent.com/52075105/73295518-210ea180-4208-11ea-981e-defa98fa01b9.png)

## Tests

| Test class| Description|
| ----------|:----------:|
| ChangeBasketTest| Test which will search for product with search field, choose product size and add one product to basket. After that it will change quantity in basket to 3|
| CleanBasketTest| Test will hover over first link which will trigger dropdown menu and it will choose man shoes. Then it will pick shoes size and add product to basket. Finally it will use clean basket button and check if basket is empty.|
| LoginTest| This test is using email from 10min emails with test password. It will open home page, insert email and password and try to log in. If test successfull page will show success message.|
| PageCrumbsTest| Test will hover over clothes link and choose handball shoes. Secondly automation clicks on gender row and choose men gender and then after page reload select first shoes. If test is correct there will be wanted word in page crumbs.|
| RegisterTest| For register test will load 10 minutes email page and copy email. Then it will go to web shop and click on Register. After that fill out the form with given credentials and user information and try to register. If register successful, success message will be shown.|
| WomenShoesFilterTest| Test goes to homepage of web shop and hover over shoes and choose fashion shoes. Then it clicks gender row and select women gender. Finally it will check if page properly loaded shoes for specific gender.|

## Related Topics

- [How to take screenshot in Selenium](https://www.browserstack.com/guide/take-screenshots-in-selenium)
- [Add Reporting in Selenium](https://www.youtube.com/watch?v=zSjwgjVl4P4)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
