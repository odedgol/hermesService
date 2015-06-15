package com.ebay.service;

import com.ebay.model.AggregationResend;
import com.ebay.repository.AggregationResendRespository;
import com.ebay.response.ResendStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebay.response.ResendResponse;

/**
 * Created by Odedgol on 6/13/2015.
 */

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory
            .getLogger(ProductServiceImpl.class);

    @Autowired
    AggregationResendRespository repository;

    @Override
    public ResendResponse resendProduct(String epid) {
        ResendResponse resendResponse;
        try {
            repository.save(new AggregationResend(epid));
            resendResponse = new ResendResponse(epid, ResendStatus.Ok);
        } catch (Exception exception){
            logger.info("could not update Agg_Resend table with " + epid, exception);
            resendResponse = new ResendResponse(epid, ResendStatus.Error);

        }
        return resendResponse;
    }
}
