Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When the user enters valid credentials
      | username  | password  |
      | Admin  | admin123  |     
    And clicks on the login button
   Then the user should be redirected to the dashboard
    

 
