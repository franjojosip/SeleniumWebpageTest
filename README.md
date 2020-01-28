# Selenium Webpage test
> A framework for testing web application

[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/)
![Size](https://img.shields.io/github/repo-size/franjojosip/SeleniumWebpageTest)
[![Generic badge](https://img.shields.io/badge/version-dev-<COLOR>.svg)](https://shields.io/)

This is a framework for automated software testing made for Testing college project based on Java programming language in InteliJ program which can be easily managed.

### Instalation
- [Install InteliJ](https://www.jetbrains.com/idea/download/#section=windows)
- [Install JavaSDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

After instalation and creating project open Maven repository to download needed dependecies on Maven link below:
JetBrains Java Anotation, WebJars, RelevantCodes, Bonigarcia, Logging.log4j, Selenium, TestNG

- [Maven Repository](https://mvnrepository.com/)

This repo contains the following tools and tehniques for creating the frame:
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
