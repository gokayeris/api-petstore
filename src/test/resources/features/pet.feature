@pet
Feature: Pet

  @createPet @deletePet
  Scenario: Create a pet
    Given I want to create a pet with following details:
      | id | name   | status    |
      | 35 | doggie | available |

    When I do post request to create a pet

    Then verify that the status code is 200
    And verify that the response body for pet is like:
      | id | name   | status    |
      | 35 | doggie | available |

  @getPet @deletePet
  Scenario: Get a pet and verify schema
    Given I have a pet with following details:
      | id | name   | status    |
      | 35 | doggie | available |

    When I send GET Request for pet with '35' id

    Then verify that the status code is 200
    And verify that the response body for pet is like:
      | id | name   | status    |
      | 35 | doggie | available |
    And verify that the schema is correct

  @updatePet @deletePet
  Scenario: Update a pet
    Given I have a pet with following details:
      | id | name   | status    |
      | 35 | doggie | available |

    When I want to update the pet with following details:
      | id | name | status |
      | 35 | kara | sold   |
    And I do put request to update the pet

    Then verify that the status code is 200
    And verify that the response body for pet is like:
      | id | name | status |
      | 35 | kara | sold   |

