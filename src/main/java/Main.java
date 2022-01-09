import streamapi.StreamApi;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //С помощью кода создать директорию output
        try {
            String name = "output";
//            DirUtils.createDirectory(name);

            //В ней создать файл result.csv
            FileUtils.createFileInDir("result.csv", name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception message " + e.getMessage());
        }
        //В файл записать людей из предыдущей домашке в формате csv:
        try {
            PrintWriter printWriter = new PrintWriter(new File("C://Users/Vugeti/IdeaProjects/homeWork18/output/result.csv"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(StreamApi.peoples());
            printWriter.write(stringBuilder.toString());
            printWriter.close();
            System.out.println("finished");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Скопировать содержимое файла в новый файл
        File duplicateFile = new File("C://Users/Vugeti/IdeaProjects/homeWork18/newDirectory/newTextFile");
        try {
            FileUtils.duplicateFile("duplicateFile", duplicateFile);
            System.out.println(FileUtils.read(duplicateFile));
            FileUtils.delete("duplicateFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


