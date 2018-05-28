# Friend Management Api

This is an application with a need to build its own social network, "Friends Management" is a common requirement which usually starts off simple but can grow in complexity depending on the application's use case.
Usually, the application compraised of features like "Friend", "Unfriend", "Block", "Receive Updates" etc.

The Application is deployed on AWS - EC2 instance.It can be accessed via the below url and the path for all the api is `/firendsapi`
http://ec2-18-216-161-170.us-east-2.compute.amazonaws.com:8080

For example: To access `/firends` endpoint, the URL should be:

http://ec2-18-216-161-170.us-east-2.compute.amazonaws.com:8080/firendsapi/friends

Swagger UI is configured for the app and it is available: http://ec2-18-216-161-170.us-east-2.compute.amazonaws.com:8080/swagger-ui.html

### List of REST Endpoints and Explanation

1. Returns a list of friends of a person.
   * Path : `/friends`
   * Input :
   ```
   {
		"email":"abc@example.com"
   }
   ```
   * Sample Output :
   ```
   {
		"success": true,
		"friends":[
			"pqr@gmail.com",
			"lmn@gmail.com",			
		],
		"count":2
	}
	```
	* Defined Errors : 
	  * 40000 : Occurs when invalid email provided in the request.
	  * 40006 : Occurs when the email address in the request is not valid (Not matched with the Regex)
	  * 40004 : Occurs when the person given by the email does not exist
	  
2.  Returns list of common friends of two persons
    * Path : `/commonfriends`
    * Input :
    ```
    {
		"friends":[
			"abc@gmail.com",
			"pqr@gmail.com"
		]
    }
    ```
    * Output :
    ```
    {
		"success": true,
		"friends":[
			"lmn@gmail.com",
			"ijk@gmail.com"
		],
		"count":2
	}
	```
	* Defined Errors : 
	  * 40000 : Invalid request.
	  * 40006 : Request contains emails are invalid
	  * 40004 : Persons given by the email do not exist
	  * 40004 : The two email addresses in the input are the same
	  
3.  Establish Friendship between two persons
    * Path : `/friendrequest`
    * Input :
    ```
    {
		"friends":[
			"abc@gmail.com",
			"pqr@gmail.com"
		]
    }
    ```
    * Output :
    ```
    {
		"success": true
	}
	```
	* Defined Errors : 
	  * 40000 : Invalid request
	  * 40006 : Request contains emails are invalid
	  * 40004 : Persons given by the email do not exist
	  * 40004 : The two email addresses in the input are the same
	  * 40001 : Persons in the input are already friends
	  * 40002 : One of the person in the request have blocked the other person
	  
4.  Person subscribe to another Person
    * Path : `/subscribe`
    * Input :
    ```
    {
		"requestor":"abc@gmail.com",
		"target":"pqr@gmail.com"
    }
    ```
    * Output :
    ```
    {
		"success": true
	}
	```
	* Defined Errors : 
	  * 40000 : Invalid request
	  * 40006 : Request contains emails are invalid
	  * 40004 : Persons given by the email do not exist
	  * 40004 : The two email addresses in the input are the same
	  * 40001 : Persons in the input are already friends
	  * 40004 : Duplicate subscription, a person already subscribed to another

5.  Person block updates from another Person
    * Path : `/block`
    * Input :
    ```
    {
		"requestor":"example@example.com",
		"target":"example2@example.com"
    }
    ```
    * Output :
    ```
    {
		"success": true
	}
	```
	* Defined Errors : 
	  * 40000 : Invalid request
	  * 40006 : Request contains emails are invalid
	  * 40004 : Persons given by the email do not exist
	  * 40004 : The two email addresses in the input are the same
	  * 40001 : Persons in the input are already friends
	  * 40002 : The person already blocked updates from the user
	  
6.  Post an update which returns a list of emails that will receive the update.
    * Path : `/sendupdates`
    * Input :
    ```
    {
		"sender":"abc@gmail.com",
		"target":"Hello, how are you ! xyz@gmail.com"
    }
    ```
    * Output :
    ```
    {
		"success": true,
		"recipients":[
			"xyz@gmail.com",
			"pqr@gmail.com"			
		]
	}
	```
	* Defined Errors : 
	  * 40000 : Invalid request
	  * 40006 : Request contains emails are invalid
	  * 40004 : Persons given by the email do not exist
	  
### Other Errors

In any case any of the endpoint fails it outputs an error response instead. The error response has the below format

	```
	{
		"success": false,
		"errorCode": "5000",
		"message":"Unknown Error"
	}
	```
   
### Database
The Database is pre populated with 10 persons for testing purpose, aslo the data can be found from the SQL script file which is placed inside the code repository.

![Db Script](https://github.com/isudarsan/friendmanagement/blob/master/Friend_DB.sql)

Below is the simple ER Diagram used for the application.

![DB Diagram](https://github.com/isudarsan/friendmanagement/blob/master/DB_ER_DIAGRAM.bmp)

