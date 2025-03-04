import java.util.Objects;

public class Project {
    private String title;
    private Type type;
    private Teacher proposer;

    public Project (String title, Type type)
    {
        this.type = type;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project project = (Project) obj;
        return Objects.equals(project.title, title) && Objects.equals(project.proposer, proposer);
    }
}
