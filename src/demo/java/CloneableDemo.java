package demo.java;

public class CloneableDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student s1 = new Student(1, "Aman", new Address("Ahmedabad"), new Course("CS"));
		System.out.println("Original, s1 : " + s1);
		
		Student s2 = (Student) s1.clone();
		System.out.println("Clone, s2 : " + s2);

		s2.setId(2);
		s2.setName("Adi");
		s2.getStudentAddress().setAddress("Delhi");
		s2.getCourse().setCourseName("MBA");
		System.out.println("After change, s1 : " + s1);
		System.out.println("After change, s2 : " + s2);
	}
}

class Student implements Cloneable {
	private int id;
	private String name;
	private Address studentAddress;
	private Course course;
	
	public Student(int id, String name, Address studentAddress, Course course) {
		this.id = id;
		this.name = name;
		this.studentAddress = studentAddress;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", studentAddress=" + studentAddress + ", course=" + course
				+ "]";
	}
	// Shallow copy
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	// Deep Copy
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student s = (Student) super.clone();
		s.setStudentAddress((Address) s.getStudentAddress().clone());
		return s;
	}
	
}

class Address implements Cloneable {
	private String address;

	public Address(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
};

class Course {
	private String courseName;

	public Course(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + "]";
	}
};