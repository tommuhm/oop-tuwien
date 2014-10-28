import java.util.ArrayList;
import java.util.Date;

public class Course {

	private String courseName;
	private float price;
	//INVARIANT: price > 0, courseName != null

	private Teacher teacher;
	private ArrayList<Student> students;
	private ArrayList<Date> dates;
	//INVARIANT: teacher != null, students != null, dates != null

	//PRECONDITION: courseName != null, price > 0, teacher != null, students != null, dates != null
	public Course(String courseName, Float price, Teacher teacher,
	              ArrayList<Student> students, ArrayList<Date> dates) {
		this.courseName = courseName;
		this.price = price;
		this.teacher = teacher;
		this.students = students;
		this.dates = dates;
	}

	//PRECONDITION: courseName != null, price > 0, teacher != null
	public Course(String courseName, Float price, Teacher teacher) {
		this.courseName = courseName;
		this.price = price;
		this.teacher = teacher;
		this.students = new ArrayList<Student>();
		this.dates = new ArrayList<Date>();
	}

	//PRECONDITION: student != Null
	public void addStudent(Student student) {
		this.students.add(student);
	}

	//PRECONDITION: student != null, students contain student
	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	//PRECONDITION: date != null, !dates.contains(date)
	//BAD: We should have checked if dates contains date.
	public void addDate(Date date) {
		this.dates.add(date);
	}

	//PRECONDITION: date != null, dates contain date
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
