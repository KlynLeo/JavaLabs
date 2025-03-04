import java.util.Arrays;

public class Student extends Person{
    private Project[] availableProjects;
    private int regNumber;

    public Student (String name, Project[] projects)
    {
        super(name);
        availableProjects = projects;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        Student student = (Student) obj;
        return regNumber == student.regNumber;
    }
}

