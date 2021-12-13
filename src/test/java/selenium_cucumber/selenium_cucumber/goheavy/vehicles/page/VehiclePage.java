package selenium_cucumber.selenium_cucumber.goheavy.vehicles.page;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium_cucumber.selenium_cucumber.general.PageObject;
import selenium_cucumber.selenium_cucumber.general.Setup;

@SuppressWarnings("unused")
public class VehiclePage extends PageObject {
	private String vehiclesLiXpath;
	private String addVehicleButtonXpath;
	private String addVehicleTitleXpath;
	private String carIconXpath;
	private String stepBaseXpath;
	private String VINImageUploadItemXpath;
	private String VINInputXpath;
	private String vehicleTypeXpath;
	private String vehicleMakeXpath;
	private String vehicleYearMakepath;
	private String vehicleCapacitySubSectionXpath;
	private String formScroll = "//*[@id='step-one-form']/ancestor::div["
			+ "@class='templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj']";
	private String stepTwoFormScroll;
	private String stepThreeFormScroll = "//*[@id='step-three-form']/ancestor::div["
			+ "@class='templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj']";
	private String vehiclePayloadXpath;
	private String vehiclePhotoImageXpath;
	private String vehicleInsuranceImageXpath = "//label[@class='ant-form-item-required' and "
			+ "@title='Current Insurance Certificate Picture']/ancestor::div[@class='ant-row ant-form-item']/descendant::input"
			+ "[@type='file']";

	public VehiclePage() {
		super();
		setVehiclesLiXpath("//span[text()='Vehicles']/ancestor::li[contains(@class, 'ant-menu-item')]");
		setAddVehicleButtonXpath("//span[text()='Add Vehicle']/ancestor::button[@type='button' and "
				+ "@class='ant-btn ant-btn-primary']");
		setAddVehicleTitleXpath("//span[@role='img'and @aria-label='car' and "
				+ "@class='anticon anticon-car']/ancestor::div[contains(@class, "
				+ "'ant-col')]/descendant::span[text()='Add Vehicle']");
		setCarIconXpath("//span[text()='Add Vehicle']/span[@role='img' and @class='anticon anticon-car']");
		setStepBaseXpath("//div[@class='ant-steps-item-container']");
		setVINImageUploadItemXpath("//label[@class='ant-form-item-required' and @title='VIN Image']/"
				+ "ancestor::div[@class='ant-row ant-form-item']/descendant::input[@type='file']");
		setVINInputXpath("//label[@title='Vehicle ID No. (VIN)' and text()='Vehicle ID No. (VIN)']/"
				+ "ancestor::div[@class='ant-row ant-form-item']/"
				+ "descendant::input[@placeholder='XXXXXXXXXXXXXXXXX' and @maxlength='17']");
		setVehicleTypeXpath("//input[@id='vehicleTypeId' and @role='combobox']");
		setVehicleMakeXpath("//input[@placeholder='Enter Vehicle make' and @id='make']");
		setVehicleYearMakepath("//input[@placeholder='Enter Vehicle year']/ancestor::div[@class='ant-picker-input']");
		setVehicleCapacitySubSectionXpath("//span[@class='ant-divider-inner-text' and text()='Vehicle Capacity']");
		setVehiclePayloadXpath("//input[@id='payload']");
		setVehiclePhotoImageXpath("//label[@class='ant-form-item-required' and "
				+ "@title='Vehicle Photo (from front driver side angle)']/ancestor::div[@class='ant-row ant-form-item']/"
				+ "descendant::input[@type='file']");
		setStepTwoFormScroll("//*[@id='step-two-form']/ancestor::div[@class='templateStyles__ContentDiv-sc-144t9h2-1 bcVeZj']");
		
		this.urlpath = "/vehicleinsurance";
	}

	private String getStepThreeFormScroll() {
		return stepThreeFormScroll;
	}

	private String getStepTwoFormScroll() {
		return stepTwoFormScroll;
	}

	private void setStepTwoFormScroll(String stepTwoFormScroll) {
		this.stepTwoFormScroll = stepTwoFormScroll;
	}

	private String getVehiclePhotoImageXpath() {
		return vehiclePhotoImageXpath;
	}

	private void setVehiclePhotoImageXpath(String vehiclePhotoImageXpath) {
		this.vehiclePhotoImageXpath = vehiclePhotoImageXpath;
	}

