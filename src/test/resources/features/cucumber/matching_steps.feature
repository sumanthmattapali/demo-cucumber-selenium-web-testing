Feature: Demo of matching possibilities

  Narrative:
  As a tester
  I want to know how "steps" and "steps definition" are related
  So that I can improve my Scenarios readebility.

  Scenario: One number argument
    Given I have 100 in my account
    When I request 1 pineapple
    Then it should be dispensed

  Scenario: Match plurals and synonyms
    Given I have 100 in my account
      # TODO: Use the same as  "I request 20 pineapple"
    When I demand 20 pineapples
    Then it should be dispensed

  Scenario: Two arguments
    Given I have 50 in my account
    # TODO: Use the same as  "I request 20 pineapple"
    When I demand 1 apple
    Then it should be dispensed


  Scenario: Match longer descriptions
    # TODO: Use the same as  "I have 100 in my account"
    Given I have 100 in my account, I'm almost without money!
    When I demand 1 pineapple
    Then should be dispensed

  # TODO: Use data table
  Scenario: Use data table
    Given I have 100 in my account
    When I demand
    | item | number |
    | pineapple | 2 |
    | apple | 1     |
    Then 20 should be dispensed

  # TODO: Use Scenario Outline:
  Scenario Outline: Use Scenario Outline
    Given I have <number1> in my account
    When I demand
      | item | number |
      | pineapple | 2 |
      | apple | 1     |
    Then <return1> should be dispensed

    Examples: table one digit
    | number1 | return1 |
    | 1       | 2       |
    | 2       | 3       |