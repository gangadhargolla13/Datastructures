package com.java.newfeature;

public class Employee {

	private String name;
	  private Integer age;
	  public Employee(String name, Integer age){
	    this.name=name;
	    this.age=age;
	  } 
	  public String getName(){
	    return name;
	  }
	  public void setName(String name){
	    this.name=name;
	  } 
	  public Integer getAge(){
	    return this.age;
	  } 
	  public void setAge(Integer age){
	    this.age=age;
	  }  
	  public String toString(){
	    return "Employee Name:"+this.name
	      +"  Age:"+this.age;
	  } 
	  
	  public boolean equsls(Object obj)
	  {
		  if(obj == this)
		  {
			  return true;
		  }
		  if(!(obj instanceof Employee))
			  return false;
		  Employee e =(Employee) obj;
		  return e.getAge()==this.age && this.name.equals(e.getName());
	  }
	  
	  public int hashCode()
	  {
		  int hash = 1;
		    hash = hash * 17 + this.name.hashCode();
		    hash = hash * 31 + this.age;
		    return hash;
	  }
}
