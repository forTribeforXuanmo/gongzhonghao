package test;

import com.zyiot.gongzhonghao.utils.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-7-21.
 */
public class JedisTest {
    private Jedis jedis;

    @Before
    public void setUp() {
        jedis = RedisUtil.getJedis();
    }

    @Test
    public void testString() {
        jedis.set("name", "lsz");
        System.out.println(jedis.get("name"));

        jedis.append("name", ".com");
        System.out.println(jedis.get("name"));

        jedis.del("name");
        System.out.println(jedis.get("name"));

        jedis.mset("name", "lsz", "age", "23", "qq", "530735771");
        jedis.incr("age");
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "quanmo");
        map.put("age", "20");
        map.put("sex", "女");
        String user = jedis.hmset("user", map);
        List<String> hmget = jedis.hmget("user", "name", "age", "sex", "heh");
        System.out.println(hmget);

        jedis.hdel("user", "name");
        System.out.println(jedis.hmget("user", "age") + " -" + jedis.hlen("user")
                + "-" + jedis.hkeys("user") + "-" + jedis.hvals("user"));

    }

    @Test
    public void testList() {
        System.out.println(jedis.configGet("databases"));
        jedis.del("java framework");
        //依次往左边放
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.del("java framework");
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "mybatis");
        System.out.println(jedis.lrange("java framework", 0, -1));
        //依次往右边放
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "mybatis");
        System.out.println(jedis.lrange("java framework", 0, -1));
    }

    @Test
    public void testSet() {
        jedis.del("user");
        jedis.sadd("user", "zhangsan");
        jedis.sadd("user", "lisi");
        jedis.sadd("user", "wanger");
        jedis.sadd("user", "mazi");
        jedis.srem("user", "mazi");
        System.out.println(jedis.smembers("user"));
        System.out.println(jedis.sismember("user", "mazi"));
        System.out.println(jedis.srandmember("user"));
        System.out.println(jedis.scard("user"));
    }
}
