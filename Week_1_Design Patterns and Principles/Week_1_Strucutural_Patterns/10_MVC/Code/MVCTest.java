public class MVCTest {
    public static void main(String[] args) {
        // Model
        Student student = new Student("John Doe", 101, "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // Display student info
        controller.updateView();

        // Modify student data
        System.out.println("-- Updating student grade to B --");
        controller.setStudentGrade("B");

        // Display updated info
        controller.updateView();
    }
}
