package com.tss.Furniture.model;

public class SofaFactory implements IFurnitureFactory{

	public IStyle furniture(FurnitureStyle type) {
		if(type == FurnitureStyle.Modern) {
			return new ModernSofa();
		}
		else if(type == FurnitureStyle.Victorian) {
			return new VictorianSofa();
		}
		else {
			return null;
		}
	}
}
