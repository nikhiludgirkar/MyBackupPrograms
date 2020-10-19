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
		for (int x=0; x<charArray.length; x++) {
			if (charArray[x]!=' ') {
				resultArray[len]=charArray[x];
				len--;
				if (resultArray[len]==' ') {
					len--;
				}
			}
		}
		System.out.println(String.valueOf(resultArray));
	}
}
