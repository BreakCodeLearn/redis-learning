package redis.connection;

import redis.clients.jedis.Jedis;

public class RedisChallenge {

  public RedisChallenge() {
  }

  public static void main(final String[] args) {
    String hKey = "HimanRedisKey";
    Jedis hJed = null;
    RedisChallenge red = new RedisChallenge();
    red.connectAndInsertDataToRedis(hKey, hJed);
    red.printDataFromRedis(hKey, hJed);
  }

  private void connectAndInsertDataToRedis(String HimanRedisKey, Jedis jed) {
    // source-db
    try {
      jed = new Jedis("172.16.22.21", 16783);
      jed.auth("him-db0928-007!");
      System.out.println("Connection to source-db: SUCCESS: " + "PING-" + jed.ping());
    } catch (Exception e) {
      System.out.println("Connection to source-db: FAILED: " + e);
    }
    if (jed.exists(HimanRedisKey)) {
      System.out.println(
          HimanRedisKey + " : KEY already exist in the souce-db, so deleting it for the sake of this exercise.");
      jed.del(HimanRedisKey);
    }
    for (int i = 1; i <= 100; i++) {
      jed.zadd(HimanRedisKey, i, Integer.toString(i));
    }
    System.out.println("New data insertion to the redis source-db is complete!");
    jed.close();
  }

  private void printDataFromRedis(String HimanRedisKey, Jedis jed) {
    // replica-db
    try {
      jed = new Jedis("172.16.22.23", 11137);
      System.out.println("Connection to replica-db: SUCCESS: " + "PING-" + jed.ping());
      System.out.println("Printing data from the redis replica-db in the reverse order now...");
      System.out.println(jed.zrevrange(HimanRedisKey, 0, -1));
      jed.close();
    } catch (Exception e) {
      System.out.println("Connection to replica-db: FAILED: " + e);
    }
  }

}
