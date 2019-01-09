package com.java.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<Player, String> map = new HashMap<>();
		Player p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		Player p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		Player p2 = new Player("Haden", 250, 164, 44.05f, "Austerlia");
		Player p3 = new Player("Haden12", 250, 164, 44.05f, "Austerlia");
		map.put(p, "Bangalore");
		map.put(null, "Chennai");
		map.put(p2, "Hyderabad");
		map.put(p1,"Mumbai");
		System.out.println(map);
		map = sortByValue(map);
		System.out.println(map);
		/*Set<Entry<Player, String>> entry = map.entrySet();
		Iterator<Entry<Player, String>> it = entry.iterator();
		while (it.hasNext()) {
			// if(it.next() != null){
			Entry<Player, String> kp = it.next();
			if (kp != null) {
				String str = kp.getKey() + "-" + kp.getValue();
				//System.out.println(str);
			}
		}
		//System.out.println(map);
		
		getSortMap(map);*/
	}
	
	public static Map<Player,String> getSortMap(Map<Player,String> input){
		Collection<String> llist = input.values();
		LinkedList<String> sk = new LinkedList<>();
		Iterator<String> ir = llist.iterator();
		while(ir.hasNext()){
			sk.add(ir.next());
		}
		System.out.println(sk);
		return input;
	}
	
	
	private static Map<Player,String> sortByValue(Map<Player,String> unsortMap) {

        List<Map.Entry<Player,String>> list =
                new LinkedList<Map.Entry<Player,String>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Player,String>>() {
            public int compare(Map.Entry<Player,String> o1,
                               Map.Entry<Player,String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<Player,String> sortedMap = new LinkedHashMap<Player,String>();
        for (Map.Entry<Player,String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
	}
}
