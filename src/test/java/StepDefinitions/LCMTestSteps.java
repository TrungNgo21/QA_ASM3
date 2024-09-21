package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class LCMTestSteps {
    private Calculator calculator;
    private Long result;
    private Exception thrownException;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
        thrownException = null;
    }

    @When("I calculate the LCM of {int} and {int}")
    public void i_calculate_the_lcm_of_and(Integer a, Integer b) {
        result = (long) calculator.lcm(a, b);
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

