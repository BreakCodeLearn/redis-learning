package redis.connection;

import redis.clients.jedis.Jedis;

public class RedisChallenge {

  public RedisChallenge() {
  }

  public static void main(final String[] args) throws Exception {
    String hKey = "HimKey";
    // source-db
    Jedis jedis = new Jedis("172.16.22.21", 16783);
    jedis.auth("himanshu");
    jedis.flushAll();
    for (int i = 1; i <= 100; i++) {
      jedis.rpush(hKey, Integer.toString(i));
    }
    // System.out.println(jedis.lrange(hKey, 0, -1));
    jedis.close();

    // replica-db
    Jedis jedisRep = new Jedis("172.16.22.23", 11137);
    for (int i = 99; i >= 0; i--) {
      System.out.println(jedisRep.lindex(hKey, i));
    }
    jedisRep.close();
  }
}
