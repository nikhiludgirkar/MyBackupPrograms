
public class Singleton {
	
	private static Singleton single=null;
	public String str;
	private Singleton() {
		str="hello";
	}
	
	public static Singleton getInstance() {
		if (single==null)
			single=new Singleton();
		return single;
	}
	
	public static void main(String[] args) {
		Singleton s=Singleton.getInstance();
		System.out.println(s.str);
	}
		
}
