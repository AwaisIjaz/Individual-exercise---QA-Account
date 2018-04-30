package com.qa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.controller.QAAccountController;
import com.qa.model.QAAccount;

public class QAAccountControllerTest {
	@Test
	public void testQAAccountGet() {
		QAAccountController qc = new QAAccountController();
		QAAccount account = qc.get(1L);
		assertEquals(1L, account.getId().longValue());
		
		
		
	}
}
