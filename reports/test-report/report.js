$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login.feature");
formatter.feature({
  "name": "Login test with incorrect and correct credentials",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.scenario({
  "name": "User should not be logged into the application with incorrect credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter \"user1\" as username and \"qwerty\" as password and try to login",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterAsUsernameAndAsPasswordAndTryToLogin(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should be logged into the application with correct credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter \"user1@login.ee\" as username and \"qwertyqwerty\" as password and try to login",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterAsUsernameAndAsPasswordAndTryToLogin(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m logged into the application",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_m_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I log off successfully",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_log_off_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.step({
  "name": "I will enter the Email \u003cemail\u003e and Password \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "",
        ""
      ]
    },
    {
      "cells": [
        "user1",
        ""
      ]
    },
    {
      "cells": [
        "",
        "qwerty"
      ]
    },
    {
      "cells": [
        "user2",
        "qwerty"
      ]
    },
    {
      "cells": [
        "user3",
        "*"
      ]
    },
    {
      "cells": [
        "user4@login.ee",
        "qwerty"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter the Email  and Password ",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterTheEmailEmailAndPasswordPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter the Email user1 and Password ",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterTheEmailEmailAndPasswordPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter the Email  and Password qwerty",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterTheEmailEmailAndPasswordPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter the Email user2 and Password qwerty",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterTheEmailEmailAndPasswordPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter the Email user3 and Password *",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterTheEmailEmailAndPasswordPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should not be logged into the application with list of incorrect credentials",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@selenium"
    }
  ]
});
formatter.step({
  "name": "I have opened the application main page url: \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepdefs.iHaveOpenedTheApplicationMainPageUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have opened the login page",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_have_opened_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will enter the Email user4@login.ee and Password qwerty",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepdefs.iWillEnterTheEmailEmailAndPasswordPassword(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will be promted error message",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.i_will_be_promted_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I\u0027m not logged into the application",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.i_m_not_logged_into_the_application()"
});
formatter.result({
  "status": "passed"
});
});