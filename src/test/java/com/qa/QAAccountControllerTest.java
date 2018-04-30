package com.qa;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.qa.controller.QAAccountController;
import com.qa.model.QAAccount;
import com.qa.repository.QAAccountRepository;

public class QAAccountControllerTest {
	@InjectMocks
	private QAAccountController qc;
	
	@Mock
	private QAAccountRepository qaaccountrepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQAAccountGet() {
		QAAccount qa = new QAAccount();
		qa.setId(1l);
		when(qaaccountrepository.findOne(1l)).thenReturn(qa);
		
		QAAccount account = qc.get(1l);
		
		verify(qaaccountrepository).findOne(1l);
		//assertEquals(1l, account.getId().longValue());
		assertThat(account.getId(), is(1l));
	}
}
