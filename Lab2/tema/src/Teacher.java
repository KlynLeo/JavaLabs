public class Teacher extends Person {
    private Project[] proposedProjects;

    public Teacher(String name, Project[] projects) {
        super(name);
        proposedProjects = projects;
    }


}
