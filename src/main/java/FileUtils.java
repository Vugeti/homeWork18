import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static File createFile(String name) throws IOException {
        File file = new File(name);
        file.createNewFile();

        return file;
    }

    public static File createFileInDir(String name, String dirName) throws IOException {
        File file = new File(dirName, name);
        file.createNewFile();

        return file;
    }

    public static boolean exist(String name) {
        File file = new File(name);
        return file.exists();
    }

    public static void delete(String name) {
        File file = new File(name);
        file.delete();
    }

    public static void writeToFile(String text, File file) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }

    public static List<String> read(File file) throws IOException {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            while (bufferedReader.ready()) {
                result.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


    //-----------------------------------------------------------------------------------------------------------------
    //Скопировать содержимое файла в новый файл
    public static File duplicateFile(String nameDuplicate, File file) throws IOException {
        File duplicateFile = new File(nameDuplicate);
        file.createNewFile();
        FileInputStream input = new FileInputStream(file);
        FileOutputStream output = new FileOutputStream(duplicateFile);
        while (input.available() > 0) {
            int data = input.read();
            output.write(data);
        }
        input.close();
        output.close();
        return file;
    }

    //Дописать строку в файл. (Добавить новую строку если файл не пустой)
    public static void addLine(String text, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(text);
        fileWriter.flush();
        fileWriter.close();
    }
    //Написать функцию которая по URL скачивает картинку из интернета и сохранят ее в корне проекта.
    public static boolean saveURL(String url,String fileName){
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(fileName));
            return true;
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Написать функцию которая по URL скачивает картинку из интернета и сохранят ее в корне проекта. побайтовое
    public static void downloadURL(String url,String fileName) {
        FileOutputStream fout = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new URL(url).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != 1) {
                fout.write(data, 0, count);
                fout.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

