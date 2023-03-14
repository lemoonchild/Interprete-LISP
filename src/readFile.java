package src;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * @author - Grupo 7 HDT2
 *         Maria José Villafuerte
 *         Fabiola Contreras
 *         Madeline Castro
 * 
 *         Codigo tomado de Hoja De Trabajo #2
 *         Propósito: Leer el arhivo txt que tendrá las operaciones a realizar
 * @date 30/01/2023
 */

public class readFile {

  /**
   * Metodo que lee el documento con las operaciones Postfix y guarda los datos
   * dentro de ArrayList
   * 
   * @param fpath Mensaje de lugar donde se encuentra el archivo datos.txt
   * @return data String
   */
  public static ArrayList<String> _readfile(String fpath) {

    String data = "";
    ArrayList<String> total = new ArrayList<>();

    try {

      File myObj = new File(fpath);
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {

        data = myReader.nextLine();
        total.add(data);

      }
      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return total;
  }
}
