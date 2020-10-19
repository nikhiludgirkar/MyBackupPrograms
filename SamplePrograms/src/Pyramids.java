
public class Pyramids {
	public static void main(String[] args) {
		int count=1;
		for (int x=1; x<=5; x++) {
			for (int y=(8-x); y>=1; y--) {
				System.out.print(" ");
			}
			
			for (int z=1; z<=x; z++) {
				System.out.print(z+" ");
			}
			
			for (int xx=(x-count); xx>=1; xx--) {
				System.out.print(xx+" ");
			}
			System.out.println();
		}
		
		for (int x=1; x<=7; x++) {
			for (int y=7; y>=x; y--) {
				System.out.print(y);
			}
			System.out.println();
		}
		
		for (int x=1; x<=7; x++) {
			
		}
		
		
		
	}
}
