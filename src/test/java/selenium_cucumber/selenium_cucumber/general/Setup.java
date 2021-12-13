package selenium_cucumber.selenium_cucumber.general;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public final class Setup {
	private static WebDriver driver;
	private static final HashMap<String, Object> store = new HashMap<>();
	private static JavascriptExecutor jsExecutor;
	private static Actions actions;
	private static WaitingObject waitingObject;
	private static WebDriverWait driverWait;
	private static int waitTime;
	private static Faker faker;

	public static Faker getFaker() {
		return faker;
	}

	public static void setFaker(Faker faker) {
		Setup.faker = faker;
	}

	public static JavascriptExecutor getJsExecutor() {
		return jsExecutor;
	}

	public static void setJsExecutor(JavascriptExecutor jsExecutor) {
		Setup.jsExecutor = jsExecutor;
	}

	@Before
	public void InitSetup() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> timeouts = new HashMap<>();
		timeouts.put("implicit", 50);
		timeouts.put("pageLoad", 5000000);
		timeouts.put("script", 300000);
		options.setCapability("timeouts", timeouts);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//TODO: Explain Accessors methods
		setWaitTime(2500);
		setDriverWait(new WebDriverWait(getDriver(), getWaitTime()));
		initObject();
	}

	private static void initObject() {
		waitingObject = new WaitingObject(driver);
		actions = new Actions(driver);
		setJsExecutor((JavascriptExecutor) driver);
		setFaker(new Faker());
		loadDefaultProperties();
	}

	public static WebDriverWait getDriverWait() {
		return driverWait;
	}

	public static void setDriverWait(WebDriverWait driverWait) {
		Setup.driverWait = driverWait;
	}

	public static int getWaitTime() {
		return waitTime;
	}

	public static void setWaitTime(int waitTime) {
		Setup.waitTime = waitTime;
	}

	public static Object executeScript(String script,Object... arg) {
		return getJsExecutor().executeScript(script,arg);
	}

	public static Actions getActions() {
		return actions;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 *
	 * @param key Key index for value retrieve
	 * @return Returns Object
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
	 * @param key Key index for value retrieve
	 * @param value Value to store
	 */
	public static void setKeyValueStore(String key, Object value) {
		store.put(key, value);
	}

	/**
	 * Open new url
	 * 
	 * @param url Url to open using driver
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
		InputStream input = Setup.class.getResourceAsStream("/defaultProperties.properties");
		Properties pop = new Properties();
		try {
			pop.load(input);
		} catch (java.io.IOException ignored) { }

		//TODO: Explain random loads
		setKeyValueStore("defaultProperties", pop);
		int number = (int) (Math.random() * 4 + 1);
		String avatar_name = "/avatar(" + number + ").png";
		setKeyValueStore("avatar", new File(Setup.class.getResource(avatar_name).getFile())
				.getAbsolutePath());
		setKeyValueStore("huge_avatar", new File(Setup.class.getResource("/huge_image.png").getFile())
				.getAbsolutePath());
		setKeyValueStore("gif_avatar", new File(Setup.class.getResource("/avatar.gif").getFile())
				.getAbsolutePath());
	}
}
