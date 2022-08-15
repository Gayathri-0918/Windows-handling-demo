package practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WHdemo2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Desktop\\maven project selenium\\project1\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().window().maximize();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//button[@onclick='newMsgWin()']")).click();
		Set<String> allwindows=driver.getWindowHandles();
		System.out.println(allwindows);
		Iterator<String> itr=allwindows.iterator();
		while(itr.hasNext())
		{
			String child_window=itr.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);

			System.out.println(driver.switchTo().window(child_window).getTitle());
			driver.close();
		}

	}

	}

}
