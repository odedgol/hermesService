package com.ebay.repository;

import com.ebay.model.AggregationResend;
import com.ebay.response.ResendResponse;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Odedgol on 6/15/2015.
 */
public interface AggregationResendRespository extends CrudRepository<AggregationResend, Long> {

    /**
     * @param persisted
     * @return AggregationResend
     */
    AggregationResend save(AggregationResend persisted);

}
