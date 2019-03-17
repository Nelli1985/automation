Feature: Feature for testing cart functionality

@api
Scenario: Get shopping cart for a guest customer with static product
  Given I have created a session
  When I add product "31" to the cart
  And I create a guest customer
  Then I see the product "31" in cart
  And I set shipping address
  And I get and set shipping method
  And I get and set payment method
  And I confirm my order and clear the cart
