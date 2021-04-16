package wqs.example.concurrency.labconcurrency.repository;

import java.util.UUID;

import org.springframework.stereotype.Service;

import wqs.example.concurrency.labconcurrency.domain.Account;

@Service
public class Accountrepository {
	
	private Account account;
	
	public Account getOne(UUID uid) {
		this.account = new Account(uid, 100d);
		return account;
	}
	
	public void save(Account account) {
		this.account = account;
	}

}
