package com.java.core.string;

public enum EnumExample {
	Start("gan"),Wait("malli"),Notify("gayatri"),NotifyAll("ganesh"),Run("sujatha");
	public String name;
	private EnumExample(String name){
		this.name=name;
	}
	
	/*public String getName()
	{
		return name;
	}*/
	public  static EnumExample getState(String hh)
	{
		for(EnumExample ex : EnumExample.values())
		{
			if(ex.name.equals(hh))
				return ex;
		}
		//throw new IllegalArgumentException();
		EnumExample dd = EnumExample.valueOf(hh);
		System.out.println(dd);
		switch(dd)
		{
		case Start:
			return dd;
		case Wait:
			return dd;
		case Notify:
			return dd;
		case NotifyAll:
			return dd;
		case Run:
			return dd;
			default: 
				throw new IllegalArgumentException("I am woring!");
		}
	}
}
