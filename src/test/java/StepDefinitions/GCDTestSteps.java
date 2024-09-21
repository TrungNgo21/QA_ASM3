package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Calculator;

import javax.swing.*;

import static org.junit.Assert.assertEquals;


public class GCDTestSteps {
    private Calculator calculator;
    private Integer result;
    private Exception thrownException;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
        thrownException = null;
    }
    @When("I calculate the GCD of {long} and {long}")
    public void i_calculate_the_gcd_of_and(Long a, Long b) {
        result = calculator.gcd(a.intValue(), b.intValue());
    }


    @Then("the result should be {long}")
    public void the_result_should_be_long(Integer expected) {
        assertEquals(expected, result);
    }

    @Then("it should throw an {word} with message {string}")
    public void it_should_throw_an_exception_with_message(String exceptionType, String expectedMessage) {
        assertEquals(exceptionType, thrownException.getClass().getSimpleName());
        assertEquals(expectedMessage, thrownException.getMessage());
    }
}