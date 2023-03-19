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
  ArrayList<ArrayList<String>> total = new ArrayList<>();
  ArrayList<String> Parcial = new ArrayList<>();

  /**
   * Metodo que lee el documento con el código de LISP y guarda los datos
   * dentro de ArrayList
   * 
   * @param fpath Mensaje de lugar donde se encuentra el archivo datos.txt
   * @return data String
   */
  public ArrayList<ArrayList<String>> _readfile(String fpath) {

    try {

      File myObj = new File(fpath);
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        Parcial.add(data);
      }
      myReader.close();
      special_function(Parcial);

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
  public void special_function(ArrayList<String> code) {
    ArrayList<String> sf = new ArrayList<String>();

    for (String string : code) {
      if (string.isBlank()) {
        if (sf != null) {
          ArrayList<String> temporary = new ArrayList<>();
          temporary.addAll(sf);
          this.total.add(temporary);
          sf.clear();
        }
      } else {
        sf.add(string);
      }
    }
    if (sf != null) {
      ArrayList<String> temporary = new ArrayList<>();
      temporary.addAll(sf);
      this.total.add(temporary);
      sf.clear();
    }

  }

  /**
   * @param lista
   * @param delimitador
   * @return
   */
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
