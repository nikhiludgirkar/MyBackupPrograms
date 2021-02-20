import java.util.Arrays;

public class LeadersInArray {
	public static void main(String[] args) {
		int[] arr= {12, 9, 7, 14, 8, 6, 3};
		Arrays.toString(arr);
		int count=0;
		StringBuilder br=new StringBuilder();
		for (int x=0; x<arr.length; x++) {
			boolean flag=true;
			for (int y=x+1; y<arr.length; y++) {
				if (arr[y] > arr[x]) {
					flag=false;
					break;
				}
			}
			if (flag)
				System.out.println(arr[x]);
		}
		
		
//		for (Integer i : newArr)
//			System.out.println(i);
	}
}
