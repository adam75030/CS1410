package lab09;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private int idNumber;
	private double GPA;

	public Student(String firstName, String lastName, int idNumber, double GPA) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.GPA = GPA;
	}

	public String toString() {
		return "Name: " + this.firstName + " " + this.lastName + " ID Number: " + this.idNumber + " GPA: " + this.GPA;
	}

	@Override
	public int compareTo(Student other) {
		//Compares GPA
		if (this.GPA > other.GPA)
			return 1;
		if (this.GPA < other.GPA)
			return -1;
		return 0;
		
//		//Compares names
//		int result = this.lastName.compareTo(other.lastName);
//		if (result == 0) {
//			return this.firstName.compareTo(other.firstName);
//		}
	}
}