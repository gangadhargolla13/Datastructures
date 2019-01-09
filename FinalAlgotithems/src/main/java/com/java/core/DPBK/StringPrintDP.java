package com.java.core.DPBK;

import java.util.HashMap;

public class StringPrintDP {
	HashMap<String,Integer> map = new HashMap<String, Integer>();
    public int print(String input) {
    	int operations = input.length();
    	if (input == null || input.length() == 0)
            return 0;
    	int size = input.length();
        if (size == 1)
            return 1;
        if(map.containsKey(input)){
          return map.get(input);
      }
        int start_index = 0;
        int end_index = 0;
        while (start_index < size) {
            char c = input.charAt(start_index);
            while (end_index < size && c == input.charAt(end_index)) {
                end_index++;
            }
            if (end_index >= size) {
                operations = Math.min(operations, print(input.substring(0, start_index)) + 1);
            } else {
                operations = Math.min(operations, print(input.substring(0, start_index) + input.substring(end_index, size)) + 1);
            }
            start_index = end_index;
        }
        map.put(input,operations);
        return operations;
    }
    
    public static void main(String[] args) {
        StringPrintDP s = new StringPrintDP();
        String input = "aaxyzxyzaaaaaaaaaaaaa";
        long startTime  = System.currentTimeMillis();
        System.out.println("Minimum Operations: " + s.print(input));
        long end  = System.currentTimeMillis();
        System.out.println("Dynamic Programming - Time taken: " + (end-startTime)/1000 + " seconds");
    }
}
