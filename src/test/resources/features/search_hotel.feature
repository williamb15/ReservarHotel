Feature: Search a hotel more economic
  I as a user need
  Find the cheapest hotel
  For vacation

  @ViajeMasEconomico
  Scenario:Search Most Economical Hotel
    Given the user is on the main trivago page and enters the data
      | destiny    | arrivalDate | exitDate   | room       |
      | San Andrés | 08/01/2020  | 08/07/2020 | Individual |
    When he analyzes the results and selects the cheapest
    Then he will be able to see on the page the cheapest hotel
