package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/8.
 */
public class WindowSelectTest {

    WebDriver driver;


    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "F:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     * 打开测试界面
     * 点击 Open new window
     * 点击 baidu
     */
    @Test
    public void testWin() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");

        //      当前driver所在的页面的 句柄值
        String handle1 = driver.getWindowHandle();

        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);

//      For 循环判断 获取到的handles是否等于handle1
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        driver.findElement(By.linkText("baidu")).click();

        driver.switchTo().window(handle1);
    }
}
