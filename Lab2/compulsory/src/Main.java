enum Type{
    theoretical, practical
}

public class Main { /** Leonte Calin **/
    public static void main(String[] args) {
        Project p1 = new Project("QuizzGame", Type.theoretical);
        Project p2 = new Project("Championship", Type.practical);
        Project p3 = new Project("TrainsApp", Type.theoretical);
        Project p4 = new Project("DerivateCalculator", Type.practical);

        Student s1 = new Student("Niko", new Project[]{p1, p2});
        Student s2 = new Student("cadiaN", new Project[]{p3, p4});
        Student s3 = new Student("Jimmy", new Project[]{p2, p3, p4});
        Student s4 = new Student("Mzinho", new Project[]{p2});

        System.out.println(p1);
        System.out.println(s1);

    }
}