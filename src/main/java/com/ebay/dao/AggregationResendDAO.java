package com.ebay.dao;

import java.util.List;

import com.ebay.response.ResendResponse;

public interface AggregationResendDAO {
	
	public ResendResponse resendProductByEpid(String epid);
    
    public ResendResponse resendProductsByEpids(List<String> epid);


}
