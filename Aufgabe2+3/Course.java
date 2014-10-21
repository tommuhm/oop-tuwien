import java.util.ArrayList;
import java.util.Date;

public class Course {

	private String courseName;
	private float price;

	private Teacher teacher;
	private ArrayList<Student> students;
	private ArrayList<Date> dates;

	public Course(String courseName, Float price, Teacher teacher,
	              ArrayList<Student> students, ArrayList<Date> dates) {
		this.courseName = courseName;
		this.price = price;
		this.teacher = teacher;
		this.students = students;
		this.dates = dates;
	}

	public Course(String courseName, Float price, Teacher teacher) {
		this.courseName = courseName;
		this.price = price;
		this.teacher = teacher;
		this.students = new ArrayList<Student>();
		this.dates = new ArrayList<Date>();
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	public void addDate(Date date) {
		this.dates.add(date);
	}

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
