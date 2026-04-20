import java.io.*;
import java.util.*;

public class FileHelper {

    public static void write(String file, String data) {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(data + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error tulis file");
        }
    }

    public static List<String> read(String file) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error baca file");
        }
        return list;
    }

    public static void rewrite(String file, List<String> data) {
        try {
            FileWriter fw = new FileWriter(file);
            for (String d : data) {
                fw.write(d + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error rewrite file");
        }
    }
}