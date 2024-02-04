package app.view;

import java.util.Scanner;

public class AppView {
    private final Scanner scanner = new Scanner(System.in);

    public int choose() {
        String dataScaner;

        showText("""
                
                1 - Відкрити існуючий файл
                2 - Створити новий
                3 - Завершити роботу
                """);

        try {
            dataScaner = scanner.nextLine().trim();
        } catch (NumberFormatException e) {
            dataScaner = "1";
        }

        if(dataScaner == "3")
            scanner.close();

        return Integer.parseInt(dataScaner);

    }

    public String[] getWriteData() {

        showText("Введіть назву файлу якого бажаєте створити(без розширення):");
        String fileName = scanner.nextLine().trim() + ".txt";
        showText("Введіть текст:");
        String txt = scanner.nextLine().trim();
        scanner.close();
        return new String[]{fileName, txt};
    }

    public String getReadData() {
        String res;
        showText("Введіть назву файлу якого бажаєте прочитати(без розширення):");
        res = scanner.nextLine().trim() + ".txt";
        scanner.close();
        return res;
    }

    public void showText(String txt) {
        System.out.println(txt);
    }
}
