package core.java.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FindSequenceofSquares 
{

	public static void main(String[] args) {
		String query = "show files in dfs.`temp`;";
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0;i<arr.length;i++){
			arr[i] = sc.nextInt();
		}
		ArrayList<String> al = new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<>();
		int s= arr[0];
		int e = arr[0];
		String str = String.valueOf(arr[0]);
		for(int i=1;i<arr.length;i++){
			if(s*e==arr[i]){
				e=arr[i];
				//str=str+","+arr[i];
				str=str+arr[i];
			}else
			{
				al.add(str);
				s=arr[i];
				e=arr[i];
				str=String.valueOf(arr[i]);
			}
		}
		for(String s1:al){
			if(map.containsKey(s1))
			{
				map.put(s1, map.get(s1)+1);
			}
			else
			{
				map.put(s1, 1);
			}
		}
		
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> entry :set)
		{
			String key = entry.getKey();
			//if(key.indexOf(",")!=-1)
			if(key.length()>1)
			{
				String[] ss = key.split(""); 
				StringBuilder sb = new StringBuilder();
				sb.append("SEQUENCE:");
				for(String s11 :ss)
				{
					sb.append(s11);
					sb.append(",");
				}
				String res = sb.substring(0, sb.lastIndexOf(","));
				System.out.println(res+" OCCURENCE:"+entry.getValue());
			}
		}
		sc.close();
	}
}
