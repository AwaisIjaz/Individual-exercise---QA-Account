package com.qa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qa.model.QAAccount;

public class QAAccountStub {
	private static Map<Long, QAAccount> acts = new HashMap<Long, QAAccount>();
	private static Long idIndex = 3L;
	
	static {
		QAAccount a = new QAAccount(1L, "Awais", "Ijaz", "1234");
		acts.put(1L, a);
		
		QAAccount b = new QAAccount(2L, "John", "Smith", "1235");
		acts.put(2L, b);
		
		QAAccount c = new QAAccount(3L, "Jodie", "Smith", "1236");
		acts.put(3L, c);	
	}
	
	public static List<QAAccount> list() {
		return new ArrayList<QAAccount>(acts.values());
	}
	
	public static QAAccount create(QAAccount act) {
		idIndex += idIndex;
		act.setId(idIndex);
		acts.put(idIndex, act);
		return act;
	}
	
	public static QAAccount get(Long id) {
		return acts.get(id);
	}
	
	public static QAAccount update(Long id, QAAccount act) {
		acts.put(id, act);
		return act;
	}
	
	public static QAAccount delete(Long id) {
		return acts.remove(id);
	}

}

