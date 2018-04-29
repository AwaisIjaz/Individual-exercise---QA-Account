package com.qa.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.QAAccount;
import com.qa.repository.QAAccountRepository;

@RestController
@RequestMapping("api/v1/")
public class QAAccountController {

	@Autowired
	private QAAccountRepository qaaccountrepository;
	
	@RequestMapping(value = "qaaccounts", method = RequestMethod.GET)
	public List<QAAccount> list(){
		return qaaccountrepository.findAll();
	}
	
	@RequestMapping(value = "qaaccounts", method = RequestMethod.POST)
	public QAAccount create(@RequestBody QAAccount qaaccount) {
		return qaaccountrepository.saveAndFlush(qaaccount);
	}
	
	@RequestMapping(value = "qaaccounts/{id}", method = RequestMethod.GET)
	public QAAccount get(@PathVariable Long id) {
		return qaaccountrepository.findOne(id);
	}
	
	@RequestMapping(value = "qaaccounts/{id}", method = RequestMethod.PUT)
		public QAAccount update(@PathVariable Long id, @RequestBody QAAccount qaaccount) {
		QAAccount existingQAAccount = qaaccountrepository.findOne(id);
		BeanUtils.copyProperties(qaaccount, existingQAAccount);
		return qaaccountrepository.saveAndFlush(existingQAAccount);
	}
	
	@RequestMapping(value = "qaaccounts/{id}", method = RequestMethod.DELETE)
	public QAAccount delete(@PathVariable Long id) {
		QAAccount existingQAAccount = qaaccountrepository.findOne(id);
		qaaccountrepository.delete(existingQAAccount);
		return existingQAAccount;
	}
}

