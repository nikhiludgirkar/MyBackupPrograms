
public class TripletSum {
	public static void main(String[] args) {
		int[] array= {43,6,62,5,54,55,2};
		
		int sum=62;
		
		for (int x=0; x<array.length; x++) {
			for (int y=x+1; y<array.length; y++) {
				for (int z=y+1; z<array.length; z++) {
					if (array[x]+array[y]+array[z]==sum) {
						System.out.println("["+array[x]+", "+array[y]+", "+array[z]+"]");
					}
				}
			}
		}
		
	}
}
