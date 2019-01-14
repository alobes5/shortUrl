# Short URL

## Mandatory Requirements

- Design and implement an API for short URL creation 
- Implement forwarding of short URLs to the original ones
- There should be some form of persistent storage
- The application should be distributed as one or more Docker images

## Additional Requirements

- Design and implement an API for gathering different statistics

## How to run

In order to run the application `ab-short-url` execute the commands:
* Checkout the code
* Run `./mvnw clean install` or `./mvnw clean package`
* See the Aditional configurations
* Run `docker-compose up`

### Aditional configuration:

On the YML file config, we have two parameters that need to be updated:
* server.port
* IP

The IP must be filled with the docker configured IP, to get this value you may execute the command:
```
$ docker-machine IP
192.168.99.100
```

### Expected App behavior
* When `docker-compose up` is executed, should be created 2 containers, the postgres and the app container.
* The postgres should had his  database objects configures by flayway
* The acuator should have all the endoiunts expose.
* No authentication is required

### Endpoints
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
Try the acuator enpoint in order the check the api informations. 

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
To check some metrics you may access the `http://<ip>:<port>/actuator/metrics/http.server.requests`.
