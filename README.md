
## Please check the Marsdevs Framework Branch.

# MarsDevs-Assignments
1. Project Title
MarsDevs Automation QA Challenge – UI Automation Framework

2. Objective
   This project is a Selenium + TestNG based UI automation framework
designed to automate core e-commerce user flows such as login,
product browsing, cart operations, and checkout.

The goal is to demonstrate framework design, reusability,
synchronization, reporting, and scalability.

3.Tool & Technology Stack
Automation Tool: Selenium WebDriver
Language: Java
Test Framework: TestNG
Build Tool: Maven
Reporting: Extent Reports
Browser Support: Chrome 
4.Application Under Test (UAT)
Application Under Test:
https://www.saucedemo.com/

Reason for selection:
- Public demo e-commerce application
- Supports login, product listing, sorting, cart, and checkout
- Stable UI suitable for automation testing

5. Automated Test Scenarios

   Automated Scenarios:

1. Login
   - Valid login
   - Invalid login validation
   - Logout

2. Product Browsing
   - Sort products by price and name
   - Validate sorting order

3. Cart
   - Add multiple products
   - Validate cart count and product details
   - Remove product and validate

4. Checkout
   - Successful checkout flow
   - Checkout form validation (mandatory fields)
  
    5. Framework Design
  
- Page Object Model (POM)
- Centralized wait handling using ExplicitWaitFactory
- No hard-coded waits (no Thread.sleep)
- Thread-safe WebDriver using ThreadLocal
- Reusable BasePage methods

  7. Configuration Management
 
     Configuration:
- Base URL
- Browser type
- Credentials
- Screenshot flags

   8. Test Data Handling
   
- Credentials and test values are externalized
- Framework supports data-driven testing via TestNG and config files

9. Reporting & Screenshots
    Reporting:
- Extent HTML reports
- Screenshots captured on:
  - Test failure
  - Test success (configurable)
 
  - 10. Project Structure (High-level)
   
    Project Structure:
- Driver: WebDriver initialization and management
- Pages: Page Object classes
- Utils: Utilities (property, screenshot)
- Reports: Extent report setup
- Testcases: TestNG test classes

- Non-Functional Considerations

- Non-Functional Highlights:
- Clean and readable code
- Independent test execution
- Meaningful assertions
- Scalable and maintainable framework design


