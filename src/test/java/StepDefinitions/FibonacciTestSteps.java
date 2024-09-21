package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class FibonacciTestSteps {
    private Calculator calculator;
    private Long result;
    private Exception thrownException;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
        thrownException = null;
    }


    @When("I calculate the Fibonacci number at position {int}")
    public void i_calculate_the_fibonacci_number_at_position(Integer position) {
        result = calculator.fibonacci(position);
    }

    @When("I try to calculate the Fibonacci number at position {int}")
    public void i_try_to_calculate_the_fibonacci_number_at_position(Integer position) {
        try {
            result = calculator.fibonacci(position);
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("the result should be {long}")
    public void the_result_should_be_long(Long expected) {
        assertEquals(expected, result);
    }

    @Then("it should throw an {word} with message {string}")
    public void it_should_throw_an_exception_with_message(String exceptionType, String expectedMessage) {
        assertEquals(exceptionType, thrownException.getClass().getSimpleName());
        assertEquals(expectedMessage, thrownException.getMessage());
    }
}
