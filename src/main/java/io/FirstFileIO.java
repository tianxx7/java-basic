package io;

import org.junit.Test;

import java.io.*;

/**
 * @author labvi
 * @version 1.0.0
 */
public class FirstFileIO {

    /*
    * 合并两个文件
    * */
    @Test
    public void mergeFile() throws IOException {
        String file_a = "/A.txt";
        String file_b = "/B.txt";

        InputStream a_file = this.getClass().getResourceAsStream(file_a);
        InputStream b_file = this.getClass().getResourceAsStream(file_b);
        InputStreamReader reader_a = new InputStreamReader(a_file);
        BufferedReader a_reader = new BufferedReader(reader_a);
        InputStreamReader reader_b = new InputStreamReader(b_file);
        BufferedReader b_reader = new BufferedReader(reader_b);

        File file = new File("C.txt");

        FileWriter fileWriter = new FileWriter(file);
        String a = null;
        String b = null;
        while ( (a = a_reader.readLine()) != null && (b = b_reader.readLine()) != null){
            fileWriter.write(a+ " " + b + "\n");
        }

        if (b != null) {
            do{
                fileWriter.write("  " + b + "\n");
            } while ((b = b_reader.readLine()) != null);
        }
        if (a != null) {
            do {
                fileWriter.write(a+ " " + "\n");
            }
            while ((a = a_reader.readLine()) !=null );
        }

        a_reader.close();
        b_reader.close();
        fileWriter.close();
    }
}
