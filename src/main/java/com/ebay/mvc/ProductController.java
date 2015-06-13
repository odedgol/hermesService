package com.ebay.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Odedgol on 6/6/2015.
 */
@Controller
public class ProductController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomeHandler(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @ExceptionHandler(NullPointerException.class)
    @RequestMapping(value = "/rest/resend/", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<String> resendProduct(@RequestParam(value = "epid", required = true) String epid) {
      /*  if (org.apache.commons.lang3.StringUtils.isBlank(epid)) {
            return new ResponseEntity<String>("request must have at least one epid", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(String.valueOf(epid), HttpStatus.OK);*/
        return null;
    }
}
