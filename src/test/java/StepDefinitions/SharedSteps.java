package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class SharedSteps {
    protected Calculator calculator;
    protected Number result;
    protected Exception thrownException;


    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @Then("the result should be {}")
    public void the_result_should_be(Number expected) {
        if (expected instanceof Double || result instanceof Double) {
            assertEquals(expected.doubleValue(), result.doubleValue(), 0.001);
        } else {
            assertEquals(expected.longValue(), result.longValue());
        }
    }

    @Then("it should throw an ArithmeticException with message {string}")
    public void it_should_throw_an_arithmetic_exception_with_message(String expectedMessage) {
        assertEquals(ArithmeticException.class, thrownException.getClass());
        assertEquals(expectedMessage, thrownException.getMessage());
    }
}