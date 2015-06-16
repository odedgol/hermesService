package com.ebay.service;

import com.ebay.model.bdo.AggregationResendDO;
import com.ebay.repository.AggregationResendRespository;
import com.ebay.response.ResendStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebay.response.DbResendResponse;

/**
 * Created by Odedgol on 6/13/2015.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory
            .getLogger(ProductServiceImpl.class);

    @Autowired
    AggregationResendRespository repository;

    @Override
    public DbResendResponse resendProduct(String epid) {
        DbResendResponse resendResponse;
        try {
            repository.save(new AggregationResendDO(epid));
            resendResponse = new DbResendResponse(epid, ResendStatus.Ok);
        } catch (Exception exception){
            logger.info("could not update Agg_Resend table with " + epid, exception);
            resendResponse = new DbResendResponse(epid, ResendStatus.Error);

        }
        return resendResponse;
    }
}
