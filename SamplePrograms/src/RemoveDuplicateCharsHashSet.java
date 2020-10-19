import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharsHashSet {
	public static void main(String[] args) {
		String name="nikhil";
		
		char[] array=name.toCharArray();
		
		Set<Character> set=new HashSet<Character>();
		
		for (char c : array) {
			set.add(c);
		}
		
		for (char c: set)
			System.out.println(c);
	}	
}
