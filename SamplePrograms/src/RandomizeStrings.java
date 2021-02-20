import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomizeStrings {
	public static void main(String[] args) throws IOException {

		String s1="cdr1, cdr2, cdr3, cdr4, cdr5, cdr43";

		String[] split=s1.split("\\,");

		//		String location=System.getProperty("user.dir");
		File file=new File("d:\\test.txt");
		FileWriter writer=new FileWriter(file);
		Random random=new Random();
		BufferedWriter bw=new BufferedWriter(writer);
		String newLine=System.getProperty("line.separator");
		int index=0;
		int i=0;
		for (int x=0; x<=10000; x++) {
			i=0;
			while (i<split.length) {
				index=random.nextInt(split.length);
				bw.write(split[index]+", ");
//				System.out.println(split[index]);
				i++;
			}
			bw.write(newLine);
		}
		bw.close();
	}
}
