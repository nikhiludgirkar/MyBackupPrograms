
public class LongestSequenceOfChar2 {
	public static void main(String[] args) {
		String s="I jhate programming";
		
		int y=0;
		String result=" ";
		for (int x=0; x<s.length(); x++) {
			if (s.charAt(x)==s.charAt(y))
				result=result+s.charAt(x);
			y++;
		}
		System.out.println(result);
	}
}
