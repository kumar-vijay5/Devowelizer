Feature: Devowelizer Service API

# API should return the input without the vowels
Scenario Outline: API GET call return the input without vowels
Given API base point is available to Test
When I trigger a GET request on API with endpoint as "<API_EndPoint>"
Then the response status should be 200
And also, response of API should be "<expected_ResponseBody>"

  # Examples table contain different test cases - A positive flow on functionality
  Examples:
    | API_EndPoint   | expected_ResponseBody |   # the comments
    | Season         | Ssn                   |   # A simple word 3 vowels
    | Intermediate   | ntrmdt                |   # more lengthy word with repeated vowels
    | coevolutionary | cvltnry               |   # A complex word with all 5 vowels covered
    | w0rld_EmpIrE/  | w0rld_mpr/            |   # A mix of vowels and special characters
    | WORLD_EMPIRE   | WRLD_MPR              |   # All are capital letters
    | world_empire   | wrld_mpr              |   # All are small letters
    | AeioU          |                       |   # Word with only vowels and camel case
    | eutOpia        | tp		             |   # A single camel case vowel
    | world$empi*re  | wrld$mp*r             |   # A mix of vowels and special characters
    | a%&*i          | %&*                   |   #









