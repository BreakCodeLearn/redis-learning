package redis.connection;

import redis.clients.jedis.Jedis;

public class RedisChallenge {

  public RedisChallenge() {
  }

  public static void main(final String[] args) {
    String hKey = "HimKey";
    RedisChallenge red = new RedisChallenge();
    red.connectAndInsertData(hKey);
    red.printData(hKey);
  }

  private void connectAndInsertData(String himKey) {
    // source-db
    Jedis jedis = new Jedis("172.16.22.21", 16783);
    try {
      jedis.auth("him-db0928-007!");
      System.out.println("Connection to source-db: SUCCESS: " + "PING-" + jedis.ping());
    } catch (Exception e) {
      System.out.println("Connection to source-db: FAILED: " + e);
    }
    if (jedis.exists(himKey)) {
      System.out
          .println(himKey + " : KEY already exist in the souce-db, so deleting it for the sake of this exercise.");
      jedis.del(himKey);
    }
    for (int i = 1; i <= 100; i++) {
      jedis.zadd(himKey, i, Integer.toString(i));
    }
    System.out.println("New data insertion to the redis source-db is complete!");
    jedis.close();
  }

  private void printData(String himKey) {
    // replica-db
    try {
      Jedis jedisReplica = new Jedis("172.16.22.23", 11137);
      System.out.println("Connection to replica-db: SUCCESS: " + "PING-" + jedisReplica.ping());
      System.out.println("Printing data from the redis replica-db in the reverse order now...");
      System.out.println(jedisReplica.zrevrange(himKey, 0, -1));
      jedisReplica.close();
    } catch (Exception e) {
      System.out.println("Connection to replica-db: FAILED: " + e);
    }
  }

}
