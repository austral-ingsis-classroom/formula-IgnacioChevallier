package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.operations.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Addition(new Number(1.0), new Number(6.0));
    final List<String> result = function.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Division(new Number(12.0), new Variable("div"));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function = new Division(new Number(9.0), new Variable("x"));
    Function function2 = new Multiplication(function, new Variable("y"));
    final List<String> result = function2.getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function = new Division(new Number(27.0), new Variable("a"));
    Function function2 = new Power(function, new Variable("b"));
    final List<String> result = function2.getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function = new Division(new Number(1.0), new Number(2.0));
    Function function2 = new Power(new Variable("z"), function);
    final List<String> result = function2.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Subtraction(new Modulo(new Variable("value")), new Number(8.0));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new Subtraction(new Modulo(new Variable("value")), new Number(8.0));
    final List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function = new Subtraction(new Number(5.0), new Variable("i"));
    Function function2 = new Multiplication(function, new Number(8.0));
    final List<String> result = function2.getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
