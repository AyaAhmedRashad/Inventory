package com.inventory.task.enums;

public enum PackageType {
	//this enum designed to determine the types of packaging for each product
	//as each product may be single or simple package or large package
	   single(0), // means the product is 1 piece 
	   simplePackage(1) , //means the product is a package of number of pieces
	   largePackage(2) ; //means the product is a package of the simple package
	    private int numVal;
	    PackageType(int numVal) {
	        this.numVal = numVal;
	    }
	    public int getNumVal() {
	        return numVal;
	    }
	    public static PackageType getEnum(int value){
	        for (PackageType e: PackageType.values()) {
	            if(e.getNumVal() == value)
	                return e;
	        }
	        return null;
	    }
}
