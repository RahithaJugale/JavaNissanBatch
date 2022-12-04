package com.faith.app;

/*
 * Next derive a class from Animals called Cat. Implement the Saysomething() method in the
derived class. The Saysomething() method should print the following message on the
user’s.“Cats Say Meoow” Derive another class called Dog from the Animals abstract base
class. This time the SaySomething() method should print the following message on the
user’s. “Dogs Say Bow Wow”
 */

import com.faith.bean.Abstraction2Cat;
import com.faith.bean.Abstraction2Dog;

public class Abstraction2 {

	public static void main(String[] args) {
		
		//creating object for Cat class
		Abstraction2Cat cat = new Abstraction2Cat();
		cat.saySomething();
		//creating object for Dog class
		Abstraction2Dog dog = new Abstraction2Dog();
		dog.saySomething();
		
	}

}
