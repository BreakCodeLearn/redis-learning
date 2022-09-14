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


Click on the provided IDE, locate the 'RedisChallenge' java file and execute/run the program. 
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

The outout of the program should be:
```zsh
Connection to source-db: SUCCESS: PING-PONG
HimanRedisKey : KEY already exist in the souce-db, so deleting it for the sake of this exercise.
New data insertion to the redis source-db is complete!
Connection to replica-db: SUCCESS: PING-PONG
Printing data from the redis replica-db in the reverse order now...
[100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 
70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 
40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 
10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
```

Note: Install the extensions like Maven for Java as needed. Additional configurations might be needed to work with Redis in the local environment.
