package com.java.newfeature;

import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("I am gangadhar");
		byte[] resourceIdInBytes = DatatypeConverter.parseHexBinary("8192100000016870");
		System.out.println(Arrays.toString("8192100000016870".getBytes()));
		System.out.println(Arrays.toString(resourceIdInBytes));
	}
}
