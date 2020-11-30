package JOSNUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * 反序列化操作：将输入流/字符串反序列为java对象
 * is 输入流
 * clazz  指定要反序列化的类型
 * <T>
 */

public class JsonUtil {
    private static final ObjectMapper MAPPER=new ObjectMapper();

    public static String serialize(Object o){
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("json反序列化失败"+o);
        }

    }

    public static <T> T deserialize(InputStream is, Class<T> clazz){
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("json反序列失败"+clazz.getName());
        }


    }
}
