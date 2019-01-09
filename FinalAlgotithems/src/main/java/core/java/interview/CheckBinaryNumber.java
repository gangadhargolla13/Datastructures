package core.java.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckBinaryNumber 
{

	public static void main(String[] arg)
	{
		Map<SimplePojo,Integer> map = new LinkedHashMap<>();
		SimplePojo po = new SimplePojo(101,"Ganga");
		SimplePojo po1 = new SimplePojo(102,"Ganga");
		map.put(po, 1);
		map.put(po1, 2);
		System.out.println(map.size());
		System.out.println(map.get(po1));
		boolean check =true;
		String s = null;
		if(s==null||s.length()>1)   // Bit wise operator both the condition will be verified
		{
			System.out.println("GangadhR");
		}
		/*Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		sc.close();
		while(value > 0)
		{
			if(value%10 > 1)
			{
				check=false;
				break;
			}
			value/=10;
		}*/
		System.out.println("Given number is binary "+check);
	}
}

class SimplePojo
{
	private Integer id;
	private String name;
	
	public SimplePojo(Integer id,String name)
	{
		this.id=id;
		this.name=name;
	}

	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;*/
		return 101;
	}

	@Override
	public String toString() {
		return "SimplePojo [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimplePojo other = (SimplePojo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/*public int hashcode()
	{
		return id;
	}
	
	public boolean equals(Object obj)
	{
		SimplePojo po = (SimplePojo)obj;
		if(this==obj)
			return true;
		if( !(obj instanceof SimplePojo))
		{
			return false;
		}
		if(this.name.equals(po.name)&&this.id==po.id)
			return true;
		else
			return false;
	}*/
}
