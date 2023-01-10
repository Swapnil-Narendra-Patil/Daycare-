package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ConversionUtil {
    
    public static void writingCSVFile(List<String> input, String name) {
        try {

            File file = new File(name);
            file.createNewFile();
            BufferedWriter o = new BufferedWriter(new FileWriter(file));
            for(String string:input) {
                o.write(string);
                o.write("\r\n");
            }
            o.flush();
            o.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<String> readingCSVFile(String name) {
        List<String> stringList = new ArrayList<>();
        try {
          
            BufferedReader  br = new BufferedReader(new FileReader(name));
            String inputLine = null; 
            while ((inputLine = br.readLine()) != null) {    
                stringList.add(inputLine);
            }

        }catch (IOException e) {
            
            e.printStackTrace();

        }
        return stringList;

    }

}

