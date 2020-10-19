import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReverseContentsOfFile {
	public static void main(String[] args) throws IOException {
		File file=new File("test.txt");
		FileReader reader=new FileReader(file);
		BufferedReader br=new BufferedReader(reader);
		String s="";
		String newLineChar = System.getProperty("line.separator");
		StringBuffer sb=new StringBuffer();
		FileWriter writer=new FileWriter("test.txt", true);
		String aa="";
		while ((s=br.readLine())!=null) {
			aa=aa+s;
			aa=aa+newLineChar;
		}
		String[] p=aa.split(" ");
		String reversed="";
		String word="";

		for (int x=0; x<p.length; x++) {
			word=p[x];
			for (int y=word.length()-1; y>=0; y--) {
				reversed=reversed+word.charAt(y);
			}
			reversed=reversed+" ";
		}
//		System.out.print(reversed);
//		String ab="";
//		String reversed="";
//		for (int x=0; x<aa.length(); x++) {
//			ab=aa[x];
//			
//			for (int y=ab.length()-1; y>=0; y--) {
//				reversed=reversed+ab.charAt(y);
//			}
//		}
//		System.out.println(reversed);
//		br.close();
		writer.write(reversed);
		System.out.println(reversed);
		reader.close();
		writer.close();
	}
}
