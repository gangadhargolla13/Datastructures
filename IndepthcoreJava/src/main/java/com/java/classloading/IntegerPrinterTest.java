package com.java.classloading;

public class IntegerPrinterTest {

	public static void main(String[] args) throws Exception {
        CustomClassLoader1 loader = new CustomClassLoader1(
            StaticAccessorTest.class.getClassLoader());
        Class<?> clazz =
            loader.loadClass("com.java.classloading.IntegerPrinter");
        Object instance = clazz.newInstance();
        clazz.getMethod("runMe").invoke(instance);
    }
}
