package com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
	 String name = null;
	 Map<String,Set<String>> map = new HashMap<>();
	 public Library(String books) {
		 String[] ss = books.split("TITLE");
		 for(String s : ss)
		 {
			// System.out.println(s);System.out.println(s.split("\n")[0]);
			 String ti = s.split("\n")[0];
			 String[] str1 = s.split(" ");
			 for(String g : str1)
			 {
				 String m = g.replaceAll("[^a-zA-Z0-9]", "");
				if(map.containsKey(m)) 
				{
					map.get(m).add(ti);
				}else
				{
				   Set<String> nam = new HashSet<>();
				   nam.add(ti);
				   map.put(m, nam);
				}
			 }
		 }
	 }
	 
	 public List<String> search(String word) {
		 //System.out.println(map);
		return new ArrayList(map.get(word));
	 }
	 
	 public static void main(String[] args) {
	  Library lib = new Library(
	     "TITLE:1491:_New_Revelations_of_the_Americas_Before_Columbus\n"
	     + "AUTHOR: Charles C. Mann\n"
	     + "DESCRIPTION:The book presents recent research findings in different fields "
	     + "that suggest human populations in the Western Hemisphere—that is, the indigenous peoples of the "
	     + "Americas—were more numerous, had arrived earlier, were more sophisticated culturally, "
	     + "and controlled and shaped the natural landscape to a greater extent than scholars had previously thought\n"
	     + "TITLE:Abundance: The Future Is Better Than You Think\n"
	     + "AUTHOR:Peter Diamandis and Steven Kotler\n"
	     + "DESCRIPTION: he writers refer to the book's title as being a future where nine billion people have access to "
	     + "clean water, food, energy, health care, education, "
	     + "and everything else that is necessary for a first world standard of living, thanks to technological innovation\n"
	     + "TITLE:AP 42 Compilation of Air Pollutant Emission Factors\n"
	     + "AUTHOR: Pollution\n"
	     + "DESCRIPTION:The AP 42 Compilation of Air Pollutant Emission Factors, was first published by the US Public Health "
	     + "Service in 1968. In 1972, it was revised and issued as the second edition by the US Environmental Protection Agency (EPA). "
	     + "In 1985, the subsequent fourth edition was split into two volumes. Volume I includes stationary point and area source emission factors, and Volume II includes mobile source "
	     + "emission factors. Volume I is currently in its fifth edition and is available on the Internet.");
	  
	     // Reurn the list of titles for the given word
	      
	     System.out.println(lib.search("the"));
	 }

	}
