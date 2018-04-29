package com.qa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.QAAccount;

@RestController
@RequestMapping("api/v1/")
public class QAAccountController {

	@RequestMapping(value = "qaaccounts", method = RequestMethod.GET)
	public List<QAAccount> list(){
		return QAAccountStub.list();
	}
	
	@RequestMapping(value = "qaaccounts", method = RequestMethod.POST)
	public QAAccount create(@RequestBody QAAccount qaaccount) {
		return QAAccountStub.create(qaaccount);
	}
	
	@RequestMapping(value = "qaaccounts/{id}", method = RequestMethod.GET)
	public QAAccount get(@PathVariable Long id) {
		return QAAccountStub.get(id);
	}
	
	@RequestMapping(value = "qaaccounts/{id}", method = RequestMethod.PUT)
		public QAAccount update(@PathVariable Long id, @RequestBody QAAccount qaaccount) {
		return QAAccountStub.update(id, qaaccount);
	}
	
	@RequestMapping(value = "qaaccounts/{id}", method = RequestMethod.DELETE)
	public QAAccount delete(@PathVariable Long id) {
		return QAAccountStub.delete(id);
	}
}

