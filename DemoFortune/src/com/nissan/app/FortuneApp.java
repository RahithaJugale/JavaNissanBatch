package com.nissan.app;

/*
 * 1. Define a new implementation for the FortuneService.
 a. When the getFortune() method is called it should return a random
fortune from the array.
 b. Your fortune service should define three fortunes in an array.
2. Inject your new dependency into your Coach implementation.
3. Test your application to verify you are retrieving random fortunes.
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nissan.service.IFortune;

public class FortuneApp {

	public static void main(String[] args) {
		
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			IFortune fortune = context.getBean("fortuneLibrary", IFortune.class);
			System.out.println("Your fortune for the day is:");
			System.out.println(fortune.getFortune());
		}catch(Exception e) {
			System.out.println("Some exception");
		}

	}

}
