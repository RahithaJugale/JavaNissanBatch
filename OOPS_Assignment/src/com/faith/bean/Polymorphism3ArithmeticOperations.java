package com.faith.bean;

public class Polymorphism3ArithmeticOperations {

	//5 methods that gets float inputs and return int output
	public static int add(float number1, float number2) {
		return (int)(number1 + number2);
	}
	public static int subtract(float number1, float number2) {
		return (int)(number1 - number2);
	}
	public static int multiply(float number1, float number2) {
		return (int)(number1 * number2);
	}
	public static int divide(float number1, float number2) {
		return (int)(number1 / number2);
	}
	public static int mod(float number1, float number2) {
		return (int)(number1 % number2);
	}
	
	//5 methods that gets int inputs and return float output
	public static float add(int number1, int number2) {
		return (float)number1 + (float)number2;
	}
	public static float subtract(int number1, int number2) {
		return (float)number1 - (float)number2;
	}
	public static float multiply(int number1, int number2) {
		return (float)number1 * (float)number2;
	}
	public static float divide(int number1, int number2) {
		return (float)number1 / (float)number2;
	}
	public static float mod(int number1, int number2) {
		return (float)number1 % (float)number2;
	}
}
