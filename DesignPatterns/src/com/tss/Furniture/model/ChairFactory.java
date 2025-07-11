package com.tss.Furniture.model;

public class ChairFactory implements IFurnitureFactory{

	@Override
	public IStyle furniture(FurnitureStyle type) {
		if(type == FurnitureStyle.Modern) {
			return new ModernChair();
		}
		else if(type == FurnitureStyle.Victorian) {
			return new VictorianChair();
		}
		else {
			return null;
		}
	}

}
