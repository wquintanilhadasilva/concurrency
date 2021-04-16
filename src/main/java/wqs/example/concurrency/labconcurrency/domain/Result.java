package wqs.example.concurrency.labconcurrency.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
	
	private int status;
	private double value;
	private int cashBackAmount;
	
	public Result(int status, double value) {
		this.status = status;
		this.value = value;
	}
	
}
