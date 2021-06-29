
public class RemoveDuplicatesBruteForce {
	public static void main(String[] args) {
		int[] array= {43,67,266,25,43};
		int[] copy=new int[array.length];
		int l=0;
		for (int x=0; x<array.length-1; x++) {
			if (array[x]!=array[x+1]) {
				copy[l]=array[x];
				l++;
			}
		}
		copy[l++]=array[4];
		for (int x=0; x<l; x++)	
			array[x]=copy[x];
		
		for (Integer i : array)
			System.out.println(i);
	}
}
