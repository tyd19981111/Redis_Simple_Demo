import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyd.entity.Province;
import com.tyd.service.ProvinceService;
import com.tyd.service.impl.ProvinceServiceImpl;
import com.tyd.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class JDBCTest {
    @Test
    public void test() throws JsonProcessingException {
//        try {
//            // 1.加载配置文件
//            Properties pro = new Properties();
//            //使用ClassLoader加载配置文件，获取字节输入流
//            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
//            pro.load(is);
//
//            // 2.初始化连接池对象
//            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }
}
