Feature: Validating place APIs

  Scenario: Verify if place is being successfully added using  AddPlace API
    Given Add Place payload
    When user calls "AddPlace" API with post https request
    Then the API call got success with status code 200
    And  "status" in the response body is "OK"
    And  "scope" in the response body is "APP"

#  Scenario: Verify if place is being successfully Deleted using  DeletePlace API
#    Given Add Place payload
#    When user calls "DeletePlace" API with post https request
#    Then the API call got success with status code 200
#    And  status in the response body is OK