import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
import org.junit.jupiter.api.Test;
 
class DummyCalculatorTest {
 
    @Test
    void givenDummyCalculator_WhenAddingPositiveNumbers_ThenSumIsCorrect() {
        // given
        DummyCalculator dummyCalculator = new DummyCalculator();
 
        // when
        int first = 10;
        int second = 20;
        int result = dummyCalculator.add(first, second);
 
        // then
        int expectedResult = 30;
        assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
 
    @Test
    void givenDummyCalculator_WhenAddingNegativeNumbers_ThenSumIsCorrect() {
        // given
        DummyCalculator dummyCalculator = new DummyCalculator();
 
        // when
        int first = -100;
        int second = -1000000;
        int result = dummyCalculator.add(first, second);
 
        // then
        int expectedResult = -1_000_100;
        assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
 
    @Test
    void givenDummyCalculator_WhenAddingTooLargePositiveNumbers_ThenSumIsCorrect() {
        // given
        DummyCalculator dummyCalculator = new DummyCalculator();
 
        // when
        int first = 2_000_000_000;
        int second = 2_000_000_000;
        int result = dummyCalculator.add(first, second);
 
        // then
        assertTrue(result > 0, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenAddingPositiveNumberToNegative_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -500;
    	int second = 501;
    	int result = dummyCalculator.add(first, second);
    	
    	// then
    	int expectedResult = 1;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenAddingNegativeNumberToPositive_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 501;
    	int second = -500;
    	int result = dummyCalculator.add(first, second);
    	
    	// then
    	int expectedResult = 1;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenSubtractingNegativeNumbers_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -600;
    	int second = -600;
    	int result = dummyCalculator.subtract(first, second);
    	
    	// then
    	int expectedResult = 0;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenSubtractingTooLargeNumber_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -2_000_000_000;
    	int second = 2_000_000_000;
    	int result = dummyCalculator.subtract(first, second);
    	
    	// then
    	assertTrue(result < 0, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenSubtractingPositiveNumbers_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 600;
    	int second = 100;
    	int result = dummyCalculator.subtract(first, second);
    	
    	// then
    	int expectedResult = 500;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenSubtractingZeroFromNegativeNumber_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -600;
    	int second = 0;
    	int result = dummyCalculator.subtract(first, second);
    	
    	// then
    	int expectedResult = -600;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenSubtractingZeroFromPositiveNumber_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 600;
    	int second = 0;
    	int result = dummyCalculator.subtract(first, second);
    	
    	// then
    	int expectedResult = 600;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenMultiplyingPositiveNumbers_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 900;
    	int second = 49;
    	int result = dummyCalculator.multiply(first, second);
    	
    	// then
    	int expectedResult = 44_100;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenMultiplyingNegativeNumbers_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -15;
    	int second = -10;
    	int result = dummyCalculator.multiply(first, second);
    	
    	// then
    	int expectedResult = 150;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenMultiplyingPositiveNumberWithZero_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 128;
    	int second = 0;
    	int result = dummyCalculator.multiply(first, second);
    	
    	// then
    	int expectedResult = 0;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenMultiplyingPositiveNumberWithOne_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 195_348;
    	int second = 1;
    	int result = dummyCalculator.multiply(first, second);
    	
    	// then
    	int expectedResult = 195_348;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenMultiplyingPositiveNumberWithTheSameNumber_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 261;
    	int second = 261;
    	int result = dummyCalculator.multiply(first, second);
    	
    	// then
    	assertTrue(result > 261, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenDividingNegativeNumberWithPositive_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -1120;
    	int second = 7;
    	int result = dummyCalculator.divide(first, second);
    	
    	// then
    	int expectedResult = -160;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenDividingNegativeNumbers_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = -56454;
    	int second = -97;
    	int result = dummyCalculator.divide(first, second);
    	
    	// then
    	int expectedResult = 582;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenDividingPositiveNumberWithOne_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 1_167_951;
    	int second = 1;
    	int result = dummyCalculator.divide(first, second);
    	
    	// then
    	int expectedResult = 1_167_951;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenDividingPositiveNumberWithZero_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 1_167_951;
    	int second = 0;
    	int result = dummyCalculator.divide(first, second);
    	
    	// then
    	int expectedResult = 1_167_951;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
    
    @Test
    void givenDummyCalculator_WhenDividingZeroWithPositiveNumber_ThenSumIsCorrect() {
    	// given
    	DummyCalculator dummyCalculator = new DummyCalculator();
    	
    	// when
    	int first = 0;
    	int second = 2_000_000_000;
    	int result = dummyCalculator.divide(first, second);
    	
    	// then
    	int expectedResult = 0;
    	assertEquals(expectedResult, result, "Az összeadás eredménye rossz.");
    }
 
}