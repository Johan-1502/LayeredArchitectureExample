package presentation.Controller;

import java.util.ArrayList;

import models.Student;
import presentation.view.IView;
import presentation.view.StudentView;
import services.IService;
import services.StudentService;

public class StudentController implements IController{
    private IService<Student> service;
    private IView view;

    public StudentController(IService<Student> service, IView view){
        this.service = service;
        this.view = view;
    }

    public void run(){
        int option = 0;
        do {
            option = view.readMenu();
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    showStudents();
                    break;
                case 4:
                    view.showMessage("Esperamos vuelva pronto");
                    service.saveData();
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }

    private void addStudent(){
        String firstName = view.readString("Ingrese el nombre del estudiante");
        String lastName = view.readString("Ingrese el apellido del estudiante");
        String identityDocument = view.readString("Ingrese el documento de identidad del estudiante");
        if (service.add(new Student(firstName, lastName, identityDocument))) {
            view.showMessage("Estudiante añadido correctamente");
        }else{
            view.showErrorMessage("Ya existe un estudiante con ese documento de identidad");
        }
    }
    
    private void removeStudent(){
        String identityDocument = view.readString("Ingrese el documento de identidad del estudiante");
        if (service.remove(identityDocument)) {
            view.showMessage("Estudiante eliminado correctamente");
        }else{
            view.showErrorMessage("No existe un estudiante con ese documento de identidad\n");
        }
    }

    private void showStudents(){
        ArrayList<Student> students = service.getAll();
        if (students.size() == 0) {
            view.showMessage("No hay estudiantes registrados");
        }else{
            for (int i = 0; i < students.size(); i++) {
                view.showMessage(students.get(i).toString());
            }
        }
    }

    public static void main(String[] args) {
        new StudentController(new StudentService(), new StudentView()).run();;
    }
    
}
