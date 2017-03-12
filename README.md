## Simple example of http with RxJava 2 and Retrofit


A simple example with two services comunicating with each other using Retrofit and RxJava 2 for complex http requests flow.
 
 _rx-consumer_ services invokes 2 times _rx-producer_ to obtain random coordinates in Poland, and with results of there 2 requests, invokes Google geocoder service to obrain address at these coordinates.
 If no address is found, whole process restarts up to total of 5 times.
 



#### How to run
First run both services:

`mvn clean install spring-boot:run -pl rx-producer`

`mvn clean install spring-boot:run -pl rx-consumer`

After that, you can invoke consumer service to get random addres from Poland and surroundings:

`curl -X GET --header 'Accept: text/plain' 'http://localhost:8081/address/random'
`

You can also use swagger-ui for this too, head to, find address controler and invkoe the service:

`http://localhost:8081/swagger-ui.html`
