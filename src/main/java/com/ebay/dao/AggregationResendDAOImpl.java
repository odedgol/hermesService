package com.ebay.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ebay.model.AggregationResend;
import com.ebay.response.ResendResponse;
import com.ebay.response.ResendStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository("AggregationResendDAO")
public class AggregationResendDAOImpl extends AbstractDao implements
		AggregationResendDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AggregationResendDAOImpl.class);

	@Override
	public ResendResponse resendProductByEpid(String epid) {
		AggregationResend aggregationResend = new AggregationResend();
		aggregationResend.setEpid(epid);
		ResendResponse resendResponse;
		try {
			getSession().persist(aggregationResend);
			resendResponse = new ResendResponse(epid, ResendStatus.Ok);
		} catch (Exception e) {
			logger.info("could not update Agg_Resend table with " + epid, e);
			resendResponse = new ResendResponse(epid, ResendStatus.Error);
		}
		return resendResponse;
	}

	@Override
	public ResendResponse resendProductsByEpids(List<String> epid) {
		// TODO NOT IMPLENETED YET
		return null;
	}

}
