# AREP5-AllApps

## Description
In this project we build a simple message's repository with Java and Redis (NoSQL DB), this project is containerized with Docker and have a docker-compose.yml thats help you to run all the containers easily, we use 3 images to run the whole project; the redis original image, a image that have the LogService App that provide the interaction with the DB and the LoadBalancer that choose to what container send the petition (this have a facade to see in a browser the messages)

In this project you have the docker-compose, the Dockerfile of each Image that I build (this is in the corresponding folder). You don't need to build the Image you can pull it from my Dockerhub repository (orlandogk10)

## How to deploy it (Video in Spanish)

In this video I show how to deploy the system and I probe this one
[![Video](https://img.youtube.com/vi/eELPS2OGjHU/0.jpg)](https://www.youtube.com/watch?v=eELPS2OGjHU)

## Docker Images

All the images are with latest tag

- [orlandogk10/loadbalancerarep5](https://hub.docker.com/repository/docker/orlandogk10/loadbalancerarep5)
- [orlandogk10/applogarep](https://hub.docker.com/repository/docker/orlandogk10/applogarep)

## Deploy
**Important:** To execute the project you need to have Docker and Docker Compose installed in the machine that you want to deploy the project

### Code (Deploying)

```
git clone https://github.com/orlandoagk/AREP5-AllApps.git
cd AREP5-AllApps
sudo docker-compose up -d --scale logservice=3
```
When you deploy all the containers you can enter to the browser and put localhost, the loadbalancer has a facade to browser interaction

### API's
1. GET `/` -> LoadBalancer
2. POST `/sendMessage` -> LoadBalancer (You need to send in the body a message)
3. GET `/getMessages` -> LogService
4. POST `/putMessage` -> LogService (You need to send in the body a message)


### Test
1. `mvn test`


## Documentation
To read the documentation of the project you need to enter to the enter the APP folder in the project and search in the Documentation folder, open the Index if you want to have a similar experience to the real Java API documentation

## Tecnology Stack
- [Java 8](https://www.java.com/es/download/)
- [Apache Maven](https://maven.apache.org/)
- [Github](https://www.github.com/)
- [AWS](https://aws.amazon.com/es/)
- [Redis](https://redis.io/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Docker Hub](https://hub.docker.com/)

## Autor
- [orlandoagk - Github](https://www.github.com/orlandoagk)
- [Orlando Gelves - Linkedin](https://www.linkedin.com/in/orlando-antonio-gelves-kerguelen-11445b1a5/)

## References
- [Docker Docs](https://docs.docker.com)
- [Docker Compose](https://docs.docker.com/compose/)
- [Docker Networking](https://docs.docker.com/config/containers/container-networking/)
- [Statement](http://campusvirtual.escuelaing.edu.co/moodle/mod/assign/view.php?id=37113)
- [Jedis (connnection Java to Redis)](https://kb.objectrocket.com/redis/how-to-connect-redis-on-java-using-jedis-573)

## Licencia
This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](/LICENSE) file for more details.
