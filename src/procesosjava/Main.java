package procesosjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    /**
     * *** POR FAVOR INDIQUE EN PATH LA RUTA HACIA LA CARPETA CLASSES ***
     */
    static String PATH = "D:\\OpenBeansProjects\\Procesos_Cooperantes\\build\\classes";
    static String COMANDO = "procesosjava.LectorDePacientes";
    static String COMANDO2 = "procesosjava.IdentificadorDePacientes";

    public static void main(String[] args) {

        String FILE;

        Calendar calendar = new GregorianCalendar();

        int dia = calendar.get(Calendar.DATE);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int annio = calendar.get(Calendar.YEAR);
        String fecha = "" + annio + "" + mes + "" + dia;

        InputStreamReader stream = new InputStreamReader(System.in, Charset.forName("UTF-8"));
        BufferedReader bf = new BufferedReader(stream);

        System.out.println("****************************************************************************");
        System.out.println("***********************    PROCESOS COMPARTIDOS   **************************");
        System.out.println("****************************************************************************");
        System.out.println("\nIntroduzca una fecha para el fichero (pulse ENTER para coger la fecha actual)");

        String line = "";

        try {
            line = bf.readLine();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        if (line.isBlank()) {
            line = fecha;
        }

        System.out.println("Se creará un fichero con el nombre " + line);
        FILE = (line + ".txt");

        try {
            Thread.sleep(2000);

        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }

        lanzadorProceso1(FILE);
        lanzadorProceso2(FILE);

    }

    private static void lanzadorProceso1(String FILE) {

        String ENTER = "\n";
        String comando = COMANDO;
        File path = new File(PATH);

        InputStreamReader stream = new InputStreamReader(System.in, Charset.forName("UTF-8"));
        BufferedReader bf = new BufferedReader(stream);

        try {

            System.out.println("Ejecutando el PRIMER PROCESO...\n");
            Thread.sleep(3000);
            System.out.println("***********************************************");
            System.out.println("**********    INTRODUZCA LOS DNI  *************");
            System.out.println("***********************************************");
            System.out.println("      (Por ejemplo 1111A 2222B 3333C ...)  \n");

            ProcessBuilder processLector;
            processLector = new ProcessBuilder("java", comando, FILE);
            processLector.directory(path);
            processLector.redirectError(new File("erroresLector.txt"));
            Process process = processLector.start();
            OutputStream os = process.getOutputStream();

            String line = "";

            do {
                line = bf.readLine();
                os.write((line + ENTER).getBytes());
                os.flush();
                System.out.println("(Para SALIR pulse ENTER sin introducir datos )");

            } while (!line.isBlank());

            System.out.println("Guardando información en el fichero...\n");
            Thread.sleep(2000);

        } catch (IOException | InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void lanzadorProceso2(String FILE) {

        String comando2 = COMANDO2;
        File path = new File(PATH);

        InputStreamReader stream = new InputStreamReader(System.in, Charset.forName("UTF-8"));
        BufferedReader bf = new BufferedReader(stream);

        try {

            System.out.println("Ejecutando el SEGUNDO PROCESO...\n");
            Thread.sleep(3000);
            System.out.println("********************************************************");
            System.out.println("**********    IDENTIFICADOR DE PACIENTES   *************");
            System.out.println("********************************************************");
            System.out.println("\n");

            ProcessBuilder processIdentificador;
            processIdentificador = new ProcessBuilder("java", comando2, FILE);
            processIdentificador.directory(path);
            processIdentificador.redirectError(new File("erroresIdentificador.txt"));
            Process process = processIdentificador.start();
            process.waitFor();
            mostrarResultado(process);

        } catch (IOException | InterruptedException ex) {
            System.err.println("Error " + ex.getMessage());
        }
    }

    private static void mostrarResultado(Process process) {
        InputStream is = process.getInputStream();
        int letra = 0;
        try {
            while ((letra = is.read()) != -1) {
                System.out.print((char) letra);
            }
        } catch (IOException ex) {
            System.err.println("Error " + ex.getMessage());
        }

    }

}
