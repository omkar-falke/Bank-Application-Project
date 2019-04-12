package stud;
public class StudTest {
	public static void main(String[] args) {
		Test t1 = new Test();
		Student s = new Student();
		Student s1 = new Student();
		t1.setdata(s);
		t1.setdata1(s1);
		
		System.out.println(s.getfName());
		System.out.println(s.getlName());
		System.out.println(s.getAddress().getAdd());
		System.out.println("---*******-------********-----");
		System.out.println(s1.getfName());
		System.out.println(s1.getlName());
		System.out.println(s1.getAddress().getAdd());
	

	}
}
