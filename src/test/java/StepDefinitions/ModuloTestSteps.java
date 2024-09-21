package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class ModuloTestSteps {
    private Calculator calculator;
    private double result;
    private ArithmeticException thrownException;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
        thrownException = null;
    }

    @When("I calculate {int} modulo {int}")
    public void i_calculate_modulo(Integer a, Integer b) {
        result = calculator.modulo(a, b);
    }

    @When("I try to calculate {int} modulo {int}")
    public void i_try_to_calculate_modulo(Integer a, Integer b) {
        try {
            calculator.modulo(a, b);
        } catch (ArithmeticException e) {
            thrownException = e;
        }
    }

    @Then("the result should be {double}")
    public void the_result_should_be(Double expected) {
        assertEquals(expected, result, 0.0001);
    }

    @Then("it should throw an ArithmeticException with message {string}")
    public void it_should_throw_an_arithmetic_exception_with_message(String expectedMessage) {
        assertEquals(ArithmeticException.class, thrownException.getClass());
        assertEquals(expectedMessage, thrownException.getMessage());
    }
}
