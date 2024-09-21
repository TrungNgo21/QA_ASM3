package StepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

public class CalculatorTestSteps {
  protected Calculator calculator;
  protected String result;
  protected Exception thrownException;

  @Given("I have a calculator")
  public void i_have_a_calculator() {
    calculator = new Calculator();
  }

  @When("I add {int} and {int}")
  public void i_add_and(Integer a, Integer b) {
    result = calculator.add(a, b);
  }

  @When("I add {string} and {string}")
  public void i_add_and(String a, String b) {
    try {
      result = calculator.add(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    }
  }

  @When("I subtract {int} from {int}")
  public void i_subtract_from(Integer b, Integer a) {
    result = calculator.subtract(a, b);
  }

  @When("I subtract {string} from {string}")
  public void i_subtract_from(String a, String b) {
    try {
      result = calculator.subtract(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    }
  }

  @When("I divide {int} by {int}")
  public void i_divide_by(Integer a, Integer b) {
    result = calculator.divide(a, b);
  }

  @When("I divide {string} by {string}")
  public void i_divide_by(String a, String b) {
    try {
      result = calculator.divide(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    } catch (ArithmeticException e) {
      thrownException = e;
    }
  }

  @When("I try to divide {int} by {int}")
  public void i_try_to_divide_by(Integer a, Integer b) {
    try {
      result = calculator.divide(a, b);
    } catch (ArithmeticException e) {
      thrownException = e;
    }
  }

  @When("I multiply {int} and {int}")
  public void i_multiply_and(Integer a, Integer b) {
    result = calculator.multiply(a, b);
  }

  @When("I multiply {string} and {string}")
  public void i_multiply_and(String a, String b) {
    try {
      result = calculator.multiply(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    }
  }

  @When("I calculate the Fibonacci number at position {int}")
  public void i_calculate_the_fibonacci_number_at_position(Integer position) {
    result = calculator.fibonacci(position);
  }

  @When("I calculate the Fibonacci number at position {string}")
  public void i_calculate_the_fibonacci_number_at_position(String position) {
    try {
      result = calculator.fibonacci(Integer.parseInt(position));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    } catch (Exception e) {
      thrownException = e;
    }
  }

  @When("I try to calculate the Fibonacci number at position {int}")
  public void i_try_to_calculate_the_fibonacci_number_at_position(Integer position) {
    try {
      result = calculator.fibonacci(position);
    } catch (Exception e) {
      thrownException = e;
    }
  }

  @When("I calculate the GCD of {long} and {long}")
  public void i_calculate_the_gcd_of_and(Long a, Long b) {
    result = calculator.gcd(a.intValue(), b.intValue());
  }

  @When("I calculate the GCD of {string} and {string}")
  public void i_calculate_the_gcd_of_and(String a, String b) {
    try {
      result = calculator.gcd(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    }
  }

  @When("I calculate the LCM of {int} and {int}")
  public void i_calculate_the_lcm_of_and(Integer a, Integer b) {
    result = calculator.lcm(a, b);
  }

  @When("I calculate the LCM of {string} and {string}")
  public void i_calculate_the_lcm_of_and(String a, String b) {
    try {
      result = calculator.lcm(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    }
  }

  @When("I calculate {int} modulo {int}")
  public void i_calculate_modulo(Integer a, Integer b) {
    result = calculator.modulo(a, b);
  }

  @When("I calculate {string} modulo {string}")
  public void i_calculate_modulo(String a, String b) {
    try {
      result = calculator.modulo(Integer.parseInt(a), Integer.parseInt(b));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    } catch (ArithmeticException e) {
      thrownException = e;
    }
  }

  @When("I try to calculate {int} modulo {int}")
  public void i_try_to_calculate_modulo(Integer a, Integer b) {
    try {
      result = calculator.modulo(a, b);
    } catch (ArithmeticException e) {
      thrownException = e;
    }
  }

  @When("I calculate {int} to the power of {int}")
  public void i_calculate_to_the_power_of(Integer base, Integer exponent) {
    result = calculator.power(base, exponent);
  }

  @When("I calculate {string} to the power of {string}")
  public void i_calculate_to_the_power_of(String base, String exponent) {
    try {
      result = calculator.power(Integer.parseInt(base), Integer.parseInt(exponent));
    } catch (NumberFormatException e) {
      thrownException = new NumberFormatException("Cannot calculate string value!");
    } catch (Exception e) {
      thrownException = e;
    }
  }

  @When("I try to calculate {int} to the power of {int}")
  public void i_try_to_calculate_to_the_power_of(Integer base, Integer exponent) {
    try {
      result = calculator.power(base, exponent);
    } catch (Exception e) {
      thrownException = e;
    }
  }

  @Then("the result should be {}")
  public void the_result_should_be(String expected) {
    assertEquals(expected, result);
  }

  @Then("it should throw an {word} with message {string}")
  public void it_should_throw_an_exception_with_message(String exceptionType, String expectedMessage) {
    assertEquals(exceptionType, thrownException.getClass().getSimpleName());
    assertEquals(expectedMessage, thrownException.getMessage());
  }
}
