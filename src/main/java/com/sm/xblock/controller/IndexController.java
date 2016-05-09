package com.sm.xblock.controller;

import com.sm.xblock.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by smplayer on 2016/5/4.
 */
@Controller
public class IndexController {

    @Autowired
    private KeyService keyService;

    @RequestMapping("generate")
    @ResponseBody
    public String generate(){
        keyService.generate(6);
        return "generated";
    }

    @RequestMapping(value = "test/cal", method = RequestMethod.GET)
    public String cal(){
        return "jsp/test/index";
    }

    @RequestMapping(value = "test/cal", method = RequestMethod.POST)
    @ResponseBody
    public Integer cal(
            @RequestParam("a") Integer a,
            @RequestParam("type") String type,
            @RequestParam("b") Integer b
    ){
        if ("+".equals(type))
            return a + b;
        else if ("x".equals(type))
            return a * b;

        return a - b ;
    }

}