	private String getVehiclePayloadXpath() {
		return vehiclePayloadXpath;
	}

	private void setVehiclePayloadXpath(String vehiclePayloadXpath) {
		this.vehiclePayloadXpath = vehiclePayloadXpath;
	}

	private String getFormScroll() {
		return formScroll;
	}

	private void setFormScroll(String formScroll) {
		this.formScroll = formScroll;
	}

	private String getVehicleCapacitySubSectionXpath() {
		return vehicleCapacitySubSectionXpath;
	}

	private void setVehicleCapacitySubSectionXpath(String vehicleSubSectionXpath) {
		this.vehicleCapacitySubSectionXpath = vehicleSubSectionXpath;
	}

	private String getVehicleYearMakepath() {
		return vehicleYearMakepath;
	}

	private void setVehicleYearMakepath(String vehicleYearMakepath) {
		this.vehicleYearMakepath = vehicleYearMakepath;
	}

	private String getVehicleMakeXpath() {
		return vehicleMakeXpath;
	}

	private void setVehicleMakeXpath(String vehicleMakeXpath) {
		this.vehicleMakeXpath = vehicleMakeXpath;
	}

	private String getVehicleTypeXpath() {
		return vehicleTypeXpath;
	}

	private void setVehicleTypeXpath(String vehicleTypeXpath) {
		this.vehicleTypeXpath = vehicleTypeXpath;
	}

	private String getVINInputXpath() {
		return VINInputXpath;
	}

	private void setVINInputXpath(String vINInputXpath) {
		VINInputXpath = vINInputXpath;
	}

	private String getVINImageUploadItemXpath() {
		return VINImageUploadItemXpath;
	}

	private void setVINImageUploadItemXpath(String vINImageUploadItemXpath) {
		VINImageUploadItemXpath = vINImageUploadItemXpath;
	}

	private String getStepBaseXpath() {
		return stepBaseXpath;
	}

	private void setStepBaseXpath(String stepBaseXpath) {
		this.stepBaseXpath = stepBaseXpath;
	}

	private String getCarIconXpath() {
		return carIconXpath;
	}

	private void setCarIconXpath(String carIconXpath) {
		this.carIconXpath = carIconXpath;
	}

	private String getAddVehicleTitleXpath() {
		return addVehicleTitleXpath;
	}

	private void setAddVehicleTitleXpath(String addVehicleTitleXpath) {
		this.addVehicleTitleXpath = addVehicleTitleXpath;
	}

	private String getAddVehicleButtonXpath() {
		return addVehicleButtonXpath;
	}

	private void setAddVehicleButtonXpath(String addVehicleButtonXpath) {
		this.addVehicleButtonXpath = addVehicleButtonXpath;
	}

	private String getVehiclesLiXpath() {
		return vehiclesLiXpath;
	}

	private void setVehiclesLiXpath(String vehiclesLiXpath) {
		this.vehiclesLiXpath = vehiclesLiXpath;
	}
	
	public void clickOn(WebElement element) {	
		waitForSpinningElementDissapear();
		Setup.getWait().thread(150);
		Setup.getActions().moveToElement(element).build().perform();
		Setup.getActions().click(element).build().perform();
		waitForSpinningElementDissapear();
		Setup.getWait().thread(150);
	}

