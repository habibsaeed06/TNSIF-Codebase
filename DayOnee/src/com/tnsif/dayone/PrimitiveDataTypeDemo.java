package com.tnsif.dayone;

public class PrimitiveDataTypeDemo {
	public static void main(String[] args) {
		
		//byte takes 1 byte
		//1 byte = 8 bits   // 2^8
		//256/2
		//128
		
		byte byteMax=127;
		byte byteMin=-128;
		System.out.println("Min range of byte is : "+ byteMin +" Max range of byte is :"+ byteMax);
		
		
		//short --- 2 byte  2^16
		short shortMax=32767;
		short shortMin=-32768;
		System.out.println("Min range of Short is : "+ shortMin +" Max range of Short is :"+ shortMax);
		
		
		//int --- 4 byte  2^32
		int intMax=2147483647;
		int intMin=-2147483648;
		System.out.println("Min range of INT is : "+ intMin +" Max range of INT is :"+ intMax);
		
		
		//long --- 8 byte 2^64
		long maxLong=9223372036854775807L;
		long minLong=-9223372036854775808L;
		System.out.println("Min range of Long is : "+ minLong +" Max range of Long is :"+ maxLong);
		
		
		float f=3234.141243278345f;
		double d=3456.14124512345678902345678914f;
		
		boolean flag=false;
		boolean flag2=true;
	
		

	}

}
