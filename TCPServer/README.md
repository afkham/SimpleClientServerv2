#Simple TCP Server

This implimentation shows a simple server which contains a Thread pool and a Queue to handle requests

##How to run

````
   sh Server.sh {Port} {Thread Pool Minimum Size} {Thread Pool Maximum Size} {Max Time Thread Alive}
````
##Defaults

if you did't provide any parameters still the server runs with default parameters.default parameters listed below.

>>Thread pool minimum size : 20
 
>>Thread pool maximum size : 50

>> Default Port : 4444

>> Default time alive : 30 seconds 