import presentation.Controller.StudentController;
import presentation.view.StudentView;
import services.StudentService;

public class App {
    public static void main(String[] args) {
        new StudentController(new StudentService(), new StudentView()).run();;
    }
}
