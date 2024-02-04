package app.controler;

import app.utils.Paths;
import app.model.AppWriteFileModel;
import app.model.AppReadFileModel;
import app.view.AppView;

import java.io.File;

public class AppControler {
    public static void runApp() {
        String strPath = Paths.PATH_IN;

        AppView view = new AppView();
        AppWriteFileModel appWriteFileModel = new AppWriteFileModel();
        AppReadFileModel appReadFileModel = new AppReadFileModel();


        view.showText(findAllFiles(strPath));

        int res = view.choose();

        switch (res) {

            case 2:
                String[] data = view.getWriteData();
                strPath += data[0];
                view.showText(appWriteFileModel.writeFile(strPath, data[1]));
                break;
            case 1:
                strPath += view.getReadData();
                view.showText(appReadFileModel.readFromFile(strPath));
                break;
        }
    }

    private static String findAllFiles(String path) {
        //ОТримання списку файлів в папці
        File folder = new File(path);

        File[] files = folder.listFiles();//Отримую список файлів

        String strReturn = "";
        try {
            assert files != null;
            if (files.length > 0) {
                StringBuilder res = new StringBuilder("\nФайли доступні для читання:");

                for (File file : files) {
                    res.append("\n").append(file.getName());
                }

                strReturn = res.toString();
            }
        } catch (NullPointerException e) {
            strReturn = "";
        }
        return  strReturn;
    }
}
