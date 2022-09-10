package redis.connection;

import redis.clients.jedis.Jedis;

public class RedisChallenge {

  public RedisChallenge() {
  }

  public static void main(final String[] args) throws Exception {
    // source-db
    final Jedis jedis = new Jedis("172.16.22.21", 16783);
    jedis.auth("himanshu");
    jedis.flushAll();
    for (int i = 1; i <= 100; i++) {
      jedis.rpush("myKey", Integer.toString(i));
    }
    jedis.close();

    // replica-db
    final Jedis jedisRep = new Jedis("172.16.22.23", 11137);
    for (int i = 100; i >= 1; i--) {
      System.out.println(jedisRep.lindex("myKey", i));
    }
    jedisRep.close();
  }
}
