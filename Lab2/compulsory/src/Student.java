import java.util.Arrays;

public class Student {
    private String name;
    private Project[] availableProjects;

    public Student (String name, Project[] projects)
    {
        availableProjects = projects;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project[] getAvailableProjects() {
        return availableProjects;
    }

    public void setAvailableProjects(Project[] availableProjects) {
        this.availableProjects = availableProjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", availableProjects=" + Arrays.toString(availableProjects) +
                '}';
    }
}
