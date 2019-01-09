package com.java.generic.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GenericExample {

	public static <T> T getMax(T x,T y)
	{
		if(x==y)
		{
			System.out.println("Operation is same");
		}
		return x == y ? x : y;
	}
	public static void main(String[] args) throws Exception{
		getMatchedTableList("events.*");
		/*List<Object> list = new ArrayList<Object>();
		list.add("Gangadhar");
		list.add("Malli");
		list.add("Gang");
		System.out.println(list.get(0));
		Pair<String,Integer> pair = new Pair<String,Integer>("Gangadhar",89);
		pair.setKey("Mallikarjuna");
		pair.setValue(456);
		System.out.println(pair.getKey());
		System.out.println(pair.getValue());*/
		//String y= getMax("Ganga","Malli");
		//System.out.println(y);
	}
	
	public static void getMatchedTableList(String ptableName) throws InterruptedException
    {
        List<String> matchTableNames = new ArrayList<String>();

        Pattern pattern = Pattern.compile(ptableName);
        matchTableNames.add("events");
        matchTableNames.add("events_1");
        matchTableNames.add("events_2");
        matchTableNames.add("events_3");
        matchTableNames.add("conf_3");
        for (String tableName : matchTableNames)
        {
            if (pattern.matcher(tableName).matches())
            {
                System.out.println(tableName);
            }
        }
    }
}
class Pair<K, V> {

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    public void setKey(K key)     { this.key = key; }
    public void setValue(V value) { this.value = value; }

    private K key;
    private V value;
}

/*class Singleton<T>{
	private T instant = null;
	public  T getInstance(){
		if(instant == null){
			instant = new Singleton<T>();pinputDetails.get(1).toString()
		}
		return instant;
	}
}*/
/*class Singleton<T>{
	
	 public static T getInstance() {
	        if (instance == null)
	            instance = new Singleton<T>();

	        return instance;
	    }
	 private static T instance = null;
}*/