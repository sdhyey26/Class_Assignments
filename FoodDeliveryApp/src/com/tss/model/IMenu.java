package com.tss.model;

import java.io.Serializable;
import java.util.ArrayList;

public interface IMenu extends Serializable {
	public ArrayList<?> getMenu();
	public String toString();
}
