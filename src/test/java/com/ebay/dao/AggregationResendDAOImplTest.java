package com.ebay.dao;

import javax.transaction.Transactional;

import org.hamcrest.Matchers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebay.response.ResendResponse;
import com.ebay.response.ResendStatus;

public class AggregationResendDAOImplTest {

	@Mock
	private SessionFactory sessionFactory;

	@InjectMocks
	private AggregationResendDAO aggregationResendDAO;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void resendProductByEpidSucessfully() {

		String epid = "1234";

		
		Mockito.when(sessionFactory.getCurrentSession()).thenReturn(SessionMock);

		ResendResponse resendResponse = aggregationResendDAO
				.resendProductByEpid(epid);
		Assert.assertThat(resendResponse,
				Matchers.equalTo(new ResendResponse("1234", ResendStatus.Ok)));
	}

}
