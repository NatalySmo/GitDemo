import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class databaseConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host="localhost";

		String port= "3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/socialnet", "root", "nataly");

		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("SELECT * FROM EXAM_RESULTS WHERE STUDENT_ID = 14");
		
		while(rs.next())
			
		{	
		System.out.println(rs.getString("LAST_NAME"));
		System.out.println(rs.getString("EXAM_SCORE"));
		

		
	
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		 driver.get("https://login.salesforce.com");
		 
		 driver.findElement(By.id("username")).sendKeys(rs.getString("LAST_NAME"));
		 driver.findElement(By.id("password")).sendKeys(rs.getString("EXAM_SCORE"));
			
		
	}
	}
}

