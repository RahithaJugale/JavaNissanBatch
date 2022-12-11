package com.nissan.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nissan.service.ICoach;

public class DemoSpringApp {

	public static void main(String[] args) {
		
		//hardcoded
		/*
		ICoach trackball = new TrackBall();
		System.out.println(trackball.getDailyWorkOut());
		
		ICoach baseball = new BaseBall();
		System.out.println(baseball.getDailyWorkOut());
		*/
		
		//Spring IOC container with configuration file
		//Read spring configuration file
		//point to the xml file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from Spring IOC container
		
		ICoach theCoach = context.getBean("trackBall", ICoach.class);
		System.out.println(theCoach.getDailyWorkOut());
		
		System.out.println();
		ICoach theCoach1 = context.getBean("baseBall", ICoach.class);
		System.out.println(theCoach1.getDailyWorkOut());
		
	}

}
