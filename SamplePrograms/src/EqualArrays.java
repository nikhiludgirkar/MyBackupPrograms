
public class EqualArrays {
	public static void main(String[] args) {
		
		int[] array1= {3434,534, 523, 55};
		int[] array2= {1,534, 523, 55};
		boolean flag=true;
		for (int x=0; x<array1.length; x++) {
			if (array1[x]!=array2[x])
				flag=false;
		}
		if (flag)
			System.out.println("equals");
		else
			System.out.println("not equals");
	}		
}
