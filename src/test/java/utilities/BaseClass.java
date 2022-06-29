package utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (BaseClass.getPropertyString("browser")) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();

				// INIT OPTIONS
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				Map<String, Object> profile = new HashMap<String, Object>();
				Map<String, Object> contentSettings = new HashMap<String, Object>();

				// SET OPTIONS
				// 0 - Default, 1 - Allow, 2 - Block
				contentSettings.put("notifications", 2);
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);

				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();

				// INIT  OPTIONS
				FirefoxOptions optionsF = new FirefoxOptions();
				Map<String, Object> prefsF = new HashMap<String, Object>();
				Map<String, Object> profileF = new HashMap<String, Object>();
				Map<String, Object> contentSettingsF = new HashMap<String, Object>();

				// SET OPTIONS
				// 0 - Default, 1 - Allow, 2 - Block
				contentSettingsF.put("notifications", 2);
				profileF.put("managed_default_content_settings", contentSettingsF);
				prefsF.put("profile", profileF);
				optionsF.setCapability("prefs", prefsF);
				driver = new FirefoxDriver(optionsF);

				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
				
				// INIT  OPTIONS
				EdgeOptions optionsE = new EdgeOptions();
				Map<String, Object> prefsE = new HashMap<String, Object>();
				Map<String, Object> profileE = new HashMap<String, Object>();
				Map<String, Object> contentSettingsE = new HashMap<String, Object>();

				// SET OPTIONS
				// 0 - Default, 1 - Allow, 2 - Block
				contentSettingsE.put("notifications", 2);
				profileE.put("managed_default_content_settings", contentSettingsE);
				prefsE.put("profile", profileE);
				optionsE.setCapability("prefs", prefsE);
				driver = new EdgeDriver(optionsE);

				break;

			case "safari":
				WebDriverManager.safaridriver().setup();
//				driver = new SafariDriver();

				// INIT  OPTIONS
				SafariOptions optionsS = new SafariOptions();
				Map<String, Object> prefsS = new HashMap<String, Object>();
				Map<String, Object> profileS = new HashMap<String, Object>();
				Map<String, Object> contentSettingsS = new HashMap<String, Object>();

				// SET OPTIONS
				// 0 - Default, 1 - Allow, 2 - Block
				contentSettingsS.put("notifications", 2);
				profileS.put("managed_default_content_settings", contentSettingsS);
				prefsS.put("profile", profileS);
				optionsS.setCapability("prefs", prefsS);
				driver = new SafariDriver(optionsS);

				break;

			case "headless":

				// headless
				break;
			}

		}
		return driver;
	}

	// Open Browser
	public static WebDriver openBrowserAndGetURL() {

		driver = BaseClass.getDriver();
		PageInitializer.initialize();
		driver.get(BaseClass.getPropertyString("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies(); //Don't want this one because want to ScreenShot reCaptcha
		return driver;

	}

	// close/quit browser
	public static void tearDown() {
		if (driver != null) {
			// driver.close();
			driver.quit();
			driver = null;
		}
	}

	// configReaderClass
	private static Properties Configfile;

	static {
		try {
			String path = "src/test/resources/propertiesFolder/Config.properties";
			FileInputStream input = new FileInputStream(path);

			Configfile = new Properties();
			Configfile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get String property
	public static String getPropertyString(String key) {

		return Configfile.getProperty(key);
	}

	// get Integer property
	public static Integer getPropertyInteger(String key) {

		String a = Configfile.getProperty(key);
		Integer b = Integer.parseInt(a);

		return b;
	}

	// get Double property
	public static Double getPropertyDouble(String key) {

		String a = Configfile.getProperty(key);
		Double b = Double.parseDouble(a);

		return b;
	}

	// get boolean property
	public static boolean getPropertyBoolean(String key) {

		boolean a = Configfile.getProperty(key).equalsIgnoreCase("false");
		boolean b = Configfile.getProperty(key).equalsIgnoreCase("true");
		boolean c = false;

		if (a) {
			c = false;
		} else if (b) {
			c = true;
		} else {
			System.out.println("---error: check boolean property---");
		}

		return c;
	}

}// class
