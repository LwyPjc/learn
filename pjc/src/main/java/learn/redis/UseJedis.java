package learn.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import tools.PrintStreamUtil;

import java.util.Map;
import java.util.Set;

/**
 * Jedis 直连
 * 连接池
 */
public class UseJedis {

    @Test
    public void testJedis() {
        jedis();
    }

    private void jedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> keys = jedis.keys("*");
        PrintStreamUtil.printObject(keys);
        Map<String, String> use1 = jedis.hgetAll("use1");
        PrintStreamUtil.printObject(use1);
        jedis.close();
    }

    private void useJedisPool() {

    }

}
