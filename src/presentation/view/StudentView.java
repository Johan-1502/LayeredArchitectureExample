package presentation.view;

import java.util.Scanner;

public class StudentView implements IView{
    private Scanner scanner = new Scanner(System.in);

    public String readString(String message) {
        this.showMessage(message);
        String input = scanner.nextLine();
        while(input.isEmpty()){
            this.showErrorMessage(("No se permiten campos vacios\n"));
            this.showMessage(message);
            input = scanner.nextLine();
        }
        return input;
    }
    public int readMenu() {
        String menu = "--------------Menu--------------\n" +
                "1. Añadir estudiante \n" +
                "2. Eliminar estudiante \n" +
                "3. Mostrar estudiantes \n" +
                "4. Salir \n";
        return this.readPositiveInt(menu);
    }

    public int readPositiveInt(String message) {
        int input = readInt(message);
        while (input <= 0) {
            showErrorMessage("Debe ingresar un numero mayor a 0\n");
            input = readPositiveInt(message);
        }
        return input;
    }

    public int readInt(String message) {
        String input = readString(message);
        while (!input.matches("-?\\d+")) {
            showErrorMessage("Debe ingresar un numero\n");
            input = readString(message);
        }
        return Integer.parseInt(input);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    public void showErrorMessage(String message) {
        System.err.print(message);
    }
}

