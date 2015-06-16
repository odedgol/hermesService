package com.ebay.mvc;

import java.sql.SQLException;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebay.exception.InvalidRequestException;
import com.ebay.response.DbResendResponse;
import com.ebay.response.ResendStatus;
import com.ebay.service.ProductService;

/**
 * Created by Odedgol on 6/6/2015.
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService ProductService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeHandler(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value = "/rest/resend/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> resendProduct(
			@RequestParam(value = "epid", required = true) String epid,
			final BindingResult bindingResult) throws SQLException {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Binding Result is Invalid",
					bindingResult);
		}
		DbResendResponse resendProduct = ProductService.resendProduct(epid);
		System.out.println(resendProduct.toString());
		if (resendProduct.getResendStatus().equals(ResendStatus.Error)) {
			throw new SQLException("database connection failed for epid ( "
					+ resendProduct.getEpid() + " )");

		}
		return new ResponseEntity<String>(String.valueOf(epid), HttpStatus.OK);
	}
}
