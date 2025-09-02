package dataAccess.repositories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import dataAccess.models.Student;

public class StudentJsonRepository implements IRepository<Student>{

    private String path;

    public StudentJsonRepository(String path){
        this.path = path;
    }
    
    public ArrayList<Student> loadData() {
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new FileReader(this.path))) {
            Student[] studentsAux = gson.fromJson(reader, Student[].class);
            ArrayList<Student> students = new ArrayList<>();
            if (studentsAux != null) {
                Collections.addAll(students, studentsAux);
            }
            return students;
        } catch (IOException e) {
            throw new RuntimeException("Error al leer archivo: " + path, e);
        }
    }

    public void saveData(ArrayList<Student> students){
        Gson gson = new Gson();
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.write(gson.toJson(students));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado: " + path, e);
        }
    }
}
