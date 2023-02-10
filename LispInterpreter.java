import java.util.ArrayList;

public class LispInterpreter {
  public static Object eval(ArrayList<Object> list) {
    if (list.size() == 0) {
      return null;
    }

    Object firstElement = list.get(0);
    ArrayList<Object> restOfList = new ArrayList<>(list.subList(1, list.size()));

    if (firstElement.equals("+")) {
      return sum(restOfList);
    } else if (firstElement.equals("*")) {
      return multiply(restOfList);
    } else if (firstElement.equals("-")) {
      return subtract(restOfList);
    } else if (firstElement instanceof ArrayList) {
      return eval((ArrayList<Object>) firstElement);
    } else {
      return firstElement;
    }
  }

  private static Object sum(ArrayList<Object> list) {
    int sum = 0;
    for (Object obj : list) {
      sum += (int) eval(new ArrayList<>(List.of(obj)));
    }
    return sum;
  }

  private static Object multiply(ArrayList<Object> list) {
    int product = 1;
    for (Object obj : list) {
      product *= (int) eval(new ArrayList<>(List.of(obj)));
    }
    return product;
  }

  private static Object subtract(ArrayList<Object> list) {
    int result = (int) eval(new ArrayList<>(List.of(list.get(0))));
    for (int i = 1; i < list.size(); i++) {
      result -= (int) eval(new ArrayList<>(List.of(list.get(i))));
    }
    return result;
  }
}
