package StepDefinitions;

import io.cucumber.java.en.*;
import org.example.Calculator;

import static org.junit.Assert.*;

public class CalculatorTestSteps {
    private Calculator calculator;
    private int intResult;
    private double doubleResult;
    private long longResult;
    private Exception exception;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I perform {word} with {int} and {int}")
    public void i_perform_operation_with_and(String operation, int first, int second) {
        switch (operation) {
            case "add":
                intResult = calculator.add(first, second);
                break;
            case "subtract":
                intResult = calculator.subtract(first, second);
                break;
            case "multiply":
                intResult = calculator.multiply(first, second);
                break;
            case "divide":
                doubleResult = calculator.divide(first, second);
                break;
            case "modulo":
                intResult = calculator.modulo(first, second);
                break;
        }
    }

    @When("I calculate {int} raised to the power of {int}")
    public void i_calculate_raised_to_the_power_of(int base, int exponent) {
        try {
            longResult = calculator.power(base, exponent);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
    }

    @When("I calculate the {word} of {int} and {int}")
    public void i_calculate_the_of_and(String operation, int first, int second) {
        switch (operation) {
            case "GCD":
                intResult = calculator.gcd(first, second);
                break;
            case "LCM":
                intResult = calculator.lcm(first, second);
                break;
        }
    }

    @When("I calculate the Fibonacci number at position {int}")
    public void i_calculate_the_fibonacci_number_at_position(int position) {
        try {
            longResult = calculator.fibonacci(position);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
    }

    @When("I divide {int} by {int}")
    public void i_divide_by(int a, int b) {
        try {
            doubleResult = calculator.divide(a, b);
        } catch (ArithmeticException e) {
            exception = e;
        }
    }

    @When("I calculate the modulo of {int} by {int}")
    public void i_calculate_the_modulo_of_by(int a, int b) {
        try {
            intResult = calculator.modulo(a, b);
        } catch (ArithmeticException e) {
            exception = e;
        }
    }

    @Then("the result should be {int}")
    public void the_result_should_be_int(int expected) {
        assertEquals(expected, intResult);
    }

    @Then("the result should be {double}")
    public void the_result_should_be_double(double expected) {
        assertEquals(expected, doubleResult, 0.0001);
    }

    @Then("the result should be {long}")
    public void the_result_should_be_long(long expected) {
        assertEquals(expected, longResult);
    }

    @Then("it should throw an {word} with the message {string}")
    public void it_should_throw_an_exception_with_the_message(String exceptionType, String message) {
        assertNotNull(exception);
        assertEquals(exceptionType, exception.getClass().getSimpleName());
        assertEquals(message, exception.getMessage());
    }
}