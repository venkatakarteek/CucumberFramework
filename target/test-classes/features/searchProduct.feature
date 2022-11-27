Feature: Search and Order Products from GreetKart page

@SearchPage
Scenario Outline: Search Experience for product search in both Home page and Offers page

Given User is on Greenkart Landing page
When User searched with Shortname <vegName> and extracted actual name of product
Then User searched for <vegName> Shortname in offers page
And validate product name in offers page matches with product name in landing page

Examples:
| vegName |
| Tom     |
| Beet    |