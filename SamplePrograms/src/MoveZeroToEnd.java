
public class MoveZeroToEnd {
	public static void main(String[] args) {
		
		int[] arr= {483,0,0,44,1};
//		int len=arr.length+1;
		int count=0;
		for (int x=0; x<arr.length; x++) {
			if (arr[x]!=0) {
				arr[count]=arr[x];
				count++;
			}
		}
		
		while (count<arr.length) {
			arr[count]=0;
			count++;
		}
		
		for (Integer i : arr)
			System.out.println(i);
	}
}
