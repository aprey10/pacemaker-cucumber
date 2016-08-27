Feature: Book Search

  Scenario: Test search by author and year
    Given we have two books with titles "title1" and "title2" that were written by "John Doe" and published at 1990
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And titles of that books will be "title1" and "title2"

  Scenario: Test search by author and year with List
    Given we have books that were written by "John Doe" and published at 1990, books titles: title1, title2
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And titles of that books will be: title1, title2

  Scenario: Test search by author and year with Map
    Given we have books that were published at 1990, books titles and authors:
      | title1 | John Doe   |
      | title2 | John Doe   |
      | title3 | John Smith |
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And titles of that books will be: title1, title2


  Scenario: Test search by author and year with DTO
    Given we have list of books:
      | title  | author     | year |
      | title1 | John Doe   | 1990 |
      | title2 | John Doe   | 1990 |
      | title3 | John Smith | 1991 |
      | title4 | John Smith | 1990 |
    When search for book by author "John Doe" and year 1990
    Then 2 books will be found
    And titles of that books will be: title1, title2

  Scenario Outline: Test search by author and year with DTO
    Given we have list of books:
      | title  | author        | year |
      | title1 | John Doe      | 1990 |
      | title2 | John Doe      | 1990 |
      | title3 | John Smith    | 1991 |
      | title4 | John Smith    | 1990 |
      | title5 | George Orwell | 1984 |
      | title7 | George Orwell | 1984 |
    When search for book by author "<author>" and year <year>
    Then <amount> books will be found
    And titles of that books will be: <booksTitles>

    Examples:
      | author        | year | amount | booksTitles    |
      | John Doe      | 1990 | 2      | title1, title2 |
      | John Smith    | 1991 | 1      | title3         |
      | John Smith    | 1990 | 1      | title4         |
      | George Orwell | 1984 | 2      | title5, title7 |

