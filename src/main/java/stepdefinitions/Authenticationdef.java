package stepdefinitions;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Authenticationdef {
    @Given("a registered user with the user id \"(.*)\" and password \"(.*)\"$")
    public void login(String userName, String password){
        System.out.println(userName);
        System.out.println(password);
    }


    @When("the user enters the credentials and click on the login")
    public void the_user_enters_the_credentials_and_click_on_the_login() {
        System.out.println("I am in step 2");
    }
    @Then("the system should authenticate the user")
    public void the_system_should_authenticate_the_user() {
        System.out.println("I am in step 3");
    }

  @Given("I am registered user with username \"(.*)\" with password \"(.*)\"$")
  public void iAmRegisteredUserWithUsernameWithPassword(String username, String password) {
        System.out.println(username);
        System.out.println(password);
  }



    @Given("the user is on the landing page")
    public void theUserIsOnTheLandingPage(DataTable userCreds) {
      List<List<String>>data=  userCreds.asLists();
      System.out.println(data.get(0).get(0));
      System.out.println(data.get(0).get(1));
      System.out.println(data.get(1).get(0));
      System.out.println(data.get(1).get(1));
    }

    @Given("the user entered the creds")
    public void theUserEnteredTheCreds(DataTable userCreds) {
      List<Map<String,String>>data=  userCreds.asMaps(String.class,String.class);
      System.out.println("Username is "+data.get(0).get("username"));
      System.out.println("Password is "+data.get(0).get("password"));
      System.out.println("Username is "+data.get(1).get("username"));
      System.out.println("Password is "+data.get(1).get("password"));
    }

    @Given("the user entered the JSON testdata")
    public void theUserEnteredTheJSONTestdata(String jsonData) {

       String userName1= JsonPath.parse(jsonData).read("$.users[0].name");
       System.out.println(userName1);
       String userName2=JsonPath.parse(jsonData).read("$.users[1].name");
       System.out.println(userName2);
    }



}
