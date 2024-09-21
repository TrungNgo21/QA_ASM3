//package StepDefinitions;
//
//import io.cucumber.java.en.*;
//import org.example.Calculator;
//
//import static org.junit.Assert.*;
//
//public class CalculatorTestSteps {
//    private Calculator calculator;
//    private Integer intResult;
//
//    private Long longResult;
//    private double result;
//    private Exception thrownException;
//
//    @Given("I have a calculator")
//    public void i_have_a_calculator() {
//        calculator = new Calculator();
//        thrownException = null;
//    }
//
//    @When("I add {int} and {int}")
//    public void i_add_and(Integer a, Integer b) {
//        intResult = calculator.add(a, b);
//    }
//
//    @When("I subtract {int} from {int}")
//    public void i_subtract_from(Integer b, Integer a) {
//        intResult = calculator.subtract(a, b);
//    }
//
//    @When("I multiply {int} and {int}")
//    public void i_multiply_and(Integer a, Integer b) {
//        intResult = calculator.multiply(a, b);
//    }
//
//    @When("I divide {int} by {int}")
//    public void i_divide_by(Integer a, Integer b) {
//        result = calculator.divide(a, b);
//    }
//
//    @When("I try to divide {int} by {int}")
//    public void i_try_to_divide_by(Integer a, Integer b) {
//        try {
//            calculator.divide(a, b);
//        } catch (ArithmeticException e) {
//            thrownException = e;
//        }
//    }
//
//    @When("I calculate {int} modulo {int}")
//    public void i_calculate_modulo(Integer a, Integer b) {
//        result = calculator.modulo(a, b);
//    }
//
//    @When("I try to calculate {int} modulo {int}")
//    public void i_try_to_calculate_modulo(Integer a, Integer b) {
//        try {
//            calculator.modulo(a, b);
//        } catch (ArithmeticException e) {
//            thrownException = e;
//        }
//    }
//
//    @When("I calculate {int} to the power of {int}")
//    public void i_calculate_to_the_power_of(Integer base, Integer exponent) {
//        longResult = calculator.power(base, exponent);
//    }
//
//    @When("I try to calculate {int} to the power of {int}")
//    public void i_try_to_calculate_to_the_power_of(Integer base, Integer exponent) {
//        try {
//            calculator.power(base, exponent);
//        } catch (Exception e) {
//            thrownException = e;
//        }
//    }
//
//    @When("I calculate the GCD of {int} and {int}")
//    public void i_calculate_the_gcd_of_and(Integer a, Integer b) {
//        intResult = calculator.gcd(a, b);
//    }
//
//    @When("I calculate the LCM of {int} and {int}")
//    public void i_calculate_the_lcm_of_and(Integer a, Integer b) {
//        intResult = calculator.lcm(a, b);
//    }
//
//
//    @When("I calculate the Fibonacci number at position {int}")
//    public void i_calculate_the_fibonacci_number_at_position(Integer position) {
//        longResult = calculator.fibonacci(position);
//    }
//
//    @When("I try to calculate the Fibonacci number at position {int}")
//    public void i_try_to_calculate_the_fibonacci_number_at_position(Integer position) {
//        try {
//            longResult = calculator.fibonacci(position);
//        } catch (Exception e) {
//            thrownException = e;
//        }
//    }
//
//    @Then("the result should be {long}")
//    public void the_result_should_be(Long expected) {
//        assertEquals(expected, longResult);
//    }
//
//
////    @Then("the result should be {int}")
////    public void the_result_should_be_int(Integer expected) {
////        assertEquals(expected, intResult);
////    }
////
////    @Then("the result should be {double}")
////    public void the_result_should_be_double(Double expected) {
////        assertEquals(expected, result, 0.0001);
////    }
//
//    @Then("it should throw an {word} with message {string}")
//    public void it_should_throw_an_exception_with_message(String exceptionType, String expectedMessage) {
//        assertEquals(exceptionType, thrownException.getClass().getSimpleName());
//        assertEquals(expectedMessage, thrownException.getMessage());
//    }
//}