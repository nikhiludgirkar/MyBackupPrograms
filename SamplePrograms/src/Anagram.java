
public class Anagram {
	public static void main(String[] args) {
		
		String s1="hitlep woman";
		String s2="mother in law";
		
		String copyOfS1=s1.replaceAll("\\s", "");
		String copyOfS2=s2.replaceAll("\\s", "");
		
		boolean status=true;
		
		if (copyOfS1.length()!=copyOfS2.length()) {
			status=false;
		}
		
		else {
			char[] s1array=copyOfS1.toCharArray();
			
			for (char c : s1array) {
				int index=copyOfS2.indexOf(c);
				if (index!=-1) {
					copyOfS2=copyOfS2.substring(0, index)+
							copyOfS2.substring(index+1, copyOfS2.length());
					System.out.println("**********"+copyOfS2);
				}
				else {
					status=false;
					break;
				}
			}
		}
		
		if (status)
			System.out.println("anagram");
		else
			System.out.println("not anagram");
	}
}
