import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileClass {

    public static ArrayList<String> readFile(String path) {
        File file = new File(path);
       ArrayList<String> list = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                list.add( reader.nextLine() );
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void createFile(String path) {
        File file = new File((path));
        try {
            if (file.createNewFile()) {
                System.out.println(path.substring(56,72) + " dosyası oluştu");
            } else {
                Files.write(Paths.get(path),"".getBytes());  //dosyanın içindekileri siler
                System.out.println("Dosya zaten mevcut, dosya içeriği temizlendi");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String path,String s) {
        try {
            FileWriter file = new FileWriter(path,true);
            BufferedWriter writer = new BufferedWriter(file);
            writer.newLine();
            writer.write(s);
            System.out.println("dosyaya yazıldı");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
