package stud;

public class Test {
	
	public void setdata(Student s1)
	{
		Address a=new Address();
		a.setAdd("Mumbai");
		s1.setfName("Omkar");
		s1.setlName("Falke");
		s1.setAddress(a);
	}
	public void setdata1(Student s1)
	{
		Address a1=new Address();		
		a1.setAdd("Pune");
		s1.setfName("Yash");
		s1.setlName("W");
		s1.setAddress(a1);
	}
	
	
}
