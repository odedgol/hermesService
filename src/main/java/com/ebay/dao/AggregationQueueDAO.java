package com.ebay.dao;

import org.hibernate.Query;

/**
 * Created by Odedgol on 6/13/2015.
 */
public interface AggregationQueueDAO {

    public Query resendProductByEpid(String query);
}
