package com.nissan.bean;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.nissan.service.IFortune;

@Component
public class FortuneLibrary implements IFortune{

	@Override
	public String getFortune() {
		String[] myFortunes = new String[] {"You will meet your soulmate soon", "Something great is about to happen", "You will excel in your job"};
		Random random = new Random();
		return myFortunes[random.nextInt(3)];
	}

	
}
