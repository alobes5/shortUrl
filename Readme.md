# Short URL

## Mandatory Requirements

* Design and implement an API for short URL creation :white_check_mark:
  * POST endpoint

* Implement forwarding of short URLs to the original ones :white_check_mark:
  * GET endpoint

* There should be some form of persistent storage :white_check_mark:
  * Repository and Postgres

* The application should be distributed as one or more Docker images :white_check_mark:
  * 3 images, api, database and openjdk

## Additional Requirements

* Design and implement an API for gathering different statistics :white_check_mark:
  * Acuator statistics and metrics

## How to run :computer:

In order to run the application `ab-short-url` execute the commands:
* Checkout the code
* Run `./mvnw clean install` or `./mvnw clean package`
* See the additional-requirements
* Run `docker-compose up`

### Aditional configuration: :heavy_plus_sign:

On the YML file config, we have two parameters that need to be updated:
* server.port
* ip

The IP must be filled with the docker configured IP, to get this value you may execute the command:
```
$ docker-machine IP
192.168.99.100
```

### Expected App behavior :+1:
* When `docker-compose up` is executed, should be created 2 containers, the Postgres and the app container.
* The Postgres should have his  database objects configures by Flyway
* The acuator should have all the endpoints expose.
* No authentication is required

### Endpoints :clipboard:
The endpoints will be described with a flow example.

* Create short URL

POST:

```http://<ip>:<port>/shortUrl```

BODY:
```
{
	"longUrl":"http://google.com"
}
```
RESPONSE:
```
{
    "shortUrl": "http://<ip>:<port>/shortUrl/de34c40",
    "longUrl": "http://google.com"
}
```

* Forward short URL

GET:

```
http://<ip>:<port>/shortUrl/de34c40
```
BODY: No body

RESPONSE: Open the Google page

* Acuator
Try the acuator endpoint in order the check the API information. 

GET:

`http://<ip>:<port>/actuator/`

BODY: No body

RESPONSE:
```
{
"_links": {
"self": {
"href": "http://<ip>:<port>/actuator",
"templated": false
},
"auditevents": {
"href": "http://<ip>:<port>/actuator/auditevents",
"templated": false
},
...
}


```
To check some metrics you may access the `http://<ip>:<port>/actuator/metrics/http.server.requests` or `http://<ip>:<port>/actuator/httptrace`


## Could be improved :interrobang:
* Logs
* Thread safe
* No relational database
* Custom metrics
* Swagger
* Validations
* Path

