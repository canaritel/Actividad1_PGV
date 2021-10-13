package procesosjava;

import java.util.ArrayList;
import java.util.Objects;

public class Ciudadano {

    String dni;
    String nombre;
    String apellidos;
    int edad;
    String direccion;
    String comun_autonoma;

    public Ciudadano() {
    }

    public Ciudadano(String dni, String nombre, String apellidos, int edad, String direccion, String comun_autonoma) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.comun_autonoma = comun_autonoma;
    }

    @Override
    public String toString() {
        return dni + " " + nombre + " " + apellidos + " " + edad + " " + direccion + " " + comun_autonoma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ciudadano other = (Ciudadano) obj;
        return true;
    }

    public ArrayList listado_ciudadanos() {
        ArrayList<Ciudadano> array_ciudadanos = new ArrayList();

        Ciudadano user1 = new Ciudadano("1111A", "NOMBRE 1", "APELLIDOS 1", 11, "DIRECCIÓN 1", "COMUNIDAD CANARIA");
        Ciudadano user2 = new Ciudadano("2222B", "NOMBRE 2", "APELLIDOS 2", 22, "DIRECCIÓN 2", "COMUNIDAD CANARIA");
        Ciudadano user3 = new Ciudadano("3333C", "NOMBRE 3", "APELLIDOS 3", 33, "DIRECCIÓN 3", "COMUNIDAD CANARIA");
        Ciudadano user4 = new Ciudadano("4444D", "NOMBRE 4", "APELLIDOS 4", 44, "DIRECCIÓN 4", "COMUNIDAD CANARIA");
        Ciudadano user5 = new Ciudadano("5555E", "NOMBRE 5", "APELLIDOS 5", 55, "DIRECCIÓN 5", "COMUNIDAD CANARIA");
        Ciudadano user6 = new Ciudadano("6666F", "NOMBRE 6", "APELLIDOS 6", 66, "DIRECCIÓN 6", "COMUNIDAD CANARIA");
        Ciudadano user7 = new Ciudadano("7777G", "NOMBRE 7", "APELLIDOS 7", 55, "DIRECCIÓN 7", "COMUNIDAD CANARIA");

        array_ciudadanos.add(user1);
        array_ciudadanos.add(user2);
        array_ciudadanos.add(user3);
        array_ciudadanos.add(user4);
        array_ciudadanos.add(user5);
        array_ciudadanos.add(user6);
        array_ciudadanos.add(user7);

        return (ArrayList) array_ciudadanos;
    }

}
