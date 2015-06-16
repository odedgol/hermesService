package com.ebay.service;

import com.ebay.response.DbResendResponse;

/**
 * Created by Odedgol on 6/13/2015.
 */
public interface ProductService {

	public DbResendResponse resendProduct(String epid);
}
