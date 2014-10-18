import java.util.ArrayList;
import java.util.Date;

public class Surfschool {
	private ArrayList<Course> courses;

	public Surfschool() {
		this.courses = new ArrayList<Course>();
	}

	public Course addCourse(String courseName, Float price, Teacher teacher,
			ArrayList<Student> students, ArrayList<Date> dates) {
		Course course = new Course(courseName, price, teacher, students, dates);

		return this.addCourse(course);
	}

	public Course addCourse(Course course) {
		this.courses.add(course);
		return course;
	}

	public void addStudent(Course course, Student student) {
		course.addStudent(student);
	}
	
	public void removeStudent(Course course, Student student) {
		course.removeStudent(student);
	}
	
	public void setTeacher(Course course, Teacher teacher) {
		course.setTeacher(teacher);
	}
	
	
}
