package com.nissan.bean;

import org.springframework.stereotype.Component;

import com.nissan.service.ICoach;

@Component
public class TrackBall implements ICoach{

	/*
	public void display() {
		System.out.println("Performance report");
	}
	*/
	
	FortuneLibrary fortuneLibrary;
	
	TrackBall(FortuneLibrary fortuneLibrary){
		this.fortuneLibrary = fortuneLibrary;
	}

	@Override
	public String getDailyWorkOut() {
		System.out.println("Trackball: Run a hard 15 km");
		System.out.println("Your fortune for the day is:");
		return fortuneLibrary.getFortune();
	}
}
