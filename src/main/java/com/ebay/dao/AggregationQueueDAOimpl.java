package com.ebay.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Odedgol on 6/13/2015.
 */
@Repository("AggregationQueueDAO")
public class AggregationQueueDAOimpl extends AbstractDao implements AggregationQueueDAO {
    @Override
    public Query resendProductByEpid(String query) {
        return getSession().createQuery(query);
    }
}
