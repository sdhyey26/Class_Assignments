package com.tss.factory.TransportApp.model;

public class VehicleFactory {
	public static LicenceGenerator getVehicle(VehicleType type) {
		
		if(type == VehicleType.Two_wheeler) {
			return new TwoWheeler();
		}
		else if(type == VehicleType.Four_wheeler) {
			return new FourWheeler();
		}
		else if(type == VehicleType.Heavy_vehicle) {
			return new HeavyVehicle();
		}
		else {
			return null;
		}
	}
}
