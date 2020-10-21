import java.util.LinkedHashSet;

public class RemoveDuplicateWords {
	public static void main(String[] args) {
		
		String str="hello world india hello";
		
		String s[]=str.split(" ");
		
		LinkedHashSet<String> lh=new LinkedHashSet<String>();
		
		for (String a : s) {
			lh.add(a);
		}
		
		for (String a : lh)
			System.out.println(a);
		
		
		str="hello world india hello";
		
		String s2[]=str.split(" ");
		
		for (int x=0; x<s2.length; x++) {
			for (int y=0; y<s2.length; y++) {
				if (s2[x].equals(s2[y])){
					if (x!=y)
						s2[x]=" ";
				}
			}
		}
		
		for (String a : s2)
			System.out.println(a);
	}
}
