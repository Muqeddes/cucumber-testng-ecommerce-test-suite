@LoginToCheckout
Feature: User can login, sort prices, add products to shopping cart, and place an order.

  Background:
    When User enter valid credentials
    Then Products page should be displayed

  @SortPrice
  Scenario: User can sort price from the filtering options
    Given Products page should be displayed
    When User select High to Low sorting option
    Then Products should be sorted by price from the highest to lowest

  @AddProduct
  Scenario: User can add products to the shopping cart
    Given Products page should be displayed
    When User add product to shopping cart
    Then Products should be added to the shopping cart

  @PlaceOrder
  Scenario: User can finish checkout process, place an order.
    Given User is on the checkout page
    When User fill information
    And User click on the finish button
    Then The order should be placed