package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class PowerTestSteps {
    private Calculator calculator;
    private Long result;
    private Exception thrownException;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
        thrownException = null;
    }

    @When("I calculate {int} to the power of {int}")
    public void i_calculate_to_the_power_of(Integer base, Integer exponent) {
        result = calculator.power(base, exponent);
    }

    @When("I try to calculate {int} to the power of {int}")
    public void i_try_to_calculate_to_the_power_of(Integer base, Integer exponent) {
        try {
            calculator.power(base, exponent);
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
