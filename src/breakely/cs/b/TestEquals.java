package breakely.cs.b;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestEquals {
    public static void main(String[] args) {
        Student s1 = new Student("M",1);
        Student s2 = new Student("M",1);
        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());
    }


}

class Student{
    private String name;
    private int age;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
