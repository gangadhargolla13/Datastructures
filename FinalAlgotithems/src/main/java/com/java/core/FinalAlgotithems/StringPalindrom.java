package com.java.core.FinalAlgotithems;

public class StringPalindrom {

	//By Using recurtion
	
	public boolean isPalindrome(String strx)
	{
		if(strx.length()<2)
			return true;
		if(strx.charAt(0)==strx.charAt(strx.length()-1))
			return isPalindrome(strx.substring(1, strx.length()-1));
		else 
			return false;
	}
	
	public boolean isPalindrome(char[] ch)
	{
		int i1 =0;
		int i2 = ch.length-1;
		while(i2>i1)
		{
			if(ch[i1]!=ch[i2])
				return false;
			i1++;
			i2--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		StringPalindrom p = new StringPalindrom();
		boolean n = p.isPalindrome("SumuS".toCharArray());
		boolean n1 = p.isPalindrome("SumruS");
		System.out.println(n1);
	}
}
