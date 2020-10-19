import java.util.Arrays;

public class AnagramSimpleMethod {
	public static void main(String[] args) {
		
		
		String s1="hitser woman";
		String s2="mother in law";
		
		s1=s1.replaceAll("\\s", "");
		s2=s2.replaceAll("\\s", "");
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		if (s1.length()!=s2.length())
			System.out.println("strings are not anagrams");
		else {
			Arrays.sort(c1);
			Arrays.sort(c2);
			boolean b=Arrays.equals(c1, c2);
			if (!b)
				System.out.println("not anagrams");
			else
				System.out.println("anagrams");
		}
		
	}
}
