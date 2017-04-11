package TestCaseSAU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kamkam on 4/4/2017.
 */
public class Test12 {

    public WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        driver = new ChromeDriver();
        ChromeOptions o = new ChromeOptions();
        o.addArguments("disable-extensions");
        driver.get("https://www.google.com");


    }

    @Test
    public void TestGooele()
    {
        ///.//*[@id='tsf']/div[2]/div[3]/center/input[1]
        String color =driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]")).getCssValue("color");
        //         String s1 = color.substring(5);
//         StringTokenizer st = new StringTokenizer(s1);
//         int r = Integer.parseInt(st.nextToken(",").trim());
//         int g = Integer.parseInt(st.nextToken(",").trim());
//         int b = Integer.parseInt(st.nextToken(",").trim());
//         Color c = new Color(r, g, b);
//         String hex = "#"+Integer.toHexString(c.getRGB()).substring(2);
        System.out.println(color);
    }
}
