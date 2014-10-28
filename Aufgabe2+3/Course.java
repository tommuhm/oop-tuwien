import java.util.ArrayList;
import java.util.Date;

public class Course {

	private String courseName;
	private float price;

	private Teacher teacher;
	private ArrayList<Student> students;
	private ArrayList<Date> dates;
	// INVARIANT: price is always greater than zero
	// INVARIANT: courseName, teacher, students and dates are never null

	// PRECONDITION: price has to be greater than zero, courseName, teacher, students and dates must not be null
	public Course(String courseName, Float price, Teacher teacher,
	              ArrayList<Student> students, ArrayList<Date> dates) {
		this.courseName = courseName;
		this.price = price;
		this.teacher = teacher;
		this.students = students;
		this.dates = dates;
	}

	// PRECONDITION: price has to be greater than zero, courseName and teacher must not be null
	public Course(String courseName, Float price, Teacher teacher) {
		this.courseName = courseName;
		this.price = price;
		this.teacher = teacher;
		this.students = new ArrayList<Student>();
		this.dates = new ArrayList<Date>();
	}

	// PRECONDITION: student must not be null
	public void addStudent(Student student) {
		this.students.add(student);
	}

	// PRECONDITION: student must not be null, students contain student
	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	// PRECONDITION: date must not be null, dates must not already contain date
	// BAD: We should have checked if dates contains date.
	public void addDate(Date date) {
		this.dates.add(date);
	}

	// PRECONDITION: date must not be null, dates has to contain date
	public void removeDate(Date date) {
		this.dates.remove(date);
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<Date> getDates() {
		return dates;
	}

	public String getCourseName() {
		return courseName;
	}

	public float getPrice() {
		return price;
	}

}
