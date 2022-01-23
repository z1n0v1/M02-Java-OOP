import java.util.HashMap;

public class StudentsRepository {
    private final HashMap<String, Student> students;

    public StudentsRepository() {
        students = new HashMap<>();
    }

    public void add(Student student) {
        if (!students.containsKey(student.getName()))
            students.put(student.getName(), student);
    }

    public Student get(String name) {
        if (students.containsKey(name))
            return students.get(name);
        return null;
    }
}
