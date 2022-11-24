package io.justinthelaw.portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.justinthelaw.portfolio.controllers.CheckController;

@SpringBootTest
class PortfolioApplicationTests {

	@Test
	public void checkKnownWebsite() {
		CheckController check = new CheckController();
		String result = check.checkURL("https://github.com/justinthelaw");
		assertEquals(result, "UP!");
	}
	@Test
	public void checkUnknownWebsite() {
		CheckController check = new CheckController();
		String result = check.checkURL("https://github.com/justinthelaw/not-a-site");
		assertEquals(result, "DOWN!");
	}
	@Test
	public void checkNonExistentWebsite() {
		CheckController check = new CheckController();
		String result = check.checkURL("");
		assertEquals(result, "DOES NOT EXIST!");
	}

}
