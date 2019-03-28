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
  "location": "MyAPIStepdefs.sessionCreation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add product \"41\" to the cart",
  "keyword": "When "
});
formatter.match({
  "location": "MyAPIStepdefs.addingProduct(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I create a guest customer",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.creatingGuestCustomer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see the product \"41\" in cart",
  "keyword": "Then "
});
formatter.match({
  "location": "MyAPIStepdefs.confirmingProductInTheCart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set shipping address",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.settingShippingAddress()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get shipping method",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.gettingShippingMethod()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set shipping method",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.settingShippingMethod()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get payment method",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.gettingPaymentMethod()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I set payment method",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.settingPaymentMethod()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I confirm my order",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.confirmingOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I clear the cart",
  "keyword": "And "
});
formatter.match({
  "location": "MyAPIStepdefs.clearingCart()"
});
formatter.result({
  "status": "passed"
});
});