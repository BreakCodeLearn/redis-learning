# REDIS: Learning Exercise
The purpose of the exercise is to learn the basics of Redis database and how we can interact with it using JAVA.
Redis is an open source (BSD licensed), in-memory data structure store used as a database, cache, message broker, and streaming engine.

## Problem Statement
Write a small JAVA Program to;
  - Insert the values 1-100 into the Redis OSS database on source-db.
  - Read and print them in reverse order from replica-db.

## Instructions
The program can executed in the pre-configured enviornment provided by the Redis (Password: bQtZ4fv).

[Redis: VS Code IDE](https://code-dot-rl-s-tc-himanchu.ps-redislabs.com/)
(Try clearing the browser cookies if you face any issues in opening the IDE url)


Click on the provided IDE, locate the 'RedisChallenge' java file and execute/ run the program. 
You can check the output of the program on the IDE

If you want to execute code in another IDE or locally then complete the following steps;
1. Check if docker is already installed, if not then install it from [here](https://docs.docker.com/desktop/install/mac-install/)
2. Pull the redis docker image from docker hub
```bash
$ docker run -p 6379:6379 -d --name redis7 redis:latest
```
3. Open the redis shell and now you can run redis-cli
```bash
$ docker exec -it redis7 sh
```

4. Clone the repository in the IDE of your choice
5. Make sure you have jedis jar and POM xml updated for dependencies

Note: Install the extensions like Maven for Java as needed.
