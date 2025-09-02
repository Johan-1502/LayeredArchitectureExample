package services;

import java.util.ArrayList;

import dataAccess.models.Student;
import dataAccess.repositories.IRepository;
import dataAccess.repositories.StudentJsonRepository;

public class StudentService implements IService<Student>{
    private IRepository<Student> persistence;
    private ArrayList<Student> students;

    public StudentService(){
        persistence = new StudentJsonRepository("data/Persistence.Json");
        students = persistence.loadData();
        
    }

    public boolean add(Student student){
        for (Student studentAux : students) {
            if (studentAux.getIdentityDocument().equals(student.getIdentityDocument())) {
                return false;
            }
        }
        return students.add(student);
    }

    public boolean remove(String identityDocument){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getIdentityDocument().equals(identityDocument)) {
                    students.remove(i);
                    return true;
                }
        }
        return false;
    }

    public ArrayList<Student> getAll(){
        return students;
    }

    public void saveData(){
        persistence.saveData(students);
    }



}
