# selenium-bstack-demo  
--> check the automation project in the master branch

Selenium Automation Framework using Java, TestNG, and Page Object Model for BrowserStack Demo

# 🧪 Selenium Automation Framework – BrowserStack Demo

## 📌 1. Capstone Project Title

**Automation Testing Framework for bstackdemo.com using Java and Selenium**

---

## 🌐 2. Domain

E-Commerce Web Application

---

## 🔗 3. Application Under Test (AUT)

**Website:** https://bstackdemo.com/

**Description:**
bstackdemo.com is a sample e-commerce application provided by BrowserStack to demonstrate cross-browser testing. It includes features such as:

* User login
* Product catalog
* Filtering
* Add to cart
* Checkout and order placement

---

## 🎯 4. Project Objective

To design and implement a modular and scalable automation testing framework using:

* Java
* Selenium WebDriver
* TestNG

---

## 🛠️ 5. Tools and Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* ExtentReports
* Git & GitHub

---

## 🏗️ 6. Framework Architecture

**Design Pattern:** Page Object Model (POM)

### 🔹 Components:

* `BaseTest.java` – WebDriver setup & configuration
* `LoginPage.java`, `ProductPage.java`, `CartPage.java`, `CheckoutPage.java`
* `ConfigReader.java`, `WebDriverFactory.java`, `WaitUtils.java`
* Test Classes: `LoginTest`, `AddToCartTest`, `CheckoutTest`
* `testng.xml` – Test suite configuration
* Extent Reports for reporting

---

## 📦 7. Modules Covered

* Login
* Product Listing
* Add to Cart
* Cart Verification
* Checkout

---

## 🧪 8. Test Scenarios

### 🔐 Login Tests

* TC_001: Login with valid credentials
* TC_002: Login with invalid credentials
* TC_003: Login with empty fields

### 🛒 Cart Tests

* TC_004: Add single item to cart
* TC_005: Add multiple items and verify count
* TC_006: Remove item from cart

### 💳 Checkout Tests

* TC_007: Place order with valid details
* TC_008: Checkout without items (negative test)

---

## 📁 9. Project Structure

```plaintext
selenium-bstack-demo/
│
├── pom.xml
├── testng.xml
├── README.md
├── .gitignore
│
├── src/
│
├── main/java/
│   ├── base/
│   │   ├── BaseTest.java
│   │   ├── DriverFactory.java
│   │
│   ├── pages/
│   │   ├── LoginPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │
│   ├── utils/
│   │   ├── ConfigReader.java
│   │   ├── WaitUtils.java
│   │   ├── ScreenshotUtils.java
│   │   ├── TestDataUtils.java
│   │
│   ├── constants/
│   │   ├── FrameworkConstants.java
│
│
├── test/java/
│   ├── tests/
│   │   ├── LoginTest.java
│   │   ├── ProductTest.java
│   │   ├── CartTest.java
│   │   ├── CheckoutTest.java
│   │
│   ├── listeners/
│   │   ├── TestListener.java
│   │
│   ├── retry/
│   │   ├── RetryAnalyzer.java
│
├── src/test/resources/
│   ├── testdata/
│   │   ├── testdata.json
│   │
│   ├── config.properties
│   ├── log4j2.xml
│
└── screenshots/
---

## ▶️ 10. Execution

## Using Maven:
Plugins:
- Compiler plugin
- SureFire plugin
```bash --Goals
 - mvn clean 
 - mvn test
 - mvn install
```

## Using TestNG:

Run `testng.xml` from IDE or via Maven Surefire plugin

### Using Jenkins

---

## 📊 11. Reporting

* Extent Reports for HTML reports
* TestNG default reports in `/test-output` folder

---



