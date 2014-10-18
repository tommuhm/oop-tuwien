import java.util.ArrayList;
import java.util.Date;

public class Surfschool {
	private ArrayList<Course> courses;

	public Surfschool() {
		this.courses = new ArrayList<Course>();
	}

	public void addCourse(String courseName, Teacher teacher,
		ArrayList<Student> students, ArrayList<Date> dates) {
		Course course = new Course(courseName, teacher, students, dates);
		this.courses.add(course);
	}

	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	public void addStudent(Student student, Course course) {
		course.addStudent(student);
	}

	public void removeStudent(Student student, Course course) {
		course.removeStudent(student);
	}
}
