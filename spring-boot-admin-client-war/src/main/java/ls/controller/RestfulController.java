package ls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ls-springcloud
 * @author: lishuai
 * @create: 2020-10-24 20:51
 */
@RestController
public class RestfulController {
    @GetMapping("/restful/name/{time}")
    public Object test(@PathVariable("time")Integer time) {
        Map<String,String> map = new HashMap<>();
        try {
            Thread.sleep(time * 1000l);//根据参数来决定休息多久
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("name","lishuai");
        return map;
    }
}
