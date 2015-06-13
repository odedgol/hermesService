package com.ebay.service;

import com.ebay.dao.AggregationQueueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Odedgol on 6/13/2015.
 */
@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    AggregationQueueDAO aggregationQueueDAO;

    @Override
    public void resendProduct(String epid) {
        aggregationQueueDAO.resendProductByEpid(epid);
    }
}