	public boolean goToVehiclesAndInsuranceListView() {
		try {
			waitForSpinningElementDissapear();
			Setup.getWait().thread(1500);
			WebElement element = getWebElement(By.xpath(getVehiclesLiXpath()));
			clickOn(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickOnAddVehicleButton() {
		try {
			waitForSpinningElementDissapear();
			Setup.getWait().thread(3000);
			WebElement element = getWebElement(By.xpath(getAddVehicleButtonXpath()));
			clickOn(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean systemOpensAddVehicleView() {
		Setup.getWait().thread(5000);
		waitForSpinningElementDissapear();
		
		try {
			Assert.assertNotNull("Page Title not found", getPageElementBy(By.xpath(getAddVehicleTitleXpath())));
			Assert.assertNotNull("Page Icon not Found", getPageElementBy(By.xpath(getCarIconXpath())));
			Assert.assertTrue("Step 1 not found", checkStep(getWebElement(By.xpath(getStepBaseXpath())), "1", "Vehicle Info"));
			Assert.assertNotNull("VIN Image Upload not found", getPageElementBy(By.xpath(getVINImageUploadItemXpath())));
			Assert.assertNotNull("VIN Input not found or do not match Expected Criteria", 
					getPageElementBy(By.xpath(getVINInputXpath())));
			Assert.assertNotNull("Vehicle Type Input not found or do not match Expected Criteria", 
					getPageElementBy(By.xpath(getVehicleTypeXpath())));
			checkVehicleTypeComponentBehaviour();
			Assert.assertNotNull("Vehicle Make Input not found or do not match Expected Criteria", 
					getPageElementBy(By.xpath(getVehicleMakeXpath())));
			Assert.assertNotNull("Vehicle Year Make Input not found or do not match Expected Criteria", 
					getPageElementBy(By.xpath(getVehicleYearMakepath())));
			Assert.assertNotNull("Vehicle Sub Section not found", 
					getPageElementBy(By.xpath(getVehicleCapacitySubSectionXpath())));
			//TODO: Work in progress check for every element on the page to be Expected
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	private void checkVehicleTypeComponentBehaviour() {
		waitForSpinningElementDissapear();
		try {
			Setup.getWait().thread(150);
			clickOn(getWebElement(By.xpath(getVehicleTypeXpath())));
			Setup.getWait().thread(150);
			Assert.assertNotNull("Vehicle types not found or none to show", getPageElementBy(By.xpath(
					"//div[@class='rc-virtual-list-holder-inner']")));
			WebElement vehicle_type_list = getPageElementBy(By.xpath("//div[@class='rc-virtual-list-holder-inner']"));
			List<WebElement> element_list = vehicle_type_list.findElements(By.xpath(
					"//div[@class='ant-select-item ant-select-item-option']"));
			int val = element_list.size();
			if (element_list.size() > 3)
				val = 0;
				
			int number = (int) (Math.random() * val + 1);
			hoverElement(null, element_list.get(number));
			clickOn(element_list.get(number));
			Setup.getWait().thread(150);
		} catch(Exception e) {}
	}

	public boolean checkStep(WebElement element, String step, String stepName) {
		waitForSpinningElementDissapear();
		String numberXpath = "//span[@class='ant-steps-icon' and text()='" + step + "']";
		String titleXpath = "//div[@class='ant-steps-item-title' and text()='" + stepName + "']";
		
		try {
			Assert.assertNotNull("Error on Step Number Retrieve", element.findElement(
					By.xpath(numberXpath)));
			Assert.assertNotNull("Error on Step Title Retrieve", element.findElement(
					By.xpath(titleXpath)));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public WebElement getPageElementBy(By by) {
		try {
			return getWebElement(By.xpath(getAddVehicleTitleXpath()));
		} catch (Exception e) {
			System.out.println("Expected Title Page element not found");
			return null;
		}
	}

	public boolean hoverOverImageComponent() {
		waitForSpinningElementDissapear();
		try {
			setImage(getWebElement(By.xpath(getVINImageUploadItemXpath())), null);
			Setup.getWait().thread(500);
			Setup.getActions().moveToElement(getWebElement(By.xpath("//div[contains(@class, 'kxeirt')]/descendant::img")))
			.build().perform();
			Setup.getWait().thread(500);
			
			Assert.assertTrue(hoverElement(By.xpath("//span[@role='img' and @class='anticon anticon-eye' and @cursor='pointer']")
					, null));
			clickOn(getWebElement(By.xpath("//span[@role='img' and @class='anticon anticon-eye' and @cursor='pointer']")));
			clickOn(getWebElement(By.xpath("//span[@class='anticon anticon-close ant-modal-close-icon' and @role='img']")));
			Assert.assertTrue(hoverElement(By.xpath("//span[@role='img' and @class='anticon anticon-check' and @cursor='pointer']")
					, null));
			clickOn(getWebElement(By.xpath("//span[@role='img' and @class='anticon anticon-check' and @cursor='pointer']")));
			Assert.assertTrue(hoverElement(By.xpath("//span[@role='img' and @class='anticon anticon-close' and @cursor='pointer']")
					, null));
			
			return true;
		} catch (Exception e) {
			System.out.println("Expected Image Over element not found");
			return false;
		}
	}
	
	public void clear_element_text(WebElement element) {
		int length = element.getAttribute("value").length();
		for (int i = 0;i <= length;i++) {
			Setup.getActions().sendKeys(element, Keys.BACK_SPACE).perform();
		}	
	}

	private boolean hoverElement(By by, WebElement element) {
		try {
			Setup.getWait().thread(500);
			if (element != null)
				Setup.getActions().moveToElement(element).build().perform();
			else
				Setup.getActions().moveToElement(getWebElement(by)).build().perform();
			Setup.getWait().thread(500);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void sendDataToInput(WebElement element, String data, Keys key, String form) {
		try {
			if (element.getAttribute("value").length() > 0)
				clear_element_text(element);
		} catch (Exception e) {}
		scrollToWebElement(element, form);
		if (data != null)
			Setup.getActions().sendKeys(element, data).build().perform();
		else
			Setup.getActions().sendKeys(element, key).build().perform();
	}

	public boolean userInsertsValisDataAndClicksDone() {
		try {
			sendDataToInput(getWebElement(By.xpath(getVINInputXpath())), getFaker().number().digits(17), null, getFormScroll());
			
			String vehicleMake = getFaker().superhero().name();
			Setup.setKeyValueStore("vehicleMake", vehicleMake);
			
			sendDataToInput(getWebElement(By.xpath(getVehicleMakeXpath())), (String) Setup.getValueStore("vehicleMake"), null, 
					getFormScroll());
			
			int min_val = 1995;
			int max_val = 2018;
			
			ThreadLocalRandom tlr = ThreadLocalRandom.current();
	        int randomNum = tlr.nextInt(min_val, max_val + 1);
			
			sendDataToInput(getWebElement(By.xpath(getVehicleYearMakepath())), String.valueOf(randomNum), null, getFormScroll());
			sendDataToInput(getWebElement(By.xpath(getVehicleYearMakepath())), null, Keys.RETURN, getFormScroll());
			
			fillDimensions();
			
			min_val = 90;
			max_val = 210;
			randomNum = tlr.nextInt(min_val, max_val + 1);
			
			sendDataToInput(getWebElement(By.xpath(getVehiclePayloadXpath())), String.valueOf(randomNum), null, getFormScroll());
			
			scrollToWebElement(null, getFormScroll());
			
			clickOn(getWebElement(By.xpath("//button[@type='submit']/descendant::span[text()='Next']")));
			waitForSpinningElementDissapear();
			Setup.getWait().thread(1500);
			//Step 2
	
			sendDataToInput(getWebElement(By.xpath("//input[@id='model' and @placeholder='Enter Vehicle model']")),
					getFaker().artist().name(), null, getStepTwoFormScroll());
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='color' and @placeholder='Enter Vehicle color']")),
					getFaker().color().name().toUpperCase(), null, getStepTwoFormScroll());
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='trim' and @placeholder='Enter Vehicle trim']")),
					getFaker().name().firstName(), null, getStepTwoFormScroll());
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='transmission' and @placeholder='Enter Vehicle transmission']")),
					getFaker().name().firstName(), null, getStepTwoFormScroll());
			
			if (min_val < 145)
				clickOn(getWebElement(By.xpath("//label[text()='Towing Kit Installed']/ancestor::div["
						+ "@class='ant-row ant-form-item']/descendant::button[@type='button' and @class='ant-switch']")));
			
			if (randomNum % 2 == 0)
				clickOn(getWebElement(By.xpath("//label[text()='Liftgate Installed']/ancestor::div["
						+ "@class='ant-row ant-form-item']/descendant::button[@type='button' and @class='ant-switch']")));
			
			setImage(getWebElement(By.xpath(getVehiclePhotoImageXpath())), null);
			
			scrollToWebElement(null, getStepTwoFormScroll());
			
			clickOn(getWebElement(By.xpath("//button[@type='submit']/descendant::span[text()='Next']")));
			waitForSpinningElementDissapear();
			Setup.getWait().thread(1500);
			//Step 3
			
			setImage(getWebElement(By.xpath(getVehicleInsuranceImageXpath())), null);
			
			clickOn(getWebElement(By.xpath("//input[@id='verificationDelivery']")));
			clickOn(getWebElement(By.xpath("//input[@id='verificationLicenseTime']")));
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='insurancePolicyNo' and "
					+ "@placeholder='Enter Insurance Policy Number']")),
					getFaker().number().digits(12), null, getStepThreeFormScroll());
					
			Setup.getWait().thread(500);
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='insuranceCertificateCompany' and "
					+ "@placeholder='Enter Company name']")),
					getFaker().name().firstName(), null, getStepThreeFormScroll());
			
			Setup.getWait().thread(500);
			
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, -2);
			Date past_date = calendar.getTime();
			DateFormat short_date = DateFormat.getDateInstance(DateFormat.SHORT);
			
			//From Date
			String by = "//input[@id='insuranceEffectiveDate' and "
					+ "@placeholder='Select Date']";
			Setup.getActions().moveToElement(getWebElement(By.xpath(by))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath(by))).build().perform();
			Setup.getActions().sendKeys(getWebElement(By.xpath(by)), short_date.format(getFaker().date().between(past_date, date)).toString())
					.build().perform();
			//Date here
			min_val = 1;
			max_val = 10;
			randomNum = tlr.nextInt(min_val, max_val + 1);
			
