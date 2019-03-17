$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/API/shoppingCart.feature");
formatter.feature({
  "name": "Feature for testing cart functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get shopping cart for a guest customer with static product",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "I have created a session",
  "keyword": "Given "
});
formatter.match({
  "location": "MyAPIStepdefs.iHaveCreatedASession()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add product \"31\" to the cart",
  "keyword": "When "
});
formatter.match({
  "location": "MyAPIStepdefs.iAddAProductToTheCart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I create a guest customer",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.i_create_a_guest_customer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see the product \"31\" in cart",
  "keyword": "Then "
});
formatter.match({
  "location": "MyAPIStepdefs.i_see_the_product_in_cart(String)"
});
formatter.result({
  "status": "passed"
});
});