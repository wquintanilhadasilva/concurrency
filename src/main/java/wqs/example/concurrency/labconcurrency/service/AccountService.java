package wqs.example.concurrency.labconcurrency.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import wqs.example.concurrency.labconcurrency.domain.Account;
import wqs.example.concurrency.labconcurrency.repository.Accountrepository;

@AllArgsConstructor
@Service
public class AccountService {

	private final Accountrepository accountrepository;

//	@Transactional(isolation = repeatable_read)
	public void transfer(UUID userid, int amountofmoney) {
		Account account = accountrepository.getOne(userid);
		account.setBalance(account.getBalance() - amountofmoney);
		accountrepository.save(account);
	}

}
