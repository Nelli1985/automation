Feature: Feature for testing cart functionality

@api
Scenario: Get shopping cart for a guest customer with static product
Given I have created a session
When I add product "31" to the cart
And I create a guest customer
Then I see the product "31" in cart
