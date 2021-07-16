package com.flopkart.test;

import com.flipkart.test.BaseProgram;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;
import pages.Logout;
import pages.Registration;

import java.awt.*;

public class TestPages extends BaseProgram {
    @Test
    public void Registration() throws InterruptedException {
        Registration registration = new Registration(driver);
        registration.registration();
    }

    @Test
    public void Login() throws InterruptedException {
        Login login = new Login(driver);
        login.LoginApplication();
    }

    @Test
    public void Home() throws InterruptedException {
        Login login = new Login(driver);
        login.LoginApplication();

        Home home = new Home(driver);
        home.SearchProduct();
    }

    @Test
    public void Logout() throws InterruptedException, AWTException {
        Login login = new Login(driver);
        login.LoginApplication();

        Logout logout = new Logout(driver);
        logout.LogoutApplocation();
    }

}
