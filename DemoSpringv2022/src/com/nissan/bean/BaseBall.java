package com.nissan.bean;

import org.springframework.stereotype.Component;

import com.nissan.service.ICoach;

@Component
public class BaseBall implements ICoach {

	FortuneLibrary fortuneLibrary;

	BaseBall(FortuneLibrary fortuneLibrary) {
		this.fortuneLibrary = fortuneLibrary;
	}

	@Override
	public String getDailyWorkOut() {
		System.out.println("Baseball: Spend 40 minutes in batting");
		System.out.println("Your fortune for the day is:");
		return fortuneLibrary.getFortune();
	}

}
