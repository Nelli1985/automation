package API;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class MyAPIStepdefs {
    private String baseURI = "http://opencart3-simple.api.opencart-api.com/api/rest/";  // defined class level parameter so it would be usable by other methods as well
    private String sessionId;  // this parameter will be used by most of the following requests, so this too is a class level variable
    private final String merchantId = "123"; // this parameter will be used by most of the following requests, so this too is a class level variable with defined value
    private Response response;

    @Given("^I have created a session$")
    public void iHaveCreatedASession() {

        String requestURL = baseURI + "session"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        response = httpRequest.get(requestURL);

        //response.getBody().prettyPrint();
        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());

        // another assertion to make sure the request was actually successful
        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());

        sessionId = JsonPath.from(response.getBody().asString()).get("data.session"); // getting the sessionId value from the response body and saving it
    }

    @When("I add product \"([^\"]*)\" to the cart")
    public void iAddAProductToTheCart(String cartProductId) {
        String requestURL = baseURI + "cart"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        //Adding json body to the request:
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("product_id", cartProductId);
        requestParams.addProperty("quantity", "1");

        httpRequest.body(requestParams.toString());

        response = httpRequest.post(requestURL);

        //prints out the result
        //response.getBody().prettyPrint();

        // Assert productId
        String productId = JsonPath.from(response.getBody().asString()).get("data.product.product_id");
        assertEquals("Error: Product id doesn't match!","41", productId);

        // Assert productName
        String productName = JsonPath.from(response.getBody().asString()).get("data.product.name");
        assertEquals("Error: Product name doesn't match!","iMac", productName);

        // Assert productQuantity
        String productQuantity = JsonPath.from(response.getBody().asString()).get("data.product.quantity");
        assertEquals("Error: Product quantity doesn't match!","1", productQuantity);

        // Assert cartTotalProductQuantity
        int cartTotalProductQuantity = JsonPath.from(response.getBody().asString()).get("data.total_product_count");
        assertEquals("Error: Cart Total Product Quantity doesn't match!",1, cartTotalProductQuantity);

        // Assert cartTotalPrice
        String cartTotalPrice = JsonPath.from(response.getBody().asString()).get("data.total_price");
        assertEquals("Error: Cart Total Price doesn't match!","$122.00", cartTotalPrice);
    }


    @And("I create a guest customer")
    public void i_create_a_guest_customer() {
        String requestURL = baseURI + "guest"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        //Adding json body to the request:
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("firstname", "Demo");
        requestParams.addProperty("lastname", "User");
        requestParams.addProperty("email", "nash1@vipmail.hu");
        requestParams.addProperty("telephone", "1-541-754-3010");
        requestParams.addProperty("company", "string");
        requestParams.addProperty("city", "Berlin");
        requestParams.addProperty("address_1", "Demo");
        requestParams.addProperty("address_2", "Demo");
        requestParams.addProperty("country_id", "81");
        requestParams.addProperty("postcode", "3333");
        requestParams.addProperty("zone_id", "1256");

        httpRequest.body(requestParams.toString());

        response = httpRequest.post(requestURL);

        //prints out the result
        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());

        // another assertion to make sure the request was actually successful
        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());
    }

    @Then("I see the product \"([^\"]*)\" in cart")
    public void i_see_the_product_in_cart(String cartProductId) {
        String requestURL = baseURI + "cart"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        response = httpRequest.get(requestURL);

        //prints out the result
        //response.getBody().prettyPrint();

        // Assert productId jsonData.id_tokens[0]["id_token.basic"];
        String productId = JsonPath.from(response.getBody().asString()).get("data.products[0].product_id");
        assertEquals("Error: Product id doesn't match!","41", productId);

        // Assert productName
        String productName = JsonPath.from(response.getBody().asString()).get("data.products[0].name");
        assertEquals("Error: Product name doesn't match!","iMac", productName);

        // Assert productQuantity
        String productQuantity = JsonPath.from(response.getBody().asString()).get("data.products[0].quantity");
        assertEquals("Error: Product quantity doesn't match!","1", productQuantity);

        // Assert cartTotalProductQuantity
        int cartTotalProductQuantity = JsonPath.from(response.getBody().asString()).get("data.total_product_count");
        assertEquals("Error: Cart Total Product Quantity doesn't match!",1, cartTotalProductQuantity);

        // Assert cartTotalPrice
        String cartTotalPrice = JsonPath.from(response.getBody().asString()).get("data.total");
        assertEquals("Error: Cart Total Price doesn't match!","1 item(s) - $122.00", cartTotalPrice);
    }

    @And("I set shipping address")
    public void i_set_shipping_address() {
        String requestURL = baseURI + "guestshipping"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        //Adding json body to the request:
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("firstname", "Demo");
        requestParams.addProperty("lastname", "User");
        requestParams.addProperty("city", "Berlin");
        requestParams.addProperty("address_1", "Demo");
        requestParams.addProperty("address_2", "Demo");
        requestParams.addProperty("country_id", "81");
        requestParams.addProperty("postcode", "3333");
        requestParams.addProperty("zone_id", "1256");

        httpRequest.body(requestParams.toString());

        response = httpRequest.post(requestURL);

        //prints out the result
        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());

        // another assertion to make sure the request was actually successful
        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());
    }

    @And("I get shipping method")
    public void i_get_shipping_method() {
        // Get shipping method
        String requestURL = baseURI + "shippingmethods"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        response = httpRequest.get(requestURL);

        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());

        // another assertion to make sure the request was actually successful
        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());

        // Assert shipping title
        String shippingTitle = JsonPath.from(response.getBody().asString()).get("data.shipping_methods.flat.title");
        assertEquals("Error: Shipping title doesn't match!","Flat Rate", shippingTitle);

        // Assert shipping cost
        String shippingCost = JsonPath.from(response.getBody().asString()).get("data.shipping_methods.flat.quote.flat.cost");
        assertEquals("Error: Shipping cost doesn't match!","5.00", shippingCost);

    }

    @And("I set shipping method")
    public void i_set_shipping_method() {
        // Get shipping method
        String requestURL = baseURI + "shippingmethods"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        //Set shipping method
        //Adding json body to the request:
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("shipping_method", "flat.flat");
        requestParams.addProperty("comment", "string");

        // POST shipping options request and asserting it
        httpRequest.body(requestParams.toString());
        response = httpRequest.post(requestURL);
        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());

        // another assertion to make sure the request was actually successful
        Integer success2 = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success2.toString());
    }

    @And("I get payment method")
    public void i_get_payment_method() {
        // Get payment method
        String requestURL = baseURI + "paymentmethods"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        // GET paymentmethod and asserting it
        response = httpRequest.get(requestURL);
        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());


        // another assertion to make sure the request was actually successful
        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());

        // Assert payment title
        String paymentTitle = JsonPath.from(response.getBody().asString()).get("data.payment_methods.pp_express.title");
        assertEquals("Error: Payment title doesn't match!","PayPal Express Checkout", paymentTitle);

        // Assert cod title
        String codTitle = JsonPath.from(response.getBody().asString()).get("data.payment_methods.cod.title");
        assertEquals("Error: Code cod title doesn't match!","Cash On Delivery", codTitle);
    }

    @And("I set payment method")
    public void i_set_payment_method() {
        // Get payment method
        String requestURL = baseURI + "paymentmethods"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        // POST paymentmethod
        // Adding json body to the request:
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("payment_method", "cod");
        requestParams.addProperty("agree", "1");
        requestParams.addProperty("comment", "string");

        httpRequest.body(requestParams.toString());

        response = httpRequest.post(requestURL);

        // asserting POST paymentmethod
        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());


        // another assertion to make sure the request was actually successful
        Integer success2 = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success2.toString());

    }

    @And("I confirm my order and clear the cart")
    public void i_confirm_my_order_and_clear_the_cart() {

        String requestURL = baseURI + "confirm"; // building the API endpoint

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json"); // adding header to the request
        httpRequest.header("X-Oc-Session", sessionId); // adding header to the request
        httpRequest.header("X-Oc-Merchant-Id", merchantId); // adding header to the request

        // Get an overview of the order
        response = httpRequest.post(requestURL);
        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());


        // another assertion to make sure the request was actually successful
        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());

        // Assert payment total amount
        String paymentTotal = JsonPath.from(response.getBody().asString()).get("data.totals[2].text");
        assertEquals("Error: Payment total doesn't match!","$105.00", paymentTotal);

        // Assert shipping cost
        String shippingCost = JsonPath.from(response.getBody().asString()).get("data.totals[1].text");
        assertEquals("Error: Shipping cost doesn't match!","$5.00", shippingCost);

        // Assert shipping zip
        String shippingZip = JsonPath.from(response.getBody().asString()).get("data.shipping_postcode");
        assertEquals("Error: Shipping zip doesn't match!","3333", shippingZip);

        // Clear the cart and reset the session
        response = httpRequest.put(requestURL);
        //response.getBody().prettyPrint();

        // asserting the response is correct
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());


        // another assertion to make sure the request was actually successful
        Integer success2 = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success2.toString());
    }
}

