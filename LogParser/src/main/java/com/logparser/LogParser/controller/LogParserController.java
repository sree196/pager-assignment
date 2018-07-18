package com.logparser.LogParser.controller;


import com.logparser.LogParser.service.LogparserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;import java.io.IOException;


@RestController
@RequestMapping("/v1")
public class LogParserController {

    @Autowired
    LogparserService logparserService;

        @RequestMapping("/logparser")
        @ResponseBody
        String home(@RequestParam(value = "path") @ApiParam(required = true, value = "path") String path)
        {
            try {
                logparserService.PopulateRetreievedData(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Succes";
        }

}
