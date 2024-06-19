package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.*;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function function = new Addition(new Number(1.0), new Number(6.0));
    final Double result = function.evaluate(null);
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function function = new Division(new Number(12.0), new Number(2.0));
    final Double result = function.evaluate(null);
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function function = new Division(new Number(9.0), new Number(2.0));
    Function function2 = new Multiplication(function, new Number(3.0));
    final Double result = function2.evaluate(null);

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function function = new Division(new Number(27.0), new Number(6.0));
    Function function2 = new Power(function, new Number(2.0));
    final Double result = function2.evaluate(null);

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function function = new Division(new Number(1.0), new Number(2.0));
    Function function2 = new Power(new Number(36.0), function);
    final Double result = function2.evaluate(null);

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function function = new Modulo(new Number(136.0));
    final Double result = function.evaluate(null);

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function function = new Modulo(new Number(-136.0));
    final Double result = function.evaluate(null);

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function function = new Subtraction(new Number(5.0), new Number(5.0));
    Function function2 = new Multiplication(function, new Number(8.0));
    final Double result = function2.evaluate(null);

    assertThat(result, equalTo(0d));
  }
}
