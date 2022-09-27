package com.log.poc.logpoc;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/")
    public String index(@RequestHeader Map<String, String> headers) {
    	
    	MDC.put("type", "App_Log");	
    	
    	MDC.setContextMap(headers);
    	
    	logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        
    	
    	MDC.getCopyOfContextMap().get("").toCharArray(); 
    	
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        
        

        return "Howdy! Check out the Logs to see the output...";
    }
}
