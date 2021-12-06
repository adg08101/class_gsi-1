Feature: Google search

  Scenario Outline: Google search for animals
    Given User is on google page
    When User types for <animal>
    And User clicks on "Google Search" button
    Then The system browses for the animal

    Examples:
      | animal |
      | cat    |
      | dog    |

  Scenario Outline: Validating the url opened match with the search link
    Given User is on google page
    When User types for <animal>
    And User clicks on "Google Search" button
    And User clicks in any result items
    Then New URL should contains the link reference

    Examples:
      | animal |
      | cat    |