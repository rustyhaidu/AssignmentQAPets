package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class UserStory1Test extends BaseUserStoryTest {


    @Test
    public void currentDateTest() {
        WebElement headerLabel = homePage.getHeaderLabel();
        String sActCurrentDate = headerLabel.getText();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        String sExpCurrentDate = dtf.format(localDate);

        Assert.assertEquals(sActCurrentDate, sExpCurrentDate, "Comparing the application date with the current date");
    }

    @Test
    public void bannerColorTest(){
        WebElement headerLabel = homePage.getHeaderBanner();
        String sActRGBColor = headerLabel.getCssValue("background-color");
        String sExpBannerColor = "#333333";

        String s1 = sActRGBColor.substring(4);
        sActRGBColor = s1.replace(")", "");
        sActRGBColor = sActRGBColor.replace("(", "");
        StringTokenizer st = new StringTokenizer(sActRGBColor);
        int r = Integer.parseInt(st.nextToken(",").trim());
        int g = Integer.parseInt(st.nextToken(",").trim());
        int b = Integer.parseInt(st.nextToken(",").trim());
        Color c = new Color(r, g, b);
        String sExpHashCode = "#"+Integer.toHexString(c.getRGB()).substring(2);
        System.out.println(sExpHashCode);

        Assert.assertEquals(sExpBannerColor, sExpHashCode, "Checking that the banner color is black/gray");
    }
}
