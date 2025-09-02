package services;

import java.util.ArrayList;

public interface IService<T> {
    public boolean add(T t);
    public boolean remove(String identityDocument);  
    public ArrayList<T> getAll();  
    public void saveData();
} 
