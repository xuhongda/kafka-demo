import com.xu.pojo.DeviceStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author xuhongda on 2019/5/20
 * PACKAGE_NAME
 * kafka-demo
 */
@Slf4j
public class DsTest {

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {


        DeviceStatus deviceStatus = new DeviceStatus();
        Class<? extends DeviceStatus> deviceStatusClass = deviceStatus.getClass();
        Field[] declaredFields = deviceStatusClass.getDeclaredFields();
        Method[] methods = deviceStatusClass.getMethods();
        for (Field field : declaredFields) {
            field.set(deviceStatus, 1);
            System.out.println(field);
            /*for (Method method : methods){
                System.out.println(method);
                method.invoke(deviceStatusClass,);
            }*/
        }


    }


    @Test
    public void test2() throws IllegalAccessException {
        String str = "[deviceId=14144539046, objId=19051618141583200, alarmStatus=6, \n" +
                "posTime=2019-05-19 10:14:18.0, posLongitude=119.41116, posLatitude=32.386714, \n" +
                "posAltitude=null, posSpeed=0, accForward=0.3, accSide=1.0, accVerticle=-0.0, \n" +
                "powerVoltage=null, accStatus=null, softwareVersion=null, \n" +
                "updateStatusTime=2019-05-19 10:14:06.613, duration=null, \n" +
                "videoKey=null, videoUrl=null, multimediaId=null, vin=null, vinReport=null ,describe=null]";
        String replace = str.replace("[", "");
        String[] split = replace.split(",");

        Map<String, Object> map = new HashMap<>();

        for (String s : split) {
            String[] split1 = s.split("=");
            map.put(split1[0], split1[1]);
        }
        log.info("map = {}", map);


        DeviceStatus deviceStatus = new DeviceStatus();
        Class<? extends DeviceStatus> deviceStatusClass = deviceStatus.getClass();
        Field[] declaredFields = deviceStatusClass.getDeclaredFields();
        Method[] methods = deviceStatusClass.getMethods();

        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            log.info("key  ={}", next.trim());
            for (Field field : declaredFields) {
                Class<?> type = field.getType();
                log.info("type = {}", type);
                log.info("field = {}", field.getName());
                if (field.getName().equals(next.trim())) {
                    Object cast = type.cast(next.trim());
                    field.set(deviceStatus, cast);
                }

            }
        }
        log.info("DeviceStatus = {}", deviceStatus);
    }
}
