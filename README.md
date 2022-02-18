# Docker Compose Spring Boot,Reactive Programming,Mongodb with replica set

## Run the MongoDb replica set with Docker

Step 1: Create data volumes for each node

* `docker volume create --name mongodb_repl_data1 -d local`
* `docker volume create --name mongodb_repl_data2 -d local`
* `docker volume create --name mongodb_repl_data3 -d local`

Step 2:The services can be run on the background with command:

* `docker-compose up -d`

Step 3: Start an interactive MongoDb shell

docker exec -it mongo0 mongo --port 30000

Step 4: Configure the replica set

From the MongoDb shell, type (or paste) the following

config={"_id":"rs0","members":[{"_id":0,"host":"mongo0:30000"},{"_id":1,"host":"mongo1:30001"},{"_id":2,"host":"mongo2:30002"}]}

If you use this, you probably have to update your hosts file, as well.

On Windows you can find it at:

C:\Windows\System32\drivers\etc\hosts

Add

127.0.0.1 mongo0 mongo1 mongo2 to the file and save it.

Step 6: Initiate the replica set

Still in the MongoDb shell, type (or paste) the following

rs.initiate(config);

Now you should be able to connect to the replica set using the following connection string

mongodb://127.0.0.1:30000,127.0.0.1:30001,127.0.0.1:30002/?replicaSet=rs0

## Run the Spring Application

As Maven is used as the build system, run:

    ./mvn clean install

To run the project, just run one of the following commands:

    java -jar target/spring-mongo-example.jar

    ./mvn spring-boot:run

(https://github.com/tugayesilyurt/spring-reactive-mongodb-master-slave/blob/main/assets/primary-secondary.PNG)

### EndPoints ###

| Service       | EndPoint                      | Method | Description                                      |
| ------------- | ----------------------------- | :-----:| ------------------------------------------------ |
| Create        | /v1/hotels  					| POST   | Create Hotel 	            	                |
| FindAll       | /v1/hotels  					| GET    | Get All Hotels 	            	                |
| FindBy        | /v1/hotels/rooms/{rooms} 		| GET    | Get Less By Rooms	            	            |

- **Mongodb Replica**

![Mongodb Replica Set](https://github.com/tugayesilyurt/spring-reactive-mongodb-master-slave/blob/main/assets/mongodb.PNG)

- **Mongodb Replica**

![Mongodb Replica Set](https://github.com/tugayesilyurt/spring-reactive-mongodb-master-slave/blob/main/assets/replica.PNG)

