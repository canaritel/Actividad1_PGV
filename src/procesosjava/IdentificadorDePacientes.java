package procesosjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IdentificadorDePacientes {

    static ArrayList<Ciudadano> lista_ciudadano = new ArrayList();
    static Ciudadano ciudadano = new Ciudadano();

    private static void mostrarDatos(String line) {
        for (int i = 0; i < lista_ciudadano.size(); i++) {
            if (lista_ciudadano.get(i).dni.equalsIgnoreCase(line)) {
                System.out.println(lista_ciudadano.get(i).toString());
            }
        }
    }

    synchronized public static void main(String[] args) {

        String linea = args[0];
        //String linea ="3333C";

        //creamos una lista de ciudadanos con los datos completos de cada ciudadano
        lista_ciudadano = ciudadano.listado_ciudadanos();

        File path = new File(Main.PATH);
        FileReader fr;
        try {
            fr = new FileReader(path + "\\" + linea);
            BufferedReader br = new BufferedReader(fr);

            lista_ciudadano = ciudadano.listado_ciudadanos();
            String line = "";

            while ((line = br.readLine()) != null) {
                mostrarDatos(line);
            }

            br.close();

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
