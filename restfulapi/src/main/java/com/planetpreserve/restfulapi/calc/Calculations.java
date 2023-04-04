package com.planetpreserve.restfulapi.calc;

import org.springframework.stereotype.Component;

@Component
public class Calculations {
	
	public int add(int n1, int n2) {
		return n1 + n2;
	}
	
	public int multiply(int n1, int n2) {
		return n1 * n2;
	}
	
	public int subtract(int n1, int n2) {
		return n1 - n2;
	}
	
	public int divide(int n1, int n2) {
		return n1 / n2;
	}
	
	public int calculateSum(int[] numbers) {
		int sum = 0;
		
		for(int number: numbers) {
			sum += number;
		}
		
		System.out.println(sum);
		
		return sum;
	}
	
}
