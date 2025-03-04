import java.util.Date;
import java.util.Objects;

public class Person {
    protected String name;
    protected Date birthDate;

    public Person (String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(birthDate, person.birthDate);
    }
}
