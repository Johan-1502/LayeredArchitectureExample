package presentation.view;

public interface IView {
    public String readString(String message);
    public int readMenu();
    public int readInt(String message);
    public void showMessage(String message);
    public void showErrorMessage(String message);
}
