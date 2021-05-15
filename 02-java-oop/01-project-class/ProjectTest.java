public class ProjectTest {
    public static void main(String[] args) {
        Project p1 = new Project();
        p1.setName("First Project");
        p1.setDescription("My very first project");
        System.out.println(p1.elevatorPitch());

        Project p2 = new Project("Second Project");
        p2.setDescription("A second try");
        System.out.println(p2.elevatorPitch());

        Project p3 = new Project("Third Project", "This time it will work");
        System.out.println(p3.elevatorPitch());
    }
}