			manageDate(true, randomNum);
			
			//To Date
			calendar.add(Calendar.YEAR, 2);
			calendar.add(Calendar.DAY_OF_YEAR, 2);
			Date future_date = calendar.getTime();
			
			try {
				by = "//input[@id='insuranceExpirationDate' and "
						+ "@placeholder='Select Date']";
				Setup.getActions().moveToElement(getWebElement(By.xpath(by))).build().perform();
				Setup.getActions().click(getWebElement(By.xpath(by))).build().perform();
				Setup.getActions().sendKeys(getWebElement(By.xpath(by)), short_date.format(future_date).toString())
						.build().perform();
				manageDate(false, randomNum);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			Setup.getWait().thread(500);
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='insuranceRenewal' and "
					+ "@placeholder='Enter Insurance Renewal']")),
					getFaker().name().firstName(), null, getStepThreeFormScroll());
		
			Setup.getWait().thread(500);
			
			sendDataToInput(getWebElement(By.xpath("//input[@id='licensePlateNo' and "
					+ "@placeholder='Enter Vehicle License Plate Number']")),
					getFaker().number().digits(6), null, getStepThreeFormScroll());
			
			Setup.getWait().thread(500);
			
			managePlateState();
			
			scrollToWebElement(null, getStepThreeFormScroll());
			
			Setup.getWait().thread(500);
			
			setImage(getWebElement(By.xpath("//label[@title='License Plate Photo']/ancestor::div[contains(@class, "
					+ "'ant-form-item')]/descendant::input[@type='file']")), null);
			
			Setup.getWait().thread(500);
			
			setImage(getWebElement(By.xpath("//label[@title='Vehicle Registration Sticker']/ancestor::div[contains(@class, "
					+ "'ant-form-item')]/descendant::input[@type='file']")), null);
			
			Setup.getWait().thread(500);
			
			clickOn(getWebElement(By.xpath("//button[@type='submit']")));
			
			waitForSpinningElementDissapear();
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	private void managePlateState() {
		String xpath = "//input[@id='licensePlateStateIssuedId']/ancestor::div[@class='ant-form-item-control-input']";
		
		sendDataToInput(getWebElement(By.xpath(xpath)), 
				null, Keys.SPACE, getStepThreeFormScroll());
		
		List<WebElement> states = getWebElements(By.xpath("//div[@class='ant-select-item ant-select-item-option']"));
		
		int val = states.size();

		try {
			int number = (int) (Math.random() * val + 1);
			if (number == 0)
				number = 2;
			
			clickOn(states.get(number - 1));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void manageDate(boolean back, int random_num) {
		String xpath = "//button[@class='ant-picker-header-prev-btn']";
		Setup.getWait().thread(500);
		if (!back) {
			//TODO: Get this improved
			xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[1]/button[3]";
			Setup.getActions().moveToElement(getWebElement(By.xpath(xpath))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath(xpath))).build().perform();
			xpath = "/html/body/div[3]/div/div/div/div/div[1]/div[2]/table/tbody/tr[5]/td[6]/div";
			Setup.getActions().moveToElement(getWebElement(By.xpath(xpath))).build().perform();
			Setup.getActions().click(getWebElement(By.xpath(xpath))).build().perform();
			return;
		} else {
			try {
				for (int i = 0;i < random_num;i++) {
					Setup.getActions().click(getWebElement(By.xpath(xpath)))
						.build().perform();
				}
				String xpath_day = "//div[@class='ant-picker-cell-inner' and text()='" + random_num + "']";
				Setup.getActions().click(getWebElement(By.xpath(xpath_day))).build().perform();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void fillDimensions() {
		int min_val = 22;
		int max_val = 45;
		
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
        int randomNum = tlr.nextInt(min_val, max_val + 1);
        
        sendDataToInput(getWebElement(By.xpath("//input[@id='long']")), String.valueOf(randomNum), null, getFormScroll());
        randomNum = tlr.nextInt(min_val, max_val + 1);
        sendDataToInput(getWebElement(By.xpath("//input[@id='width']")), String.valueOf(randomNum), null, getFormScroll());
        randomNum = tlr.nextInt(min_val, max_val + 1);
        sendDataToInput(getWebElement(By.xpath("//input[@id='height']")), String.valueOf(randomNum), null, getFormScroll());
	}

	private void scrollToWebElement(WebElement element, String form) {
		Setup.getWait().thread(500);
		int y_pos = Integer.valueOf(Setup.timeouts.get("script").toString());
		if (element != null)
			y_pos = element.getLocation().y;

		String script = "arguments[0].scrollTo(0, " + y_pos + ");";
		Setup.getJsExecutor().executeScript(script, getWebElement(By.xpath(form)));
		Setup.getWait().thread(500);
	}

	private String getVehicleInsuranceImageXpath() {
		return vehicleInsuranceImageXpath;
	}

	public WebElement systemCreatesVehicleOnStatus(String status) {
		try {
			waitForSpinningElementDissapear();
			Setup.getActions().sendKeys(getWebElement(By.xpath(""
					+ "//input[@placeholder='Search...' and @type='text' and @class='ant-input']")), 
					(String) Setup.getValueStore("vehicleMake")).build().perform();
			
			Setup.getWait().thread(250);
			
			Setup.getActions().click(getWebElement(By.xpath(""
					+ "//button[@class='ant-btn ant-btn-icon-only ant-input-search-button']"))).build().perform();
			
			Setup.getWait().thread(250);
			
			String status_xpath = "//span[@class='ant-tag ant-tag-blue' and text()='" + status + "']";
			return getWebElement(By.xpath(status_xpath));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public WebElement systemsRegistersCreationDate() {
		waitForSpinningElementDissapear();
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String date_compare = dtf.format(LocalDateTime.now());
			String date_xpath = "//td[@class='ant-table-cell' and contains(text(), '" + date_compare + "')]";
			return getWebElement(By.xpath(date_xpath));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean returnsToViewAndDisplaysMessage(String message) {
		waitForSpinningElementDissapear();
		try {
			String xpath = "//div[@class='ant-notification ant-notification-topRight']";
			WebElement alert = getWebElement(By.xpath(xpath));
			return alert.getText().equals(message);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean systemDisplaysAssignView() {
		Setup.getWait().thread(3000);
		waitForSpinningElementDissapear();
		try {
			String xpath = "//div[text()='Assign Vehicle' and @class='ant-modal-title']";
			WebElement alert = getWebElement(By.xpath(xpath));
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean userAssignsTheVehicle() {
		Setup.getWait().thread(3000);
		waitForSpinningElementDissapear();
		try {
			Setup.getActions().moveToElement(getWebElement(By.xpath("//input[@placeholder='Please, select a option']"))).
			build().perform();
			Setup.getWait().thread(500);
			Setup.getActions().click(getWebElement(By.xpath("//input[@placeholder='Please, select a option']"))).
			build().perform();
			Setup.getWait().thread(1000);
			Setup.getActions().moveToElement(getWebElement(By.xpath("//div[@class='ant-select-item-option-content']"))).
			build().perform();
			Setup.getWait().thread(500);
			Setup.getActions().click(getWebElement(By.xpath("//div[@class='ant-select-item-option-content']"))).
			build().perform();
			Setup.getWait().thread(500);
			Setup.getActions().click(getWebElement(By.xpath("//button[@class='ant-btn ant-btn-primary' and @type='button']/"
					+ "descendant::span[text()='Assign']"))).build().perform();
			Setup.getWait().thread(1000);
			System.exit(0);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
