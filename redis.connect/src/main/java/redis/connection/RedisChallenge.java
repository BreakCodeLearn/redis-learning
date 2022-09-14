package redis.connection;

import redis.clients.jedis.Jedis;

public class RedisChallenge {

  public RedisChallenge() {
  }

  public static void main(final String[] args) {
    String hKey = "HimanRedisKey";
    RedisChallenge red = new RedisChallenge();
    red.connectAndInsertDataToRedis(hKey);
    red.printDataFromRedis(hKey);
  }

  private void connectAndInsertDataToRedis(String HimanRedisKey) {
    // source-db
    Jedis jedis = new Jedis("172.16.22.21", 16783);
    try {
      jedis.auth("him-db0928-007!");
      System.out.println("Connection to source-db: SUCCESS: " + "PING-" + jedis.ping());
    } catch (Exception e) {
      System.out.println("Connection to source-db: FAILED: " + e);
    }
    if (jedis.exists(HimanRedisKey)) {
      System.out.println(
          HimanRedisKey + " : KEY already exist in the souce-db, so deleting it for the sake of this exercise.");
      jedis.del(HimanRedisKey);
    }
    for (int i = 1; i <= 100; i++) {
      jedis.zadd(HimanRedisKey, i, Integer.toString(i));
    }
    System.out.println("New data insertion to the redis source-db is complete!");
    jedis.close();
  }

  private void printDataFromRedis(String HimanRedisKey) {
    // replica-db
    try {
      Jedis jedisReplica = new Jedis("172.16.22.23", 11137);
      System.out.println("Connection to replica-db: SUCCESS: " + "PING-" + jedisReplica.ping());
      System.out.println("Printing data from the redis replica-db in the reverse order now...");
      System.out.println(jedisReplica.zrevrange(HimanRedisKey, 0, -1));
      jedisReplica.close();
    } catch (Exception e) {
      System.out.println("Connection to replica-db: FAILED: " + e);
    }
  }

}
