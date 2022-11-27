Feature: Place the order for products

@PlaceOrder
Scenario Outline: Add product to cart

Given User is on Greenkart Landing page
When User searched with Shortname <vegName> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <vegName> items in Checkout page
And Verify User has ability to enter promo code and place the order

Examples:
| vegName |
| Tom     |
| Cauli   |
| Beet    |