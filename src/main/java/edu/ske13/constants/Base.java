package edu.ske13.constants;

public enum Base {
	Decimal(10),
	Binary(2);
	
	private int base;
	
	Base(int i) {
		this.base = i;
	}
	
	public int getBase() {
		return base;
	}
	
	@Override
	public String toString() {
		return name();
	}
}