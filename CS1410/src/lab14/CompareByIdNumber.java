package lab14;

import java.util.Comparator;

public class CompareByIdNumber implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getID() - s2.getID();
	}
}
