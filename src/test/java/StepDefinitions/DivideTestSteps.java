package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;

public class DivideTestSteps extends SharedSteps{

    @When("I divide {int} by {int}")
    public void i_divide_by(Integer a, Integer b) {
        result = calculator.divide(a, b);
    }

    @When("I try to divide {int} by {int}")
    public void i_try_to_divide_by(Integer a, Integer b) {
        try {
            calculator.divide(a, b);
        } catch (ArithmeticException e) {
            thrownException = e;
        }
    }
}
