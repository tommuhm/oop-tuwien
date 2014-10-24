import java.util.ArrayList;
import java.util.Date;

public class SurfSchool {
	private ArrayList<Course> courses;
	//INVARIANT: courses != null

	public SurfSchool() {
		this.courses = new ArrayList<Course>();
	}

	//PRECONDITION: course != null && !(courses.contains(course))
	//BAD: if-clause with !(courses.contains(course)) would have been good. 
	public Course addCourse(Course course) {
		this.courses.add(course);
		return course;
	}

	//PRECONDITION: course != null, student != null, course doesn't contain student.
	public void addStudent(Course course, Student student) {
		course.addStudent(student);
	}

	//PRECONDITION: course != null, student != null, course contains student.
	public void removeStudent(Course course, Student student) {
		course.removeStudent(student);
	}

	//PRECONDITION: course != null
	//POSTCONDITION: bills contains a bill for every student
	public ArrayList<OutgoingBill> createOutgoingBills(Course course) {
		ArrayList<OutgoingBill> bills = new ArrayList<OutgoingBill>();
		for (Student student : course.getStudents()) {
			OutgoingBill bill = new OutgoingBill("Surfschool: " + course.getCourseName(),
					course.getPrice(),
					new Date(),
					true,
					student); //Everybody pays in cash.
			bills.add(bill);
		}
		return bills;
	}

}