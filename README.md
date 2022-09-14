# REDIS: Learning Exercise
The purpose of the exercise is to learn the basics of Redis database.
Redis is an open source (BSD licensed), in-memory data structure store used as a database, cache, message broker, and streaming engine.

## Problem Statement
Write a small JAVA Program to;
  - Insert the values 1-100 into the Redis OSS database on source-db.
  - Read and print them in reverse order from replica-db.

## Instructions
The program can executed in the pre-configured enviornment provided by the Redis.
[VS Code IDE](https://code-dot-rl-s-tc-himanchu.ps-redislabs.com/)

Click on the provided IDE, locate the 'RedisChallenge' java file and execute/ run the program. 
You can check the output of the program on the IDE

If you want to execute code in the another IDE or locally then complete the following steps;
1. Check if docker is already installed, if not then install it from here[https://docs.docker.com/desktop/install/mac-install/]
2. Pull the redis docker image from docker hub
```bash
$ docker run -p 6379:6379 -d --name redis7 redis:latest
```
3. Open the redis shell and now you can run redis-cli
```bash
$ docker exec -it redis7 sh
```
4. Clone the repository in the IDE if you choice
5. Make sure you have jedis jar and POM xml updated

