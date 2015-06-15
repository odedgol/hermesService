package com.ebay.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.ebay.dao.AggregationResendDAO;
import com.ebay.response.ResendResponse;
import com.ebay.response.ResendStatus;

/**
 * Created by Odedgol on 6/13/2015.
 */

@ContextConfiguration(locations = { "classpath:test-db-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class ProductServiceImplTest {

	@Mock
	private AggregationResendDAO aggregationResendDAO;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testResendProduct() throws Exception {
		String epid = "epid";
		ResendResponse resendResponse = new ResendResponse(epid, ResendStatus.Ok);
		Mockito.when(aggregationResendDAO.resendProductByEpid(epid))
				.thenReturn(resendResponse);
		productServiceImpl.resendProduct(epid);
		Mockito.verify(aggregationResendDAO).resendProductByEpid(epid);
	}
}