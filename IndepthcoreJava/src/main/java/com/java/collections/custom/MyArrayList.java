package com.java.collections.custom;

public class MyArrayList {

	private static final int INITIAL_CAPACITY = 5;
	private Object data[];
	private int index;
	private int size;
	
	public MyArrayList(){
		this.data = new Object[INITIAL_CAPACITY];
		this.size = INITIAL_CAPACITY;
	}
	
	public void add(Object obj){
		if(this.index==this.size-1){
			increaseSize();
		}
		data[this.index]=obj;
		this.index++;
	}
	
	private void increaseSize(){
		this.size = this.size+INITIAL_CAPACITY;
		Object[] newData = new Object[this.size];
		for(int i=0;i<data.length;i++){
			newData[i]=data[i];
		}
		this.data = newData;
	}
	
	public Object get(int i) throws Exception{
		if(i>this.index-1){
			throw new ArrayIndexOutOfBoundsException("Which value you are looking for that is out of bound");
		}
		if(i<0){
			throw new Exception("you given negative value");
		}
		return this.data[i];
	}
	
	public void remove(int i) throws Exception{
		if(i > this.index-1){
			throw new ArrayIndexOutOfBoundsException();
		}if(i < 0){
			throw new Exception("Negative values");
		}
		for(int x=i;x<this.data.length;x++){
			this.data[x]=this.data[x+1];
		}
	}
}
