import java.util.ArrayList;
import java.util.Date;

public class SurfSchool {
	private ArrayList<Course> courses;
	// INVARIANT: courses is never null

	public SurfSchool() {
		this.courses = new ArrayList<Course>();
	}

	// PRECONDITION: course must not be null and courses must not already contain the course
	// BAD: if-clause with !(courses.contains(course)) would have been good.
	public Course addCourse(Course course) {
		this.courses.add(course);
		return course;
	}

	// PRECONDITION: course and student must not be null, course must not already contain the student.
	public void addStudent(Course course, Student student) {
		course.addStudent(student);
	}

	// PRECONDITION: course and student must not be null, course must not already contain the student.
	public void removeStudent(Course course, Student student) {
		course.removeStudent(student);
	}

	// PRECONDITION: course must not be null
	// POSTCONDITION: bills contains a bill for every student
	public ArrayList<OutgoingBill> createOutgoingBills(Course course) {
		ArrayList<OutgoingBill> bills = new ArrayList<OutgoingBill>();
		for (Student student : course.getStudents()) {
			OutgoingBill bill = new OutgoingBill("Surfschool: " + course.getCourseName(),
					course.getPrice(),
					new Date(),
					true,
					student);
			bills.add(bill);
		}
		return bills;
	}

}