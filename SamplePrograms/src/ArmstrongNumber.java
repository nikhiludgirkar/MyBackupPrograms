
public class ArmstrongNumber {
	public static void main(String[] args) {
		
		int num=153;
		int temp=num;
		int sum=0;
		int a=0;
		while (num>0) {
			a=num%10;
			sum=sum+(a*a*a);
			num=num/10;
		}
		
		if (sum==temp)
			System.out.println("armstrong");
		else
			System.out.println("not armstrong");
	}
}
