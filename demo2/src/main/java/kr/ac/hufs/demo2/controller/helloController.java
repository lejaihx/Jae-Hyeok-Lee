package kr.ac.hufs.demo2.controller;

import kr.ac.hufs.demo2.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class helloController {
    @GetMapping("/hello")
    public String Hello(
            @RequestParam(defaultValue = "", required = true) String name,
            @RequestParam(defaultValue = "3", required = false) int age,
            @RequestParam(defaultValue = "4", required = false) int level) {
        return "Hello " + name + " age : " + age + " level : " +level;
    }

    @GetMapping("/query-hello")
        public String queryHello(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        sb.append("받은 값은 아래와 같습니다.\n");
        queryParam.forEach((key, value)-> {
            System.out.print(key);
            System.out.println(value);
            System.out.println("\n");

            sb.append(key + ":" + value + "\n");
        });

        sb.append("이상입니다.\n");

        return sb.toString();

    }

    @GetMapping("query-hello-object")
    public String queryHelloObject(UserRequest userRequest) {
        return userRequest.toString();
    }

    @GetMapping("/pathHello/{name}")
    public String pathHello(@PathVariable(name="name") String pathName) {
        return "hello " + pathName;
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "hi";
    }
}
