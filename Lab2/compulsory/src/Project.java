


public class Project { /** Leonte Calin **/
    private String title;
    private Type type;

    public Project (String title, Type type)
    {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
