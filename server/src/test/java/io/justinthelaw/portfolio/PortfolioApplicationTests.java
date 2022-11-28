package io.justinthelaw.portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.justinthelaw.portfolio.controllers.CheckController;
import io.justinthelaw.portfolio.controllers.CheckResponse;

@SpringBootTest
class PortfolioApplicationTests {

	@Test
	public void checkKnownWebsite() {
		CheckController check = new CheckController();
		CheckResponse result = check.checkURL("https://github.com/justinthelaw");
		assertEquals(result.getResult(), "UP!");
		assertEquals(result.getCode(), 200);
	}
	@Test
	public void checkUnknownWebsite() {
		CheckController check = new CheckController();
		CheckResponse result = check.checkURL("https://github.com/justinthelaw/not-a-site");
		assertEquals(result.getResult(), "DOWN!");
		assertEquals(result.getCode(), 404);
	}
	@Test
	public void checkNonExistentWebsite() {
		CheckController check = new CheckController();
		CheckResponse result = check.checkURL("");
		assertEquals(result.getResult(), "DOES NOT EXIST!");
		assertEquals(result.getCode(), 404);
	}

}
