
public class FindDuplicatesV2 {
	public static void main(String[] args) {
		
		int[] array={244,43,11,67,43};
		
		for (int x=0; x<array.length; x++) {
			for (int y=x+1; y<array.length; y++) {
				if (array[x]==array[y])
					System.out.println(array[x]);
			}
		}
	}
}
