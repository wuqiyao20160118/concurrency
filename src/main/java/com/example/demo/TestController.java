package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // 标记TestController为Spring的Controller对象
@Slf4j
public class TestController {

    @RequestMapping("/test")  // @RequestMapping映射Request请求与处理器，@RequestParam绑定HttpServletRequest请求参数到控制器方法参数
    @ResponseBody  // 将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区
    public String test() {
        return "test";
    }
}
