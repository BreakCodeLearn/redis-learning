package redis.connection;

import redis.clients.jedis.Jedis;

public class RedisChallenge {

  public RedisChallenge() {
  }

  public static void main(final String[] args) throws Exception {
    RedisData();
  }

  private static void RedisData() {
    String hKey = "HimKey";
    // source-db
    Jedis jedis = new Jedis("172.16.22.21", 16783);
    jedis.auth("himanshu");
    jedis.flushAll();
    for (int i = 1; i <= 100; i++) {
      jedis.zadd(hKey, i, Integer.toString(i));
    }
    jedis.close();
    // replica-db
    Jedis jedisReplica = new Jedis("172.16.22.23", 11137);
    System.out.println(jedisReplica.zrevrange(hKey, 0, -1));
    jedisReplica.close();
  }

}
