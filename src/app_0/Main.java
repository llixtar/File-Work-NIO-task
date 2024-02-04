package app_0;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        findAllFiles(MyPaths.PATH_IN);

        System.out.println("""
                        
                1 - Відкрити існуючий файл
                2 - Створити новий
                """);

        fileProcess(Integer.parseInt(scanner.nextLine().trim()));
        scanner.close();
    }

    private static void findAllFiles(String path) {
        //ОТримання списку файлів в папці
        File folder = new File(path);

        File[] files = folder.listFiles();//Отримую список файлів
        assert files != null;
        if (files.length > 0) {
            System.out.println("\nФайли доступні для читання:");

            for (File file : files) {
                System.out.println(file.getName());
            }
        }

    }

    private static void fileProcess(int res) {
        if (res == 1 || res == 2) {
            System.out.println("Введіть назву файлу(без розширення):");
            String fileName = scanner.nextLine().trim();

            switch (res) {
                case 1:
                    System.out.println(new FileReadService().readFromFile(MyPaths.PATH_IN + fileName));
                    break;

                case 2:
                    System.out.println("Введіть текст:");
                    String txt = scanner.nextLine().trim();

                    System.out.println(new FileWriteService().writeFile(MyPaths.PATH_IN + fileName, txt));
                    break;
            }

        } else System.out.println("Наступного разу Ви зможете:)");
    }
}
