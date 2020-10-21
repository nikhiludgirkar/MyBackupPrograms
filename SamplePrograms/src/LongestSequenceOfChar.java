
public class LongestSequenceOfChar {
	public static void main(String[] args) {
		String str="hello worlddd india is beautiful";
		String result = "";
	    for (int i = 0; i < str.length(); i++) {
	        int j = i;
	        while(j < str.length() && str.charAt(j) == str.charAt(i)) {
	            j++;
	        }
	        if(j - i > result.length()) {
	            result = str.substring(i, j);
	            System.out.println(result);
	        }
	    }
//	    System.out.println(result);
	}
}
