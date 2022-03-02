package Contolador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase encargada de la lectura escritura y procesamiento de los archivos
 * previa a la creacion de las entidades
 */
public class Archivo {
    /**
     * Lee el archivo y separa cada una de sus lineas, crea una lista
     * con las propiedades de cada elemento
     * @param direccion
     * @return ArrayList<String[]>
     */
    public static ArrayList<String[]> leerArchivo (String direccion){
        ArrayList<String[]> datos = new ArrayList<String[]>();
        String[] valores ={};
        File doc = new File(direccion);
        Scanner obj = null;
        try {
            obj = new Scanner(doc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (obj.hasNextLine()) {
            valores = obj.nextLine().split(",");
            datos.add(valores);
        }
        return datos;
    }
}
