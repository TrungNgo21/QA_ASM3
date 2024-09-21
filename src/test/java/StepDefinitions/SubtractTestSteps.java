package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class SubtractTestSteps {

    private Calculator calculator;
    private Integer result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I subtract {int} from {int}")
    public void i_subtract_from(Integer b, Integer a) {
        result = calculator.subtract(a, b);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer expected) {
        assertEquals(expected, result);
    }
}
