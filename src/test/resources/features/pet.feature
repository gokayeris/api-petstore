@pet
Feature: Pet

  @createPet @deletePet
  Scenario: Create a pet
    Given pet with following details:
      | id | petId | quantity | shipDate                 | status | complete |
      | 1  | 10    | 0        | 2021-08-12T13:41:08.955Z | placed | true     |

    When I do post request to create a pet

    Then verify that the status code is 200
    And verify that the response body for pet is like:
      | id | petId | status | complete |
      | 1  | 10    | placed | true     |

  @createPet @deletePet
  Scenario: Update a pet
    Given I have a pet with following details:
      | id | name  | status    |
      | 1  | pamuk | available |

    When I want to update the pet with following details:
      | id | name | status |
      | 1  | kara | sold   |
    And I do put request to update the pet

    Then verify that the status code is 200
    And verify that the response body for pet is like:
      | id | petId | status | complete |
      | 1  | 10    | placed | true     |

  @getPet @deletePet
  Scenario: Get a pet
    Given I have a pet with following details:
      | id | petId | quantity | shipDate                 | status | complete |
      | 1  | 10    | 0        | 2021-08-12T13:41:08.955Z | placed | true     |

    When I send GET Request for pet with '1' id

    Then verify that the status code is 200
    And verify that the response body for pet is like:
      | id | name                | status    |
      | 1  | purplefieldstester2 | available |