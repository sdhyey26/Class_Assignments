package com.tss.Furniture.model;

public class TableFactory implements IFurnitureFactory{

	@Override
	public IStyle furniture(FurnitureStyle type) {
		if(type == FurnitureStyle.Modern) {
			return new ModernTable();
		}
		else if(type == FurnitureStyle.Victorian) {
			return new VictorianTable();
		}
		else {
			return null;
		}
	}

}
