package lab14;

/**
 * This class represents a simple student.  The natural ordering among
 * students is by name (last, then first).
 *
 * @author Prof. Martin
 * @version Lab 14
 */
public class Student implements Comparable<Student> {

	private String firstName;
	private String lastName;
	private int idNumber;
	private double gpa;

	/**
	 * Creates a new Student object, with the given data.
	 *
	 * @param firstName
	 * @param lastName
	 * @param idNumber
	 * @param gpa
	 */
	public Student(String firstName, String lastName, int idNumber, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.gpa = gpa;
	}

	/**
	 * Generates and returns a textual representation of this student.
	 */
	public String toString() {
		return "(" + firstName + " " + lastName + " " + idNumber + " " + gpa + ")";
	}

	/**
	 * Compares this student to another student.
	 *
	 * @param other - the other student to be compared
	 * @return a negative integer if this student's name comes before the other
	 *         student's name lexicographically, a positive integer if this student's
	 *         name comes after, zero if both student names are the same
	 */
	public int compareTo(Student other) {
		int result = this.lastName.compareTo(other.lastName);
		if(result == 0)
			return this.firstName.compareTo(other.firstName);
		return result;
	}
	
	public int getID() {
		return this.idNumber;
	}
	
	public double getGpa() {
		return this.gpa;
	}
}
