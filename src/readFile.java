import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * @author - Grupo 7
 *         Maria José Villafuerte
 *         Fabiola Contreras
 *         Madeline Castro
 * 
 *         Codigo tomado de Hoja De Trabajo #2 y modificado para intérprete LISP
 *         Propósito: Leer el arhivo txt que tendrá las operaciones a realizar
 * @date 30/01/2023
 */

public class readFile {

  /**
   * Metodo que lee el documento con el código de LISP y guarda los datos
   * dentro de ArrayList
   * 
   * @param fpath Mensaje de lugar donde se encuentra el archivo datos.txt
   * @return data String
   */
  public static ArrayList<ArrayList<String>> _readfile(String fpath) {

    ArrayList<ArrayList<String>> total = new ArrayList<>();

    try {

      File myObj = new File(fpath);
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {

        ArrayList<String> data = special_function(myReader);
        total.add(data);

      }
      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return total;
  }

  /*
   * Permite reconocer cuando empieza y termina el uso de una función especial,
   * reconociendo sus paréntesis.
   * 
   * Además retorna el código de esa función a través de un arraylist, que luego
   * será interpretado.
   */
  public static ArrayList<String> special_function(Scanner scan) {

    Scanner sc = scan;
    int abre_parentesis = 0;
    int cierra_parentesis = 0;
    ArrayList<String> sf = new ArrayList<String>();

    do {
      String line = sc.nextLine();
      sf.add(line);
      String[] chars = line.split("");
      if (chars.equals("(")) {
        abre_parentesis += 1;
      } else if (chars.equals(")")) {
        cierra_parentesis += 1;
      } else {
        continue;
      }
    } while (abre_parentesis != cierra_parentesis);

    return sf;
  }

  public static ArrayList<String> split(ArrayList<String> lista, String delimitador) {
    ArrayList<String> subcadenas = new ArrayList<>();
    for (String cadena : lista) {
        String[] partes = cadena.split(delimitador);
        for (String parte : partes) {
            subcadenas.add(parte);
        }
    }
    return subcadenas;
  }
}
