package com.ebay.repository;

import com.ebay.model.DO.AggregationResendDO;
import com.ebay.response.DbResendResponse;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Odedgol on 6/15/2015.
 */
public interface AggregationResendRespository extends CrudRepository<AggregationResendDO, Long> {

    /**
     * @param persisted
     * @return AggregationResend
     */
    @SuppressWarnings("unchecked")
	AggregationResendDO save(AggregationResendDO persisted);

}
