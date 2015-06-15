package com.ebay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebay.dao.AggregationResendDAO;
import com.ebay.response.ResendResponse;

/**
 * Created by Odedgol on 6/13/2015.
 */
@Transactional
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private AggregationResendDAO aggregationResendDAO;

    @Override
    public ResendResponse resendProduct(String epid) {
        return aggregationResendDAO.resendProductByEpid(epid);
    }
}
