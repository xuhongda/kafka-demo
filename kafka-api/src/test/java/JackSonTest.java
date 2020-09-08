import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhongda on 2020/9/8
 * PACKAGE_NAME
 * kafka-demo
 */
public class JackSonTest {

    @Test
    public void test001() throws JsonProcessingException {

        Map<String,Object> map = new HashMap<>();
        Map<String,Object> params = new HashMap<>();
        params.put("id",123);
        params.put("name","xu");
        map.put("cmd","xxx");
        map.put("params",params);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }
}
