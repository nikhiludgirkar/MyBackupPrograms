
public class CallByValue {
	int a=45;
	
	public void getValue(int a) {
		a=a+13;
	}
	
	public static void main(String[] args) {
		CallByValue c=new CallByValue();
		System.out.println(c.a);
		c.getValue(24);
		System.out.println(c.a);
	}
	
}
