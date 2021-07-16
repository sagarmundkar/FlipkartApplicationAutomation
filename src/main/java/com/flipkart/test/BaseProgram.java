package com.flipkart.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseProgram {
    public static WebDriver driver;

        @BeforeTest
        public void setUp(){

            WebDriverManager.chromedriver().setup();
            //Launch the chrome browser
            driver = new ChromeDriver();
            //Manage the window
            driver.manage().window().maximize();
            //Enter the url
            driver.get("https://www.flipkart.com/");

        }
        @AfterTest
        public void tearDown(){
            //close the browser
            driver.close();
        }
    }



