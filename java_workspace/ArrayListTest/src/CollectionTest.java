import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Student {
	String name;
	String department;
	
	Student(){}
	Student(String name, String department) {
		this.name = name;
		this.department = department;
	}
}


public class CollectionTest {

	public static void main(String[] args) {
		//Araaylist에   Student 클래스 사용
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동","컴퓨터학과"));
		list.add(new Student("이순신","철학과"));
		for (Student s : list) {
			System.out.println("이름 "+s.name+", 학과 : "+s.department);
		}
		
		//HashMap에 Student클래스 사용
		Map<String,Student> students = new HashMap<String,Student>();
		students.put("wg", new Student("왕건","국문학과"));
		students.put("ssid", new Student("신사임당","수학과"));
		Set<String> keySet = students.keySet();
		for (String k : keySet) {
//			System.out.println(students.get(k).name);
//			System.out.println(students.get(k).department);
			Student s = students.get(k);
			System.out.println("이름 "+s.name+", 학과 : "+s.department);
		}
	}

}
