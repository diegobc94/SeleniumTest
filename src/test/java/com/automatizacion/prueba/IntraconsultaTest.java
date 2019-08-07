package com.automatizacion.prueba;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntraconsultaTest {
	
	private WebDriver driver;
	private static final String EXPECTED_TEXT = "inicio3";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		//ChromeOptions opt = new ChromeOptions();
		//opt.setExperimentalOption("w3c",true);
		//driver = new ChromeDriver(opt);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("alumno2.unlam.edu.ar");
	}
	
	@Test
	public void logeoTest() throws InterruptedException {
		WebElement userBox = driver.findElement(By.id("usuario"));
		WebElement passwordBox = driver.findElement(By.id("clave"));
		userBox.clear();
		passwordBox.clear();
		userBox.sendKeys("ACA VA UN USUARIO VALIDO");
		passwordBox.sendKeys("ACA VA UN PASSWORD VALIDO");
		passwordBox.submit();
		assertTrue(driver.findElement(By.id("inicio3")).getText().indexOf(EXPECTED_TEXT)!=-1);
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
