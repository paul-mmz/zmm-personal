package com.paul.enumeration;

public enum Week {

	MONDAY {
		public String toString(){
			return "Monday";
		}
	},
	
	TUESDAY{
		public String toString(){
			return "Tuesday";
		}
	},
	
	WEDNESDAY;
	
	public static void main(String[] args) {
		System.out.println(Week.MONDAY);
		System.out.println(Week.TUESDAY);
		System.out.println(WEDNESDAY);
	}
	
}
