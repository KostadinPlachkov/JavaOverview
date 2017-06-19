import java.io.*;

/**
 * Created by Kostadin on 19-Jun-17.
 */
public class FilesAndDirectories {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                fileOutputStream.write(oneByte);
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
