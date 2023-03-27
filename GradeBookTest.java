import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook gbook1;
	private GradeBook gbook2;
	private GradeBook gbook3;
	@BeforeEach
	void setUp() throws Exception {
		gbook1 = new GradeBook(5);
		gbook2 = new GradeBook(5);
		gbook3 = new GradeBook(5);
		
		gbook1.addScore(50);
		gbook1.addScore(75);
		gbook1.addScore(85);
		
		gbook2.addScore(60);
		gbook2.addScore(70);
		gbook2.addScore(80);
		gbook2.addScore(90);
		gbook2.addScore(95);
		
		gbook3.addScore(50);
		gbook3.addScore(55);
		gbook3.addScore(65);
	}

	@AfterEach
	void tearDown() throws Exception {
		gbook1 = null;
		gbook2 = null;
		gbook3 = null;
	}

	@Test
	void testAddScore() {
		assertEquals(true, gbook1.addScore(90));
		assertTrue(gbook1.toString().equals("50.0 75.0 85.0 90.0 "));
		assertTrue(gbook1.getScoreSize() == 4);
		assertFalse(gbook2.addScore(92));
		assertTrue(gbook2.getScoreSize() == 5);
	}

	@Test
	void testSum() {
		assertTrue(gbook3.sum() == 170.0);
		assertEquals(395, gbook2.sum(), 0.01);
		assertFalse(gbook1.sum() != 210.0);
	}

	@Test
	void testMinimum() {
		assertTrue(gbook1.minimum() == 50.0);
		assertFalse(gbook3.minimum() != 50.0);
		assertEquals(60.0, gbook2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(gbook1.finalScore(), 160.0, 0.001);
		assertTrue(gbook2.finalScore() == 335.0);
		assertFalse(gbook3.finalScore() != 120.0);
	}

}
