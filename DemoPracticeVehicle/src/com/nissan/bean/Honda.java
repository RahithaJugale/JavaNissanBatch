package com.nissan.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nissan.service.Vehicle;

@Component
public class Honda implements Vehicle{
	
	List<String> vehicleNames = new ArrayList<String>();
	String brandName = "HONDA";
	
	Honda(){
		vehicleNames.add("City");
		vehicleNames.add("Brio");
		vehicleNames.add("Jazz");
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
