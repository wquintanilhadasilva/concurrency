package wqs.example.concurrency.labconcurrency.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.antkorwin.xsync.XSync;

import lombok.AllArgsConstructor;
import wqs.example.concurrency.labconcurrency.domain.Result;

@AllArgsConstructor
@Service
public class PaymentService {

	private final ExternalCashbackService externalcashbackservice;
	private final  AccountService accountservice;
	private final XSync<UUID> xsync;

	public void withDrawMoney(UUID userid, int amountofmoney) {
		xsync.execute(userid, () -> {
			Result result = externalcashbackservice.evaluatecashback(userid, amountofmoney);
			accountservice.transfer(userid, amountofmoney + result.getCashBackAmount());
			externalcashbackservice.cashbackcomplete(userid, result.getCashBackAmount());
		});
	}

}
