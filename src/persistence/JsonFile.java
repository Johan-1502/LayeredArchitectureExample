package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import models.Student;

public class JsonFile implements IPersistence<Student>{

    private JsonReader reader;
    private String path;

    public JsonFile(String fileName){
        this.path = fileName;
        try {
            reader = new JsonReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public ArrayList<Student> loadData() {
        Gson gson = new Gson();
        Student[] studentsAux = gson.fromJson(reader, Student[].class);
        ArrayList<Student> students = new ArrayList<>();
        if (studentsAux != null) {
            for (int i = 0; i < studentsAux.length; i++) {
                students.add(studentsAux[i]);
            }
        }
        return students;
    }

    public void writeFile(ArrayList<Student> students){
        Gson gson = new Gson();
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.write(gson.toJson(students));
            writer.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
