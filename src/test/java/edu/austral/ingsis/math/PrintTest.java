package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    Function function = new Addition(new Number(1.0), new Number(6.0));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    Function function = new Division(new Number(12.0), new Number(2.0));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    Function function = new Division(new Number(9.0), new Number(2.0));
    Function function2 = new Multiplication(function, new Number(3.0));
    final String result = function2.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    Function function = new Division(new Number(27.0), new Number(6.0));
    Function function2 = new Power(function, new Number(2.0));
    final String result = function2.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final String result = expected;

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    Function function = new Subtraction(new Modulo(new Variable("value")), new Number(8.0));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    Function function = new Subtraction(new Number(5.0), new Variable("i"));
    Function function2 = new Multiplication(function, new Number(8.0));
    final String result = function2.toString();

    assertThat(result, equalTo(expected));
  }
}
