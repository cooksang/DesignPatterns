package vaskaran.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositPattern {
	public static void main(String[] args) {
		Teacher principal = new Teacher("Dr.S.Som", "Principal");

		Teacher hodMaths = new Teacher("Mrs.S.Das", "Hod-Math");

		Teacher hodCompSc = new Teacher("Mr.V.Sarcar", "Hod-ComputerSc.");

		Teacher mathTeacher1 = new Teacher("Math Teacher-1", "MathsTeacher");

		Teacher mathTeacher2 = new Teacher("Math Teacher-2", "MathsTeacher");

		Teacher cseTeacher1 = new Teacher("CSE Teacher-1", "CSETeacher");
		Teacher cseTeacher2 = new Teacher("CSE Teacher-2", "CSETeacher");
		Teacher cseTeacher3 = new Teacher("CSE Teacher-3", "CSETeacher");

		principal.add(hodMaths);
		principal.add(hodCompSc);

		hodMaths.add(mathTeacher1);
		hodMaths.add(mathTeacher2);

		hodCompSc.add(cseTeacher1);
		hodCompSc.add(cseTeacher2);
		hodCompSc.add(cseTeacher3);

		mathTeacher1.add(null);
		mathTeacher2.add(null);

		cseTeacher1.add(null);
		cseTeacher2.add(null);
		cseTeacher3.add(null);
		
		System.out.println(principal.getDetails());
		
		List<ITeacher> hods = principal.getControllingDepts();
		
		for(int i = 0; i < hods.size() ; i++ ){
			System.out.println("\t" + hods.get(i).getDetails());
		}
		
		List<ITeacher> mathTeachers = hodMaths.getControllingDepts();
		
		for(int i = 0 ; i < mathTeachers.size() ; i++ ){
			System.out.println("\t\t" + mathTeachers.get(i).getDetails());
		}
		
		List<ITeacher> cseTeachers = hodCompSc.getControllingDepts();
		
		for(int i = 0 ; i < cseTeachers.size() ; i++ ){
			System.out.println("\t\t" + cseTeachers.get(i).getDetails());
		}
		
		hodCompSc.remove(cseTeacher2);
		
		cseTeachers = hodCompSc.getControllingDepts();
		for(int i = 0 ; i < cseTeachers.size() ; i++ ){
			System.out.println("\t\t" + cseTeachers.get(i).getDetails());
		}
	}
}

interface ITeacher{
	public String getDetails();
}
class Teacher implements ITeacher{

	private String teacherName;
	private String deptName;
	private List<ITeacher> controls;
	
	Teacher(String teacherName, String deptName){
		this.teacherName = teacherName;
		this.deptName = deptName;
		controls = new ArrayList<ITeacher>();
	}
	
	public void add(Teacher teacher){
		controls.add(teacher);
	}
	
	public void remove(Teacher teacher){
		controls.remove(teacher);
	}
	
	public List<ITeacher> getControllingDepts(){
		return controls;
	}
	@Override
	public String getDetails() {
		return (teacherName + " is the " + deptName);
	}
}