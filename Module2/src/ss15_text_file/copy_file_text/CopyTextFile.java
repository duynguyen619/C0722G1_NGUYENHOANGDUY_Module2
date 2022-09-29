package ss15_text_file.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyTextFile {
    public List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader;
        BufferedReader br;
        String line;
        String[] array;
        int sum = 0;
        try {
            fileReader= new FileReader(file);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) !=null){
                array = line.split("");
                sum += array.length;
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Số kí tự trong tệp: " + sum);
        return list;
    }

    public void writeFile(List<String> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter bw;
        try {
            fileWriter = new FileWriter(file, append);
            bw = new BufferedWriter(fileWriter);
            for (String str : list) {
                bw.write(str);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyTextFile copyTextFile = new CopyTextFile();
        List<String> list = copyTextFile.readFile("src/ss15_text_file/copy_file_text/source.txt");
        copyTextFile.writeFile(list, "src/ss15_text_file/copy_file_text/target.txt",true);
    }
}
