package API;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class MyAPIStepdefs {
    private String baseURI = "http://opencart3-simple.api.opencart-api.com/api/rest/";
    private String sessionId;
    private final String merchantId = "123";

    private Response basicAssertion(final Response response){
        assertEquals("Error: Status code doesn't match", 200, response.getStatusCode());
        assertEquals("Error: Content type doesn't match", "application/json; charset=utf-8", response.getContentType());

        Integer success = JsonPath.from(response.getBody().asString()).get("success");
        assertEquals("Error: Success code doesn't match", "1", success.toString());
        return response;
    }

    @Given("^I have created a session$")
    public void sessionCreation() {
        String requestURL = baseURI + "session";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        Response response = httpRequest.get(requestURL);

        basicAssertion(response);

        sessionId = JsonPath.from(response.getBody().asString()).get("data.session");
    }

    @When("I add product \"([^\"]*)\" to the cart")
    public void addingProduct(String cartProductId) {
        String requestURL = baseURI + "cart";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("product_id", cartProductId);
        requestParams.addProperty("quantity", "1");

        httpRequest.body(requestParams.toString());
        Response response = httpRequest.post(requestURL);

        basicAssertion(response);

        String productId = JsonPath.from(response.getBody().asString()).get("data.product.product_id");
        assertEquals("Error: Product id doesn't match!","41", productId);

        String productName = JsonPath.from(response.getBody().asString()).get("data.product.name");
        assertEquals("Error: Product name doesn't match!","iMac", productName);

        String productQuantity = JsonPath.from(response.getBody().asString()).get("data.product.quantity");
        assertEquals("Error: Product quantity doesn't match!","1", productQuantity);

        int cartTotalProductQuantity = JsonPath.from(response.getBody().asString()).get("data.total_product_count");
        assertEquals("Error: Cart Total Product Quantity doesn't match!",1, cartTotalProductQuantity);

        String cartTotalPrice = JsonPath.from(response.getBody().asString()).get("data.total_price");
        assertEquals("Error: Cart Total Price doesn't match!","$122.00", cartTotalPrice);
    }


    @And("I create a guest customer")
    public void creatingGuestCustomer() {
        String requestURL = baseURI + "guest";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

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

        Response response = httpRequest.post(requestURL);

        basicAssertion(response);
    }

    @Then("I see the product \"([^\"]*)\" in cart")
    public void confirmingProductInTheCart(String cartProductId) {
        String requestURL = baseURI + "cart";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        Response response = httpRequest.get(requestURL);

        basicAssertion(response);

        String productId = JsonPath.from(response.getBody().asString()).get("data.products[0].product_id");
        assertEquals("Error: Product id doesn't match!",cartProductId, productId);

        String productName = JsonPath.from(response.getBody().asString()).get("data.products[0].name");
        assertEquals("Error: Product name doesn't match!","iMac", productName);

        String productQuantity = JsonPath.from(response.getBody().asString()).get("data.products[0].quantity");
        assertEquals("Error: Product quantity doesn't match!","1", productQuantity);

        int cartTotalProductQuantity = JsonPath.from(response.getBody().asString()).get("data.total_product_count");
        assertEquals("Error: Cart Total Product Quantity doesn't match!",1, cartTotalProductQuantity);

        String cartTotalPrice = JsonPath.from(response.getBody().asString()).get("data.total");
        assertEquals("Error: Cart Total Price doesn't match!","1 item(s) - $122.00", cartTotalPrice);
    }

    @And("I set shipping address")
    public void settingShippingAddress() {
        String requestURL = baseURI + "guestshipping";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

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

        Response response = httpRequest.post(requestURL);

        basicAssertion(response);
    }

    @And("I get shipping method")
    public void gettingShippingMethod() {
        String requestURL = baseURI + "shippingmethods";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        Response response = httpRequest.get(requestURL);
        basicAssertion(response);

        String shippingTitle = JsonPath.from(response.getBody().asString()).get("data.shipping_methods.flat.title");
        assertEquals("Error: Shipping title doesn't match!","Flat Rate", shippingTitle);

        String shippingCost = JsonPath.from(response.getBody().asString()).get("data.shipping_methods.flat.quote.flat.cost");
        assertEquals("Error: Shipping cost doesn't match!","5.00", shippingCost);

    }

    @And("I set shipping method")
    public void settingShippingMethod() {
        String requestURL = baseURI + "shippingmethods";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("shipping_method", "flat.flat");
        requestParams.addProperty("comment", "string");

        httpRequest.body(requestParams.toString());
        Response response = httpRequest.post(requestURL);
        basicAssertion(response);
    }

    @And("I get payment method")
    public void gettingPaymentMethod() {
        String requestURL = baseURI + "paymentmethods";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        Response response = httpRequest.get(requestURL);
        basicAssertion(response);

        String paymentTitle = JsonPath.from(response.getBody().asString()).get("data.payment_methods.pp_express.title");
        assertEquals("Error: Payment title doesn't match!","PayPal Express Checkout", paymentTitle);

        String codTitle = JsonPath.from(response.getBody().asString()).get("data.payment_methods.cod.title");
        assertEquals("Error: Code cod title doesn't match!","Cash On Delivery", codTitle);
    }

    @And("I set payment method")
    public void settingPaymentMethod() {
        String requestURL = baseURI + "paymentmethods";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("payment_method", "cod");
        requestParams.addProperty("agree", "1");
        requestParams.addProperty("comment", "string");

        httpRequest.body(requestParams.toString());
        Response response = httpRequest.post(requestURL);

        basicAssertion(response);
    }

    @And("I confirm my order")
    public void confirmingOrder() {
        String requestURL = baseURI + "confirm";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        Response response = httpRequest.post(requestURL);
        basicAssertion(response);

        String paymentTotal = JsonPath.from(response.getBody().asString()).get("data.totals[2].text");
        assertEquals("Error: Payment total doesn't match!","$105.00", paymentTotal);

        String shippingCost = JsonPath.from(response.getBody().asString()).get("data.totals[1].text");
        assertEquals("Error: Shipping cost doesn't match!","$5.00", shippingCost);

        String shippingZip = JsonPath.from(response.getBody().asString()).get("data.shipping_postcode");
        assertEquals("Error: Shipping zip doesn't match!","3333", shippingZip);
    }

    @And("I clear the cart")
    public void clearingCart() {
        String requestURL = baseURI + "confirm";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Accept", "application/json");
        httpRequest.header("X-Oc-Session", sessionId);
        httpRequest.header("X-Oc-Merchant-Id", merchantId);

        Response response = httpRequest.put(requestURL);
        //response.getBody().prettyPrint();

        basicAssertion(response);
    }
}

