package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function function = new Addition(new Number(1.0), new Variable("x"));
    final Double result = function.evaluate(Map.of("x", 3d));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function function = new Division(new Number(12.0), new Variable("div"));
    final Double result = function.evaluate(Map.of("div", 4d));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function function = new Division(new Number(9.0), new Variable("x"));
    Function function2 = new Multiplication(function, new Variable("y"));
    final Map<String, Double> map = Map.of("x", 3d, "y", 4d);
    final Double result = function2.evaluate(map);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function function = new Division(new Number(27.0), new Variable("a"));
    Function function2 = new Power(function, new Variable("b"));
    final Map<String, Double> map = Map.of("a", 9d, "b", 3d);
    final Double result = function2.evaluate(map);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function function =
        new Power(new Variable("z"), new Division(new Number(1.0), new Number(2.0)));
    final Map<String, Double> map = Map.of("z", 36d);
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function function = new Subtraction(new Modulo(new Variable("value")), new Number(8.0));
    final Map<String, Double> map = Map.of("value", 8d);
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function function = new Subtraction(new Modulo(new Variable("value")), new Number(8.0));
    final Map<String, Double> map = Map.of("value", 8d);
    final Double result = function.evaluate(map);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function function = new Subtraction(new Number(5.0), new Variable("i"));
    Function function2 = new Multiplication(function, new Number(8.0));
    final Map<String, Double> map = Map.of("i", 2d);
    final Double result = function2.evaluate(map);

    assertThat(result, equalTo(24d));
  }
}
