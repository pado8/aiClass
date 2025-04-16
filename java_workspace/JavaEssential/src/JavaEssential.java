import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.naver.service.Person; // Person은 패키지가 드르므로 import
import com.naver.service.Person2;
import com.naver.service.Student;
import com.naver.service.Student2;


// package가 없으면 default package
public class JavaEssential {

	public static void main(String[] args) {
		//instance 생성
		Person p = new Person();
		p.name = "홍길동"; // public 이므로 접근 가능
		p.sleep(); // public 이므로 접근 가능
		System.out.println(p.name);
		
		Person2 p2 = new Person2();
		//p2.name = "이순신"; // private 이므로 접근불가
		p2.setName("이순신"); // setter사용. 저장
		p2.sleep(); // public이므로 접근가능
		System.out.println(p2.getName());// getter사용. 읽기
		
		Student s = new Student();
		s.name = "왕건"; // Person의 name 사용 가능
		s.department = "철학과";
		s.sleep(); // Person의 sleep() 사용 가능
		//s.study(); // default 접근제한자이므로 접근 불가
		
		Person p3 = new Person("을지문덕"); // 인스턴스를 생성하면서 name 초기화
		System.out.println(p3.name);
		
		Student s2 = new Student("강감찬","컴퓨터공학과"); //인스턴스를 생성하면서 name, department 초기하
		System.out.println(s2.name);
		System.out.println(s2.department);
		
		//Person3 p4 = new Person3(); // interface는 instance 생성 불가
		Student2 s3 = new Student2();
		s3.name = "심사임당";
		s3.department = "전자공학";
		System.out.println(s3.name);
		System.out.println(s3.department);
		s3.sleep();
		
		//ArrayList에 Student 객체 사용하기
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student());
		list.add(new Student());
		Student s4 = new Student();
		list.add(s4);
		list.get(0).name = "이율곡";
		list.get(0).department = "국문학과";
		Student s5 = list.get(1);
		s5.name = "광개토대왕";
		s5.department = "정치학과";
		
		//HashMap Map<key, value>
		Map<String,Student2> map = new HashMap<>(); // upcasting map 이 부모 hashmap이 자식
		map.put("천재", new Student2());
		map.put("영재", new Student2());
		map.get("천재").name = "김천재";
		map.get("천재").department = "수학과";
		
		//Map에 ArrayList<Student> 넣기
		Map<String, ArrayList<Student>> map2 = new HashMap<>();
		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("김수학","통계학"));
		list2.add(new Student("최물리","물리학과"));
		map2.put("자연과학", list2);
		for (Student stemp : map2.get("자연과학")) {
			System.out.println(stemp.name);
			System.out.println(stemp.department);
		}
		
		Map<String, ArrayList<Student>> map3 = new HashMap<>();
		ArrayList<Student> listEngineering = new ArrayList<>();
		listEngineering.add(new Student("김컹공","컴퓨터공학과"));
		listEngineering.add(new Student("박화공","화학공학과"));
		
		map3.put("공과대학", listEngineering);
		
		for (Student stemp : map3.get("공과대학")) {
			System.out.println(stemp.name);
			System.out.println(stemp.department);
		}
		
		//ArrayList에 Map 넣기
		ArrayList<Map<String,ArrayList<Student>>> list3 = new ArrayList<>();
		list3.add(map2);
		list3.add(map3);
		
		for (Map<String, ArrayList<Student>> mapTemp : list3) {
		    for (Map.Entry<String, ArrayList<Student>> entry : mapTemp.entrySet()) {
		        String faculty = entry.getKey(); //key
		        ArrayList<Student> studentList = entry.getValue(); // value 

		        System.out.println("[" + faculty + "]"); //key 출력 단과대명
		        for (Student stemp : studentList) {
		            System.out.println("이름: " + stemp.name + ", 학과: " + stemp.department); // value 출력 
		        }
		        System.out.println(); // 줄바꿈
		    }
		}
	}
}
