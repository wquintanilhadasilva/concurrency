package wqs.example.concurrency.labconcurrency.domain;

import java.util.UUID;

import lombok.Data;

@Data
public class RequestDto {
	
	private UUID userId;
	private int value;

	public RequestDto(UUID userid, int value) {
	}

}
