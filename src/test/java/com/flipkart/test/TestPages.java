package com.flipkart.test;
import io.qameta.allure.*;
import jdk.jfr.Description;
import listeners.ListenerTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;
import pages.Logout;
import pages.Registration;

import java.awt.*;

@Listeners(ListenerTest.class)

public class TestPages extends BaseProgram {

    @Test(priority = 0)
    @Description("Registration to the Flipkart Page")
    @Epic("EP001")
    @Story("Registration Page")
    @Feature("Feature1: Registration")
    @Severity(SeverityLevel.NORMAL)
    public void Registration() throws InterruptedException {
        Registration registration = new Registration(driver);
        registration.registration();
    }

    @Test(priority = 1)
    @Description("Login to the Flipkart Page")
    @Epic("EP002")
    @Story("Valid Credentials Login")
    @Feature("Feature2: Login")
    @Severity(SeverityLevel.NORMAL)
    public void Login() throws InterruptedException {
        Login login = new Login(driver);
        login.LoginApplication();
    }

    @Test(priority = 2)
    @Description("Home Page")
    @Epic("EP003")
    @Story("Home Page")
    @Feature("Feature3: HomePage")
    @Severity(SeverityLevel.MINOR)
    public void Home() throws InterruptedException {
        Login login = new Login(driver);
        login.LoginApplication();

        Home home = new Home(driver);
        home.SearchProduct();
    }

    @Test(priority = 3)
    @Description("Logout to the Flipkart Page")
    @Epic("EP004")
    @Story("Logout Page")
    @Feature("Feature4: Logout")
    @Severity(SeverityLevel.MINOR)
    public void Logout() throws InterruptedException, AWTException {
        Login login = new Login(driver);
        login.LoginApplication();

        Logout logout = new Logout(driver);
        logout.LogoutApplocation();
    }
}
