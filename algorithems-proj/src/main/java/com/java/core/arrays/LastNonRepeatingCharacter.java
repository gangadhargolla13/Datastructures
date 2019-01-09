package com.java.core.arrays;

import java.util.HashMap;

public class LastNonRepeatingCharacter {
	public static Character getCharacter(String input){
        //remove all the spaces
        input = input.replaceAll(" ", "");
        Character nonRptChar = null;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <input.length(); i++) {
            Character chr = input.charAt(i);
            if(map.containsKey(chr)){
                map.put(chr,map.get(chr)+1);
            }else{
                map.put(chr, 1);
            }
        }
        for (int i = input.length()-1; i >=0; i--) {
            if(map.get(input.charAt(i))==1){
                nonRptChar = input.charAt(i);
                break;
            }
        }
        return nonRptChar;
    }
	public static void main(String[] args) {
        String input = "algorithms tutorial";
        Character result = getCharacter(input);
        if(result!=null){
            System.out.println("Last Non Repeating Character in '"+input+"' is: " + result);
        }else{
            System.out.println("No Repeating Character found");
        }
    }
}
