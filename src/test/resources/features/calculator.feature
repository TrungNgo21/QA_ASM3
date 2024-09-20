Feature: Calculator Operations

  Scenario Outline: Basic arithmetic operations
    Given I have a calculator
    When I perform <operation> with <first> and <second>
    Then the result should be <result>

    Examples:
      | operation | first | second | result |
      | add       | 5     | 3      | 8      |
      | subtract  | 10    | 4      | 6      |
      | multiply  | 6     | 7      | 42     |
      | divide    | 15    | 3      | 5.0    |
      | modulo    | 17    | 5      | 2      |

  Scenario Outline: Power operation
    Given I have a calculator
    When I calculate <base> raised to the power of <exponent>
    Then the result should be <result>

    Examples:
      | base | exponent | result |
      | 2    | 3        | 8      |
      | 3    | 4        | 81     |
      | 5    | 0        | 1      |

  Scenario Outline: Advanced operations
    Given I have a calculator
    When I calculate the <operation> of <first> and <second>
    Then the result should be <result>

    Examples:
      | operation | first | second | result |
      | GCD       | 48    | 18     | 6      |
      | LCM       | 12    | 18     | 36     |

  Scenario Outline: Fibonacci sequence
    Given I have a calculator
    When I calculate the Fibonacci number at position <position>
    Then the result should be <result>

    Examples:
      | position | result |
      | 0        | 0      |
      | 1        | 1      |
      | 5        | 5      |
      | 10       | 55     |

  Scenario: Division by zero
    Given I have a calculator
    When I divide 10 by 0
    Then it should throw an ArithmeticException with the message "Division by zero is not allowed"

  Scenario: Modulo by zero
    Given I have a calculator
    When I calculate the modulo of 10 by 0
    Then it should throw an ArithmeticException with the message "Modulo by zero is not allowed"

  Scenario: Power with negative exponent
    Given I have a calculator
    When I calculate 2 raised to the power of -1
    Then it should throw an IllegalArgumentException with the message "Exponent must be non-negative"

  Scenario: Fibonacci with negative input
    Given I have a calculator
    When I calculate the Fibonacci number at position -1
    Then it should throw an IllegalArgumentException with the message "Input must be non-negative"