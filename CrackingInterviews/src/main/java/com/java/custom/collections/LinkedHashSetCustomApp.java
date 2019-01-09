package com.java.custom.collections;

public class LinkedHashSetCustomApp {

}

class LinkedHashSetCustom<E>
{
	private LinkedHashMapCustom<E, Object> linkedHashMapCustom;
	
	public LinkedHashSetCustom(){
        linkedHashMapCustom=new LinkedHashMapCustom<>();
 }
 
 /**
  * add objects in LinkedHashSetCustom.
  */
 public void add(E value){
        linkedHashMapCustom.put(value, null);
        
 }

 /**
  * Method returns true if LinkedHashSetCustom contains the object.
  * @param key
  */
 public boolean contains(E obj){
       // return linkedHashMapCustom.contains(obj) !=null ? true :false;
	 return true;
 }
 
 /**
  * Method displays all objects in LinkedHashSetCustom.
  * insertion order is not guaranteed, for maintaining insertion order refer LinkedHashSet.
  */
 public void display(){
   // linkedHashMapCustom.displaySet();
 }
}