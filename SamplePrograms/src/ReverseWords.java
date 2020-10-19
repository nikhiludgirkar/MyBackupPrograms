import java.io.File;

public class ReverseWords {
	
	public static void main(String[] args) {
		
		
		String str="welcome to java programming";
		
		String[] splitted=str.split(" ");
		String word=null;
		for (int x=0; x<splitted.length; x++) {
			word=splitted[x];
			String reversed="";
			for (int y=word.length()-1; y>=0; y--) {
				reversed=reversed+word.charAt(y);
				
			}
			reversed=reversed+" ";
			System.out.print(reversed);
		}
	}
}