package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public void testCase01() throws Exception {
        System.out.println("Start Test case: testCase01");
        openGoogleCalender();
        System.out.println("Verify that the current URL contains \"calendar.\" :" + (driver.getCurrentUrl().contains("calendar") ? "Pass" : "Fail"));
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws Exception {
        System.out.println("Start Test case: testCase02");
        openGoogleCalender();

        WebElement selectCalendarTypeBtn = driver.findElement(By.xpath("(//button[@aria-haspopup='menu'])[2]"));
        selectCalendarTypeBtn.click();
        Thread.sleep(2000);

        WebElement selectMonth = driver.findElement(By.xpath("//li[@data-viewkey='month']"));
        selectMonth.click();
        Thread.sleep(4000);
        WebElement validatingSelectMonth = driver.findElement(By.xpath("(//span[text()='Month'])[1]"));
        System.out.println(validatingSelectMonth.getText().contains("Month"));


//
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
//        String dayOfMonth = simpleDateFormat.format(date);
//
//        WebElement fullCalender = driver.findElement(By.className("K2fuAf"));
//        WebElement todayDate = fullCalender.findElement(By.xpath("//h2[text()='"+dayOfMonth+"']/.."));


        WebElement date = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div[7]"));
        date.click();
        Thread.sleep(4000);

        WebElement clickTask = driver.findElement(By.xpath("//button[@id='tabTask']/div[text()='Task']"));
        clickTask.click();
        Thread.sleep(4000);


        WebElement addTask = driver.findElement(By.xpath("//input[@placeholder='Add title and time']"));
        addTask.sendKeys("Crio INTV Task Automation");
        Thread.sleep(4000);


        WebElement addDescription = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        addDescription.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(4000);


        WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
        WebElement saveBtn = save.findElement(By.xpath("./.."));
        saveBtn.click();
        Thread.sleep(4000);

//        WebElement taskCompleted = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[text()='Task created'])[2]")));
//                //driver.findElement(By.xpath("(//div[text()='Task created'])[2]"));
//        boolean isplaying = taskCompleted.isDisplayed();
//        System.out.println(isplaying + " task has been created");
        System.out.println("end Test case: testCase02");
        Thread.sleep(4000);
    }


    public void testCase03 () throws Exception {
        System.out.println("Start Test case: testCase03");
        openGoogleCalender();

        Thread.sleep(4000);

        WebElement task = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
        Thread.sleep(4000);


        if(task.isDisplayed()){
            task.click();
            WebElement modify= driver.findElement(By.xpath("(//span[@class='VfPpkd-kBDsod meh4fc KU3dEf'])[3]"));
            modify.click();


            String desc = "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application";

            WebElement addDescription = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
            addDescription.clear();
            addDescription.sendKeys(desc);
            Thread.sleep(4000);


            WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
            WebElement saveBtn = save.findElement(By.xpath("./.."));
            saveBtn.click();
            Thread.sleep(4000);

            task.click();
            Thread.sleep(4000);
//            WebElement  descriptionText = driver.findElement(By.xpath("//span[text()='Description:']/.."));
            WebElement  descriptionText = driver.findElement(By.xpath("//div[text()='"+desc+"']"));
            System.out.println(descriptionText.getText().contains(desc));
            System.out.println(descriptionText.getText());
            System.out.println(desc);

            Thread.sleep(4000);

            WebElement updated = driver.findElement(By.xpath("//div[text()='Task updated']"));
            boolean a = updated.isDisplayed();

        }

        Thread.sleep(4000);


    }

    public void testCase04() throws Exception {
        System.out.println("Start Test case: testCase04");
        openGoogleCalender();

        Thread.sleep(4000);

        WebElement task = driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
        Thread.sleep(4000);


        if(task.isDisplayed()) {
            task.click();
            Thread.sleep(4000);

            WebElement delete = driver.findElement(By.xpath("//div[@jsaction='JIbuQc:qAGoT']"));
            delete.click();
//            Thread.sleep(4000);

            WebElement taskDeleted = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("YrbPvc")));
//                driver.findElement(By.xpath("(//div[text()='Task created'])[2]"));
       // boolean isplaying = taskDeleted.isDisplayed();
        //System.out.println(isplaying + " task has been deleted");
            WebElement t = taskDeleted.findElement(By.xpath("//div[text()='Task deleted']"));
            System.out.println(taskDeleted.getText());
            System.out.println(taskDeleted.getText().contains("Task deleted"));


        }
        System.out.println("end Test case: testCase04");
    }


    private void openGoogleCalender() {
        driver.get("https://calendar.google.com/");
    }


}
