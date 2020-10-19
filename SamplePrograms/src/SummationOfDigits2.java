import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SummationOfDigits2 {
	public static void main(String[] args) {
		String s="nik12h21i1";
//		char ch; char ch2;
//		int counter=1, sum=0;
//		int p1=0;int p2=0;
//		for (int x=0; x<s.length(); x++) {
//			ch=s.charAt(x);
//			ch2=s.charAt(counter);
//			if (Character.isDigit(ch) && Character.isDigit(ch2)) {
//				p1=Character.getNumericValue(ch);
//				p2=Character.getNumericValue(ch2);
//				sum=sum+p1+p2;
//			}
//			counter++;
//		}
//		System.out.println("sum : "+sum);
		
		
		Pattern pattern=Pattern.compile("\\d");
		Matcher matcher=pattern.matcher(s);
		int sum2=0;
		while (matcher.find()) {
			sum2=sum2+Integer.parseInt(matcher.group());
		}
		System.out.println("sum"+sum2);
	}
}
