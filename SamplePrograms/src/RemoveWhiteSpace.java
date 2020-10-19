
public class RemoveWhiteSpace {
	public static void main(String[] args) {
		String title="this is java programming";
		
		System.out.println(title.replace(" ", ""));
		
		System.out.println(title.replaceAll("\\S", ""));

	}
}
