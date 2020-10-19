import java.util.Arrays;

public class SortZerosAndOnes {
	public static void main(String[] args) {
		int[] array= {1, 0, 1, 1, 0, 1, 0, 0};
		
		System.out.println(Arrays.toString(array));
		
		int zeroes=0;
		int ones=0;
		for (int x=0; x<array.length; x++) {
			if (array[x]==0)
				zeroes++;
			if (array[x]==1)
				ones++;
		}
		System.out.println(zeroes);
		System.out.println(ones);
		
		for (int x=0; x<zeroes; x++) {
			array[x]=0;
		}
		
		for (int x=zeroes; x<array.length; x++) {
			array[x]=1;
		}
		System.out.println("after sort");
		System.out.println(Arrays.toString(array));
	}
}
