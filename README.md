# Canteen Online food management System 
Canteen Online Food Management System  have  4 major microservices that work and integrate together.
##### Order Service 
process all  customer orders such as customer order food by choosing a different menu, quantity; get valid
payment information from payment Microservices  and Send Email about order information to the customer 
##### Member Management Service
register user, user information, user credit card information, user delivery address information 
##### Canteen Management Service
The canteen has lots of restaurants in it. So. this microservice handle all the restaurant and menu information such as registering restaurant information, get all restaurant and food information  find Restaurant by restaurant ID
##### Payment Management Service 
using sample data, check if using credit card information is valid or not and send the result through the message queue  

