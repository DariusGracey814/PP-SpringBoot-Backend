package com.planetpreserve.restfulapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.planetpreserve.restfulapi.calc.Calculations;

class CalculationsTest {
	
	@Test
	void test() {
		// create instance of class
		Calculations calulation = new Calculations();
		
		// Create int array and pass to calculate sum method
		int[] numbers = {1, 2, 3, 4, 5};
		int result = calulation.calculateSum(numbers);
		
		// Check if result is equal to the expected result
		int expectedResult = 15;
		
		
		// Test add method
		int addResult = calulation.add(100, 1);
		int expectedAddResult = 101;
		
		
		// User assert to do the checking
		assertEquals(expectedResult, result);
		assertEquals(expectedAddResult, addResult);
		
	}

}
