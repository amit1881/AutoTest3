package SeleniumIntegration.MavenJenkins;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;


//Non-TestNG Project

public class POMSignup{
	
	private static ScreenRecorder screenRecorder;
	private static WebDriver driver = null;
	private static String sessionId;
	
	public static void main(String[] args) throws IOException, AWTException {
		
		File file = new File("D:\\screenshots");  
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
                       
        Rectangle captureSize = new Rectangle(0,0, width, height);
		GraphicsConfiguration gconfig = GraphicsEnvironment
			         .getLocalGraphicsEnvironment()
			         .getDefaultScreenDevice()
			         .getDefaultConfiguration();
			      /*
			       * 
			       * save file at a default location in videos folder in windows
			       */
			      
		            /*
		             screenRecorder = new ScreenRecorder(gconfig,
			         new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey,
			         MIME_AVI),
			         new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
			         ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
			         CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
			         DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
			         QualityKey, 1.0f,
			         KeyFrameIntervalKey, (int) (15 * 60)),
			         new Format(MediaTypeKey, MediaType.VIDEO,
			         EncodingKey,"black",
			         FrameRateKey, Rational.valueOf(30)), null);
			         
			         */
		
		       /*
		        * save file at the desired location
		        */
		screenRecorder = new SpecializedScreenRecorder(gconfig, captureSize,
	               new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	                    QualityKey, 1.0f,
	                    KeyFrameIntervalKey, 15 * 60),
	               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
	                    FrameRateKey, Rational.valueOf(30)),
	               null, file, "MyVideo");
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
	        caps.setCapability("platform", "Linux");
	        caps.setCapability("version", "41");
	        caps.setCapability("name", "Web Driver demo Test");
	        caps.setCapability("tags", "Tag1");
	        caps.setCapability("build", "v1.0");
	        WebDriver driver = new RemoteWebDriver(
	                new URL("http://amit1881:c33b1e5d-0656-41e9-87f0-5c16dc26e576@ondemand.saucelabs.com:80/wd/hub"),
	                caps);
	       
	        sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
	        System.out.println("Session Id="+ sessionId);
	      driver = new FirefoxDriver();
	      
	      // Start Capturing the Video
	      screenRecorder.start();
	      
	      //implicit wait
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://socialsofttesthb.com/sign-up");
	      driver.manage().window().maximize();
	      
	    //Use page Object library now
	      
	    //Enter first name
	      TestHelper.firstName(driver).clear();
	      TestHelper.firstName(driver).sendKeys("amit");
	    //Enter second name
	      TestHelper.lastName(driver).clear();
	      TestHelper.lastName(driver).sendKeys("singh");
	    //Enter email address
	      TestHelper.emailAddress(driver).clear();
	      TestHelper.emailAddress(driver).sendKeys("amit1234567@ravabe.com");
	    //Select Time Zone
	      TestHelper.selectTimeZone(driver);
	    //Enter password
	      TestHelper.password(driver).clear();
	      TestHelper.password(driver).sendKeys("Amit1234");
	    //accept terms and conditions 
	      TestHelper.acceptTerms(driver).click();
	    //Click on signup button
	      TestHelper.signup(driver).click();
	      
	      //Save screenshot
	      File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File("D:\\screenshots\\screenshots1.jpg"));
	      
	      //Save video
	      //File sr=(File) OutputType.FILE;
	      //FileUtils.copyFile(screenRecorder, new File("D:\\video"));
	      
	    //Explicit wait
	      WebDriverWait wait=new WebDriverWait(driver,10);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div")));
	      driver.close();
	      
	   // Stop the ScreenRecorder
	      screenRecorder.stop();
	      
	      
	     
	      
	      
	}
	
}

class SpecializedScreenRecorder extends ScreenRecorder {
	 
    private String name;
 
    public SpecializedScreenRecorder(GraphicsConfiguration cfg,
           Rectangle captureArea, Format fileFormat, Format screenFormat,
           Format mouseFormat, Format audioFormat, File movieFolder,
           String name) throws IOException, AWTException {
         super(cfg, captureArea, fileFormat, screenFormat, mouseFormat,
                  audioFormat, movieFolder);
         this.name = name;
    }
 
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
          if (!movieFolder.exists()) {
                movieFolder.mkdirs();
          } else if (!movieFolder.isDirectory()) {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
          }
                           
          SimpleDateFormat dateFormat = new SimpleDateFormat(
                   "yyyy-MM-dd HH.mm.ss");
                         
          return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "."
                  + Registry.getInstance().getExtension(fileFormat));
    }
 }

