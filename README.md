# Your-Store — BDD Automation Framework for E-Commerce Web Application

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.27.0-green?style=flat-square&logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-7.20.1-brightgreen?style=flat-square&logo=cucumber)
![JUnit](https://img.shields.io/badge/JUnit-5-red?style=flat-square&logo=junit5)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=flat-square&logo=apachemaven)

---

## 📌 Project Overview

**Your-Store** is an end-to-end BDD (Behaviour Driven Development) test automation project built to validate the core functionality of an e-commerce web application — [Tutorials Ninja Demo Store](https://tutorialsninja.com/demo/).

The framework is designed using **Selenium WebDriver** for browser automation and **Cucumber** for writing human-readable test scenarios in Gherkin syntax. It follows the **Page Object Model (POM)** design pattern to ensure clean separation of test logic and UI interaction, making the suite maintainable and scalable.

---

## 🎯 What is Tested?

The following critical e-commerce modules are covered:

| Module | Test Coverage |
|---|---|
| User Registration | Valid & invalid registration flows |
| Login / Logout | Valid credentials, invalid credentials, empty fields |
| Product Search | Search by keyword, filters, no results scenarios |
| Product Navigation | Browse categories, product detail page |
| Add to Cart | Add single/multiple items, update quantity |
| Checkout | Guest & registered user checkout flow |
| Order Validation | Order confirmation and summary validation |

---

## 🛠️ Tech Stack

| Tool / Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Programming language |
| Selenium WebDriver | 4.27.0 | Browser automation |
| Cucumber | 7.20.1 | BDD framework (Gherkin scenarios) |
| JUnit | 5.11.0 | Test runner & assertions |
| Maven | Latest | Build tool & dependency management |
| Apache Commons Lang | 3.12.0 | Utility functions |
| Eclipse IDE / IntelliJ IDEA | — | Development environment |
| Git & GitHub | — | Version control |

---

## 🏗️ Framework Architecture

This project follows the **Page Object Model (POM)** design pattern combined with **BDD using Cucumber**.

```
Your_Store/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── pageObjects/        # Page Object classes (one per page)
│       │   ├── stepDefinitions/    # Cucumber step definition classes
│       │   ├── runner/             # JUnit Cucumber Runner class
│       │   └── utilities/          # Helper/utility classes
│       │
│       └── resources/
│           └── features/           # Gherkin .feature files
│
├── pom.xml                         # Maven dependencies & build config
└── README.md
```

### Design Pattern
- **Page Object Model (POM)** — each web page has a dedicated Java class containing WebElement locators and action methods
- **BDD with Cucumber** — test scenarios written in plain English (Gherkin) in `.feature` files, mapped to Java step definitions
- **JUnit Runner** — `@RunWith(Cucumber.class)` with `@CucumberOptions` configures feature file paths, step definitions package, and report plugins

---

## ⚙️ Prerequisites

Make sure the following are installed before running the project:

- ✅ **Java JDK 17** or later — [Download](https://www.oracle.com/java/technologies/downloads/)
- ✅ **Maven** — [Download](https://maven.apache.org/download.cgi)
- ✅ **Eclipse IDE** or **IntelliJ IDEA**
- ✅ **Google Chrome** (latest) — Selenium 4 uses built-in ChromeDriver Manager, no manual driver setup needed
- ✅ **Git** — [Download](https://git-scm.com/)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Amitkr83402/Your_Store.git
cd Your_Store
```

### 2. Install Dependencies

```bash
mvn clean install -DskipTests
```

### 3. Run All Tests

```bash
mvn test
```

### 4. Run a Specific Feature File

```bash
mvn test -Dcucumber.filter.tags="@login"
```

### 5. Run Tests by Tag

```bash
# Run smoke tests only
mvn test -Dcucumber.filter.tags="@smoke"

# Run regression tests
mvn test -Dcucumber.filter.tags="@regression"
```

---

## 📊 Test Reports

After test execution, reports are generated at:

| Report Type | Location |
|---|---|
| JUnit / Surefire Report | `target/surefire-reports/` |
| Cucumber HTML Report | `target/cucumber-reports/` |
| Cucumber JSON Report | `target/cucumber.json` |

Open the HTML report in any browser to view detailed step-by-step results with pass/fail status.

---

## 🔑 Key Features

- ✅ **BDD Framework** — test scenarios written in plain English using Gherkin, readable by non-technical stakeholders
- ✅ **Page Object Model** — clean separation between test logic and page interactions for easy maintenance
- ✅ **Data-Driven Testing** — Cucumber Scenario Outline with Examples table for running the same scenario with multiple data sets
- ✅ **Selenium 4** — latest WebDriver with built-in browser driver management (no manual ChromeDriver setup)
- ✅ **Maven Build** — all dependencies managed via `pom.xml`, easy to set up on any machine
- ✅ **Scalable Structure** — adding new test scenarios only requires a new feature file and step definitions, no changes to existing code

---

## 📝 Sample Feature File

```gherkin
Feature: User Login

  @smoke @login
  Scenario: Successful login with valid credentials
    Given User navigates to the Your-Store home page
    When User clicks on the Login link
    And User enters valid email and password
    And User clicks the Login button
    Then User should be redirected to the My Account page

  @regression @login
  Scenario Outline: Login with invalid credentials
    Given User navigates to the Your-Store home page
    When User clicks on the Login link
    And User enters "<email>" and "<password>"
    And User clicks the Login button
    Then User should see an error message

    Examples:
      | email              | password   |
      | invalid@test.com   | wrongpass  |
      | empty              | empty      |
```

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch — `git checkout -b feature/your-feature-name`
3. Commit your changes — `git commit -m "Add: description of change"`
4. Push to the branch — `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## 📞 Contact

**Amit Kumar Yadav**
- 📧 Email: [123amit987kumar@gmail.com](mailto:123amit987kumar@gmail.com)
- 🔗 LinkedIn: [linkedin.com/in/amit-kumar-yadav-tech](https://www.linkedin.com/in/amit-kumar-yadav-tech/)
- 🐙 GitHub: [github.com/Amitkr83402](https://github.com/Amitkr83402)

---

> ⭐ If you found this project useful, consider giving it a star!
