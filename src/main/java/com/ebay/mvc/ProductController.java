package com.ebay.mvc;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebay.response.DbResendResponse;
import com.ebay.response.ResendStatus;
import com.ebay.service.ProductService;

/**
 * Created by Odedgol on 6/6/2015.
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService ProductService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeHandler(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value = "/resend/{epid}", method = RequestMethod.POST)
	public Message resendProduct(@PathVariable String epid) throws SQLException {
		
		DbResendResponse resendProduct = ProductService.resendProduct(epid);
		if (resendProduct.getResendStatus().equals(ResendStatus.Error)) {
			return new Message(epid, ResendStatus.Error);

		}
		return new Message(epid, ResendStatus.Ok);
	}

}
