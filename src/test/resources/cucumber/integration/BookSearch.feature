Feature: Book Search

  Scenario: Test search by author and year
    Given we have two books with names "name1" and "name2" that were written by "John Doe" and published at 1990
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And names of that books will be "name1" and "name2"

  Scenario: Test search by author and year with List
    Given we have books that were written by "John Doe" and published at 1990, books names: name1, name2
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And names of that books will be: name1, name2

  Scenario: Test search by author and year with Map
    Given we have books that were published at 1990, books names and authors:
      | name1 | John Doe   |
      | name2 | John Doe   |
      | name3 | John Smith |
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And names of that books will be: name1, name2


  Scenario: Test search by author and year with DTO
    Given we have list of books:
      | name  | author     | year |
      | name1 | John Doe   | 1990 |
      | name2 | John Doe   | 1990 |
      | name3 | John Smith | 1991 |
      | name4 | John Smith | 1990 |
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And names of that books will be: name1, name2

  Scenario: Test search by author and year with DTO
    Given we have list of books:
      | name  | author     | year |
      | name1 | John Doe   | 1990 |
      | name2 | John Doe   | 1990 |
      | name3 | John Smith | 1991 |
      | name4 | John Smith | 1990 |
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And names of that books will be: name1, name2

#  Examples:
#    | author   | year | amount | booksNames   |
#    | John Doe | 1990 | 2      | name1, name2 |

