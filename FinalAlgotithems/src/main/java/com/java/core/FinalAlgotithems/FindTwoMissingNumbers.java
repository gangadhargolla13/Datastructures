package com.java.core.FinalAlgotithems;

public class FindTwoMissingNumbers {
	int Sum;
	int SumN;
	int P=1;
	int Np=1;
	int a,b;
	//By using xor approach
	public void findMissingNumbers(int arr[], int n)
	{
		int xor=arr[0];
		for(int i=1;i<n-2;i++)
		{
			xor^=arr[i];
		}
		for(int i=1;i<=n;i++)
		{
			xor^=i;
		}
		System.out.println(xor);
		int setBit = xor & ~(xor-1); // to find right shift
		System.out.println(setBit);
		int x=0,y=0;
		for(int i=0;i<n-2;i++)
		{
			if((arr[i]&setBit)>0)
			{
				x = x ^ arr[i];
			}
			else
				 y = y ^ arr[i];
		}
		for(int i=1;i<=n;i++){
			if((i & setBit)>0)
			{
				x = x ^ i;
			}else
			{
				y = y ^ i;
			}
		}
		System.out.println("Two missing numbers are "+x+" "+y);
	}
	
	//By using average numbers
	
	//By using product of two numbers  a
	
	public int []  missingNumbers(int [] arrA, int range){
		SumN = range*(range+1)/2;
		for(int i=0;i<arrA.length;i++){
			Sum +=arrA[i];
		}
		int s= SumN-Sum;
		for(int i=0;i<arrA.length;i++){
			P *=arrA[i];
		}
		for(int i=1;i<=range;i++){
			Np *=i;
		}
		int product = Np/P;
//		System.out.println(product);
		int diffSqr = (int)Math.sqrt(s*s-4*product); // (a-b)^2 = (a+b)^2-4ab
		a = (s+diffSqr)/2;
		b= s-a;
		int [] result = {a,b};
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 6};
		FindTwoMissingNumbers nu = new FindTwoMissingNumbers();
		nu.findMissingNumbers(arr, arr.length+2);
	}
}
