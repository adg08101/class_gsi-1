package selenium_cucumber.selenium_cucumber.general;

import io.cucumber.datatable.internal.difflib.myers.MyersDiff;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;

public final class Setup {
	private static WebDriver driver;
	private static HashMap<String, Object> store = new HashMap();
	private static JavascriptExecutor jsExecutor;
	private static Actions actions;
	private static WaitingObject waitingObject;

	@Before
	public void InitSetup() {
		String browser = System.getProperty("browser");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "D://Documents//QA-Automation//Google//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> timeouts = new HashMap();
		timeouts.put("implicit", 50);
		timeouts.put("pageLoad", 5000000);
		timeouts.put("script", 300000);
		options.setCapability("timeouts", timeouts);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		initObject();
	}

	private static void initObject() {
		waitingObject = new WaitingObject(driver);
		actions = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		loadDefaultProperties();
	}

	public static Object executeScript(String script,Object... arg) {
		return jsExecutor.executeScript(script,arg);
	}

	public static Actions getActions() {
		return actions;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 *
	 * @param key
	 * @return
	 */
	public static Object getValueStore(String key) {
		return store.get(key);
	}

	/**
	 *
	 * @return Return an instance of wait.
	 */
	public static WaitingObject getWait() {
		return waitingObject;
	}

	/**
	 *
	 * @param key
	 * @param value
	 */
	public static void setKeyValueStore(String key, Object value) {
		store.put(key, value);
	}

	/**
	 * Open new url
	 *
	 * @param url
	 */
	public static void openUrl(String url) {
		driver.get(url);
		waitingObject.waitForLoading(36000);

	}

	@After
	public void close() {
		driver.close();
	}

	private static void loadDefaultProperties() {
		InputStream input = ClassLoader.class.getResourceAsStream("/defaultproperties.properties");
		Properties pop = new Properties();
		try {
			pop.load(input);
		} catch (java.io.IOException e) {

		}
		setKeyValueStore("defaultProperties", pop);

		setKeyValueStore("avatar", new File(ClassLoader.class.getResource("/avatar.png").getFile()).getAbsolutePath());

	}

}
