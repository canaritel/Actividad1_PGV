package procesosjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class LectorDePacientes {

    public static void main(String[] args) {

        InputStreamReader stream = new InputStreamReader(System.in, Charset.forName("UTF-8"));
        BufferedReader bffReader = new BufferedReader(stream);

        try {
            //BufferedWriter bw = new BufferedWriter(new FileWriter("20211011.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(args[0])));
            String line = "";

            do {
                line = bffReader.readLine();
                bw.write(line.toUpperCase());
                bw.newLine();
            } while (!line.isBlank());

            bw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
