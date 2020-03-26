package com.xh.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 * @date 2020/3/17
 */
@Service
public class MyService {
	@Autowired
	private MyRepository myRepository;

	public MyRepository getMyRepository() {
		return myRepository;
	}

	public void setMyRepository(MyRepository myRepository) {
		this.myRepository = myRepository;
	}
}
