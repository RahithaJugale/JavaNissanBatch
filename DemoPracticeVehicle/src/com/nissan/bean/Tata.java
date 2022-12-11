package com.nissan.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nissan.service.Vehicle;

@Component
public class Tata implements Vehicle{

	List<String> vehicleNames = new ArrayList<String>();
	String brandName = "TATA";
	
	Tata(){
		vehicleNames.add("Altroz");
		vehicleNames.add("Safari");
		vehicleNames.add("Tigor");
	}
	
	@Override
	public void getVehicleName() {
		int i = 1;
		for(String vehicleName: vehicleNames) {
			System.out.println((i++) +". " + vehicleName);
		}
		
	}

	@Override
	public String getBrandName() {
		return this.brandName;
		
	}

}
