package SLM.project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class a5CalenderDropDown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");

        WebElement calander1 = driver.findElement(By.xpath("//input[@id='from_date']"));
        calander1.click();

        String monthvalue = "January";
        String yearvalue = "2025";
        String datevalue = "4";

        boolean isfound=false;

        while (!isfound) {
            WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            WebElement year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            String currentMonth = month.getText();
            String currentYear = year.getText();

            if (currentMonth.equals(monthvalue) && currentYear.equals(yearvalue)) {
                //select the date
                List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
                for(WebElement date:allDates){
                    if(date.getText().equals(datevalue)){
                        date.click();
                        isfound=true;
                        break;
                    }

                }
            } else {
                //click on next button
                WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
                nextBtn.click();
            }
        }

    }
}