package wqs.example.concurrency.labconcurrency.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import wqs.example.concurrency.labconcurrency.domain.Account;

@Component
public class Accountrepository {
	
	public Account getOne(UUID uid) {
		return null;
	}
	
	public void save(Account account) {
		
	}

}
