package lab09;

import java.util.Collections;
import java.util.ArrayList;

public class StudentDemo {

	public static void main(String[] args) {
		Student s1 = new Student("Adam", "Wightman", 123, 3.5);
		Student s2 = new Student("bruh", "moment", 456, 1.0);
		Student s3 = new Student("goody", "twoshoes", 789, 4.0);

		System.out.println(s1);
		System.out.println();
		
		int result = s1.compareTo(s2);
		if(result > 0)
		   System.out.println("The first student's GPA is larger.");
		else if(result < 0)
		   System.out.println("The second student's GPA is larger.");
		else
		   System.out.println("Both students have the same GPA.");
		
		ArrayList<Student> graduates = new ArrayList<Student>();
		graduates.add(s1);
		graduates.add(s2);
		graduates.add(s3);
		Collections.sort(graduates);
		System.out.println(graduates);
	}
}
