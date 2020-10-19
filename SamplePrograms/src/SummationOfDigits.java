
public class SummationOfDigits {
	public static void main(String[] args) {
		String s="nik12h21i1";
		char ch;
		int sum=0;
		int p=0;
		for (int x=0; x<s.length(); x++) {
			ch=s.charAt(x);
			if (Character.isDigit(ch)) {
				p=Character.getNumericValue(ch);
				sum+=p;
			}
		}
		System.out.println("summation is "+sum);
	}
}
