package com.xuecheng.manage_cms.dao;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/26
*/

        import net.minidev.json.writer.CollectionMapper;
        import org.junit.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.client.RestTemplate;
        import sun.text.normalizer.UBiDiProps;

        import java.util.Map;

public class RestTemplateTest {
    @Autowired
    RestTemplate restTemplate;
    @Test
    public void testRestTemplate(){
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        System.out.println(body);
    }
}
