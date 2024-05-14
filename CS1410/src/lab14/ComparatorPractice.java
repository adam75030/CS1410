package lab14;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPractice {

	public static void main(String[] args) {
		Student[] computerScientists = new Student[5];
		computerScientists[0] = new Student("Alan", "Turning", 12345, 3.7);
		computerScientists[1] = new Student("Ada", "Lovelace", 67890, 3.9);
		computerScientists[2] = new Student("Grace", "Hopper", 11223, 3.6);
		computerScientists[3] = new Student("Alan", "Kay", 99887, 3.5);
		computerScientists[4] = new Student("John", "Warnock", 66544, 3.75);

		// Normal usage
		Arrays.sort(computerScientists, new CompareByIdNumber());
		// Lambda version
		Arrays.sort(computerScientists, (s1, s2) -> s1.getID() - s2.getID());

		System.out.println(Arrays.toString(computerScientists));
		
		System.out.println(last(computerScientists, (s2, s1) -> Double.compare(0, 0)));
	}

	public static Student last(Student[] array, Comparator<Student> cmp) {
		Student last = array[0];
		for (Student s : array) {
			if (cmp.compare(s, last) > 0) {
				last = s;
			}
		}
		return last;
	}
}
