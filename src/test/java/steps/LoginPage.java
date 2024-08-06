package steps;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginPage {
	
	private static WebDriver driver;
    public final static int TIMEOUT = 5;
	
	@Before
    public void setUp() {
		
		// Before Driver initilization 
		// start maximized 
		// Launch the chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
 
    }
	
	@Given("the user is on the login page {string}")
	public void the_user_is_on_the_login_page(String url) {
	    
		driver.get(url);
	}

	@When("the user enters valid credentials")
	public void the_user_enters_valid_credentials(DataTable dataTable) {
	   
		 String username = null ;
		 String password = null;
		 List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
		 
	        for (Map<String, String> row : credentials) {
	        	
	             username = row.get("username");
	             password = row.get("password");
	            System.out.println("Username: " + username);
	            System.out.println("Password: " + password);
	        }
	               
	        // login to application
	        driver.findElement(By.name("username")).sendKeys(username);
	        driver.findElement(By.name("password")).sendKeys(password);
	        
	  
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		
		driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();
	  
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
	  
		   String homePageHeading = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6")).getText();		   
	        //Verify new page - HomePage
	        Assert.assertEquals(homePageHeading, "Dashboard");
	}

	@After
    public void teardown() {
 
        driver.quit();
    }

}
