package persistence;

import java.util.ArrayList;

public interface IPersistence<T>{

    public ArrayList<T> loadData();
    public void writeFile(ArrayList<T> t);

}
