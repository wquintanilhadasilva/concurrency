package wqs.example.concurrency.labconcurrency.service;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import wqs.example.concurrency.labconcurrency.domain.RequestDto;
import wqs.example.concurrency.labconcurrency.domain.ResponseDto;
import wqs.example.concurrency.labconcurrency.domain.Result;

@AllArgsConstructor
@Service
public class ExternalCashbackService {

	private final RestTemplate resttemplate;

	public Result evaluatecashback(UUID userid, int amountofmoney) {
		return sendRestRequest("evaluate", userid, amountofmoney);
	}

	public Result cashbackcomplete(UUID userid, int cashbackamount) {
		return sendRestRequest("complete", userid, cashbackamount);
	}

	private Result sendRestRequest(String action, UUID userid, int value) {

		URI externalcashbacksystemurl = URI.create("http://cash-back-system.org/api/" + action);
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", MediaType.APPLICATION_JSON_VALUE);
		RequestDto requestdto = new RequestDto(userid, value);
		HttpEntity<?> request = new HttpEntity<>(requestdto, headers);

		ResponseDto responsedto = resttemplate
				.exchange(externalcashbacksystemurl, HttpMethod.GET, request, ResponseDto.class).getBody();

		return new Result(responsedto.getStatus(), responsedto.getValue());
	}

}
