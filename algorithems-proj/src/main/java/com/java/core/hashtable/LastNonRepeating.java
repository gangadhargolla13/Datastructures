package com.java.core.hashtable;

import java.util.HashMap;

public class LastNonRepeating {

	public static Character getCharacter(String input){
        input = input.replaceAll(" ", "");
        Character rptChar = null;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i <input.length(); i++) {
            Character chr = input.charAt(i);
            if(map.containsKey(chr)){
                map.put(chr,map.get(chr)+1);
            }else{
                map.put(chr, 1);
            }
        }
        for (int i = input.length()-1; i >=0 ; i--) {
            if(map.get(input.charAt(i))>1){
                rptChar = input.charAt(i);
                break;
            }
        }
        return rptChar;
    }
	
	public static void main(String[] args) {
        String input = "tutorial horizon";
        Character result = getCharacter(input);
        if(result!=null){
            System.out.println("Last Repeating Character in '"+input+"' is: " + result);
        }else{
            System.out.println("No Repeating Character found");
        }
    }
}
