import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

class Student{
	String name;
	int marks;
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

class nameCompare implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2)
	{
		return s1.name.compareTo(s2.name);
	}
}

class marksCompare implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2){
		return s2.marks - s1.marks;
	}
}

public class SortMultiColFile {

	public static void main(String[] args) throws IOException  {
		BufferedReader br=new BufferedReader(new FileReader(new File("d:\\sort.txt")));

		String line=br.readLine();

		while (line!=null) {

		}

	}
}
