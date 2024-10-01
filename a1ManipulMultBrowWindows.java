package SLM.project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class a1ManipulMultBrowWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo-homework.php");

        String mainPageWH=driver.getWindowHandle();
        System.out.println("The main page WH is "+mainPageWH);


        //clicking on button B1
        WebElement b1= driver.findElement(By.xpath("//a[@class='btn btn-primary followeasy']"));
        b1.click();

        //ensuring that clicking ont B1 opens a new window
        Set<String> allHandles=driver.getWindowHandles();
        for(String handle:allHandles){
            if(handle.equals(mainPageWH)) {
            }else {
                driver.switchTo().window(handle);
                String url= driver.getCurrentUrl();
                System.out.println("The B1 button opened the new page "+url);

                //verifying that the text in the window is the same as acceptance criteria
                WebElement textBox= driver.findElement(By.xpath("//h2[text()='Welcome to B! page']"));
                String text=textBox.getText();
                if(text.equals("Welcome to B1 page")){
                    System.out.println("The texts are the same, verification passed");
                }else {
                    System.out.println("The texts are not the same, verification failed");
                }
            }
        }
        String b1Handle= driver.getWindowHandle();
        System.out.println("The button1 page window handle is "+b1Handle);

        driver.switchTo().window(mainPageWH);


        //clicking on B2

        WebElement b2= driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        b2.click();

        //ensuring that clicking ont B1 opens a new window
        allHandles=driver.getWindowHandles();
        for(String handle:allHandles){
            if(handle.equals(mainPageWH)||handle.equals(b1Handle)){
            }
            else {
                driver.switchTo().window(handle);
                String url= driver.getCurrentUrl();
                System.out.println("The B2 button opened the new page "+url);

                //verifying that the text in the window is the same as acceptance criteria
                WebElement textBox= driver.findElement(By.xpath("//h2[text()='Welcome to B2 page']"));
                String text1=textBox.getText();
                if(text1.equals("Welcome to B2 page")){
                    System.out.println("The texts are the same, verification passed");
                }else {
                    System.out.println("The texts are not the same, verification failed");
                }
            }
        }

    }
}