package edu.austral.ingsis.math;

public class Utility {
  public static boolean containsOperand(String string) {
    char[] operations = {'+', '-', '^', '/', '*'};
    for (char c : string.toCharArray()) {
      for (char operation : operations) {
        if (c == operation) {
          return true;
        }
      }
    }
    return false;
  }

  public static String formatNumber(double number) {
    if (number == (long) number) return String.format("%d", (long) number);
    else return String.format("%s", number);
  }

  public static String getString(Function num1, Function num2, String operation) {
    if (num1 instanceof Number && num2 instanceof Number) {
      if (Utility.containsOperand(num1.toString())) {
        return "(" + num1.toString() + ") " + operation + " " + formatNumber(num2.evaluate(null));
      } else if (Utility.containsOperand(num2.toString())) {
        return formatNumber(num1.evaluate(null)) + " " + operation + "(" + num2.toString() + ")";
      }
      return formatNumber(num1.evaluate(null))
          + " "
          + operation
          + " "
          + formatNumber(num2.evaluate(null));
    } else if (num1 instanceof Number) {
      if (Utility.containsOperand(num1.toString())) {
        return "(" + formatNumber(num1.evaluate(null)) + ") " + operation + " " + num2.toString();
      } else if (Utility.containsOperand(num2.toString())) {
        return formatNumber(num1.evaluate(null)) + " " + operation + " (" + num2.toString() + ")";
      }
      return formatNumber(num1.evaluate(null)) + " " + operation + " " + num2.toString();
    } else if (num2 instanceof Number) {
      if (Utility.containsOperand(num1.toString())) {
        return "(" + num1.toString() + ") " + operation + " " + formatNumber(num2.evaluate(null));
      } else if (Utility.containsOperand(num2.toString())) {
        return num1.toString() + " " + operation + " (" + formatNumber(num2.evaluate(null)) + ")";
      }
      return num1.toString() + " " + operation + " " + formatNumber(num2.evaluate(null));
    }
    return num1.toString() + " " + operation + " " + num2.toString();
  }
}
