package com.ebay.service;
import com.ebay.dao.AggregationQueueDAO;
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

import static org.junit.Assert.*;

/**
 * Created by Odedgol on 6/13/2015.
 */
@ContextConfiguration(locations = {"classpath:test-db-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

    // Create Mock

    @Mock
    private AggregationQueueDAO aggregationQueueDAO;

    @InjectMocks
    @Autowired
    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testResendProduct() throws Exception {
        Mockito.verifyZeroInteractions(aggregationQueueDAO);
    }
}