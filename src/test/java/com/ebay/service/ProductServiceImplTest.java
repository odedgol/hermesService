package com.ebay.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;

import com.ebay.model.bdo.AggregationResendDO;
import com.ebay.repository.AggregationResendRespository;
import com.ebay.response.DbResendResponse;
import com.ebay.response.ResendStatus;

/**
 * Created by Odedgol on 6/13/2015.
 */

public class ProductServiceImplTest {

	@Mock
	private AggregationResendRespository aggregationResendRespository;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testResendProductFail() throws Exception {
		String epid = "epid";
		DbResendResponse resendResponse = new DbResendResponse(epid, ResendStatus.Error);
		Mockito.when(aggregationResendRespository.save(Mockito.any(AggregationResendDO.class)))
				.thenThrow(new MockitoException(epid));
		DbResendResponse actualResponse = productServiceImpl.resendProduct(epid);
		Assert.assertThat(actualResponse, Matchers.equalTo(resendResponse));
	}
	
	@Test
	public void testResendProductSuccess() throws Exception {
		String epid = "epid";
		DbResendResponse resendResponse = new DbResendResponse(epid, ResendStatus.Ok);
		DbResendResponse actualResponse = productServiceImpl.resendProduct(epid);
		Assert.assertThat(actualResponse, Matchers.equalTo(resendResponse));
	}
	
}