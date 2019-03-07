package com.hamlt.springboot.controller;

import com.hamlt.springboot.bean.ObjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot 不建议使用jsp
 */
@RestController
@RequestMapping(value="/pro")
public class PropertisController {

    @Autowired
    private Environment env;

    @Value("${pro.key}")
    private String key;

    @Autowired
    ObjectProperties objectProperties;

    @RequestMapping(value="/get", method= RequestMethod.GET)
    public Map<String, Object> getProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", env.getProperty("pro.test.key"));
        map.put("key2", key);
        map.put("code", env.getProperty("pro.test.code")); //null
        map.put("objectProperties", objectProperties);
        return map;
    }

}
