import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javafx.scene.layout.GridPane;

class MyTest {

	static JavaFXTemplate keno;
	static int iter;

	@BeforeAll
	static void init() {
		keno = new JavaFXTemplate();
		iter = -1;
	}

	@ParameterizedTest
	@ValueSource(ints = {0,0,1,11,27,75,420,1100,4500,10000,30000,100000})
	void scoreTest(int score) {
		
		int scoreReturned = keno.ScoreCal(iter);
		iter++; 
		assertEquals(score, scoreReturned, "score returned is not the same as expected");
	}
	
	@Test
	void randomNumberTest() {
		
		int returnVal = keno.GetRandomNumber();
		
		assertTrue(returnVal >= 1 && returnVal <= 80);
	}
	
	@Test
	void randomNumber2Test() {
		
		int returnVal = keno.GetRandomNumber();
		
		assertFalse(returnVal <= 1 && returnVal >= 80);
	}

	
}
