/**
 * @author Prateek
 */
app.service('customersService', function () {
    this.getCustomers = function () {
        return customers;
    };

   this.getUser = function() {
    	console.log("return");
    	return user;
    };

    this.setLoggedInUser = function(user) {
      loggedInUser = user;
    };

    this.getLoggedInUser = function() {
        return loggedInUser;
      }



    var loggedInUser = {}

});