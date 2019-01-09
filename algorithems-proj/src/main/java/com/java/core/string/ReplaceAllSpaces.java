package com.java.core.string;

public class ReplaceAllSpaces {

	void replace(String s1,int len){
		char[] ch = s1.toCharArray();
	    int scount = 1;
	    for(int i= 0;i<ch.length;i++){
	    	if(ch[i]==' ')
	    		scount+=1;
	    }
	    int newlen=len+2*scount;
	    char[] c = new char[newlen];
	    for(int i=ch.length-1;i>=0;i--){
	    	if(ch[i]==' '){
	    		c[newlen-1]='0';
	    		c[newlen-2]='2';
	    		c[newlen-3]='%';
	    		newlen=newlen-3;
	    	}
	    	else{
	    		c[newlen-1]=ch[i];
	    		newlen=newlen-1;
	    	}
	    }
	    System.out.println(String.valueOf(c));
	}
	
	public static void main(String[] args) {
		String s1 = "I am Sumit Jain";
		int trueLength = s1.length();
		System.out.println("Input String : " + s1);
		ReplaceAllSpaces r = new ReplaceAllSpaces();
		r.replace(s1, trueLength);
	}
}
