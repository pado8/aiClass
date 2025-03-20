import java.util.ArrayList;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
