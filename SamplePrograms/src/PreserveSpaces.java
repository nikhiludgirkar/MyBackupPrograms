import java.util.Arrays;

public class PreserveSpaces {
	public static void main(String[] args) {
		String mainArray="java programming";
		char[] charArray=mainArray.toCharArray();
		char[] resultArray=new char[charArray.length];
		
		for (int x=0; x<charArray.length; x++) {
			if (charArray[x]==' ') {
				resultArray[x]=' ';
			}
		}
		int len=resultArray.length-1;
		System.out.println("length is : "+len);
		System.out.println("*"+charArray.toString());
		for (int x=0; x<charArray.length; x++) {
			if (charArray[x]!=' ') {
				if (resultArray[len]==' ') {
					len--;
				}
				resultArray[len]=charArray[x];
				len--;
			}
		}
		
		System.out.println(mainArray+" ---> "+String.valueOf(resultArray));
	}
}
