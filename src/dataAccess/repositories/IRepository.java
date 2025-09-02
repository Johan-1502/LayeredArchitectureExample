package dataAccess.repositories;

import java.util.ArrayList;

public interface IRepository<T>{

    public ArrayList<T> loadData();
    public void saveData(ArrayList<T> t);

}
