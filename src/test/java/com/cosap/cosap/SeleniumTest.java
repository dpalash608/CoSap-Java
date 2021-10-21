package com.cosap.cosap;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.test.context.event.annotation.BeforeTestClass;

class SeleniumTest {
private WebDriver driver;

@BeforeEach
void setUp() throws Exception {
    String username = "YOUR_USERNAME";
    String authkey = "YOUR_AUTHKEY";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    
        HashMap<String, String> cbtoptions = new HashMap<String, String>();
        capabilities.setCapability("browserName", "Chrome");
    capabilities.setCapability("platformName", "Windows 10");
    capabilities.setCapability("name", "Junit Example");
    capabilities.setCapability("browserVersion", "84");
    capabilities.setCapability("cbt:options", cbtoptions);

    String hubAddress = String.format("http://%s:%s@hub.crossbrowsertesting.com:80/wd/hub", username, authkey);
    URL url = new URL(hubAddress);

    driver = new RemoteWebDriver(url, capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}

@AfterEach
void tearDown() throws Exception {
    driver.quit();

}

@Test
void test() {
    
    driver.get("http://localhost:8080/");
    assertEquals("localhost:8080", driver.getTitle());

}
}
