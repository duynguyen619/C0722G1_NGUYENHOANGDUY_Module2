package ss16_binary_file.copy_file;

import java.io.*;
import java.nio.file.Files;

public class CopyFile {
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        try (InputStream is = Files.newInputStream(source.toPath()); OutputStream os = Files.newOutputStream(dest.toPath())) {
            byte[] buffer = new byte[1024];
            int count = 0;
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                count += length;
            }
            System.out.println("Số byte trong tệp: " + count);
        }
    }

    public static void main(String[] args) {

        File sourceFile = new File("src/ss16_binary_file/copy_file/data.csv");
        File destFile = new File("src/ss16_binary_file/copy_file/data.csv");
        try {
            copyFileUsingStream(sourceFile, destFile);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
