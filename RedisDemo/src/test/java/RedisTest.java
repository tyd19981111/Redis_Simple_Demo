import com.tyd.service.ProvinceService;
import com.tyd.service.impl.ProvinceServiceImpl;
import com.tyd.util.JedisPoolUtils;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class RedisTest {
    @Test
    public void test(){

        Jedis jedis = JedisPoolUtils.getJedis();
        String ping = jedis.ping();
        System.out.println(ping);

    }



}
