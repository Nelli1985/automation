Feature: Feature for testing cart functionality

@api
Scenario: Get shopping cart for a guest customer with static product
  Given I have created a session
  When I add product "41" to the cart
  And I create a guest customer
  Then I see the product "41" in cart
  And I set shipping address
  And I get shipping method
  And I set shipping method
  And I get payment method
  And I set payment method
  And I confirm my order
  And I clear the cart
