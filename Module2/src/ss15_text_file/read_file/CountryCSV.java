package ss15_text_file.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryCSV {
    public List<Country> readFile(String filePath) {
        List<Country> list = new ArrayList<>();

        File file = new File(filePath);

        FileReader fileReader;
        BufferedReader br;
        String line;
        String[] array;
        try {
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                array = line.split(",");
                Country country = new Country(Integer.parseInt(array[0]), array[1], array[2]);
                list.add(country);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void writeFile(List<Country> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter bw;
        try {
            fileWriter = new FileWriter(file, append);
            bw = new BufferedWriter(fileWriter);
            for (Country country : list) {
                bw.write(country.getInfo());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Country> list = new ArrayList<>();
        list.add(new Country(1, "AU", "Australia"));
        list.add(new Country(2, "CN", "China"));
        list.add(new Country(3, "AU", "Australia"));
        list.add(new Country(4, "CN", "China"));
        list.add(new Country(5, "JP", "Japan"));
        list.add(new Country(6, "CN", "China"));
        list.add(new Country(7, "JP", "Japan"));
        list.add(new Country(8, "TH", "Thailand"));

        CountryCSV countryCSV = new CountryCSV();
        countryCSV.writeFile(list, "src/ss15_text_file/read_file/file.csv", false );
        List<Country> countryList = countryCSV.readFile("src/ss15_text_file/read_file/file.csv");
        for (Country country : countryList) {
            System.out.println(country);
        }

    }
}
