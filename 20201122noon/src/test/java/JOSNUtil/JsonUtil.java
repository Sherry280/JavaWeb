package JOSNUtil;

import org.junit.Assert;
import org.junit.Test;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    /**
     * 单元测试：使用
     */
    @Test
    public void testSerialize(){
        Map map=new HashMap();
        map.put("name","java40");
        map.put("students",new int[]{1,2});
        //String json= JsonUtil.serialize(map);
//        System.out.println(json);
//        Assert.assertNotNull(json);

    }




    @Test
    public void testDeserialize(){
        InputStream is = JsonUtil.class.getClassLoader().getResourceAsStream("login.json");
//        Map map=
    }

}
