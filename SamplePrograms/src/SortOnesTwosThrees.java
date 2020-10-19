import java.util.Arrays;

public class SortOnesTwosThrees {
	public static void main(String[] args) {
		int[] array= {1, 0, 2, 2, 0, 2, 1, 2, 1, 1, 2, 0};
		int zeroes=0, ones=0, twos=0;
		for (int x=0; x<array.length; x++) {
			if (array[x]==0)
				zeroes++;
			if (array[x]==1)
				ones++;
			if (array[x]==2)
				twos++;
		}
		
		for (int x=0; x<zeroes; x++) {
			array[x]=0;
		}
		
		for (int x=zeroes; x<array.length; x++) {
			array[x]=1;
		}
		System.out.println("zeroes counter : "+zeroes);
		System.out.println("ones counter : "+ones);
		for (int x=zeroes+ones; x<array.length; x++) {
			array[x]=2;
		}
		System.out.println("after sorting");
		System.out.println(Arrays.toString(array));
	}
}
