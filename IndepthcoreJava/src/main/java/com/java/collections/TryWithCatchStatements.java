package com.java.collections;

public class TryWithCatchStatements {

	public static void main(String[] args) {
		TryWithCatchStatements tt = new TryWithCatchStatements();
		String sss=tt.getString("narasimham");
		System.out.println(sss);
	}
	@SuppressWarnings("finally")
	public String getString(String name){
		String name1 =name;
		try{
			name1="Gangadhar";
			int[] nn={};
			
			return "jhksfdhsdfsd";
			//System.out.println(nn[2]);
		}catch(Exception e){
			System.out.println("ksjdfkl");
			return "mallik";
		}finally{
			//return  "gayathri";
		}
		//return name1;
	}
}
