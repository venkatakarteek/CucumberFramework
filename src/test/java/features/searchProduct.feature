Feature: Search and Order Products from GreetKart page

Scenario: Search Experience for product search in both Home page and Offers page

Given User is on Greenkart Landing page
When User searched with Shortname "tom" and extracted actual name of product
Then User searched for "tom" Shortname in offers page
And validate product name in offers page matches with product name in landing page