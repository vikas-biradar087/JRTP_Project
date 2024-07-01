package com.Capagamini.binding;

import lombok.Data;

@Data
public class ElgResponse {

	
	private Long totalTriggers;
    private Long succTriggers;
    private Long failedTriggers;
    
	public Long getTotalTriggers() {
		return totalTriggers;
	}
	public void setTotalTriggers(Long totalTriggers) {
		this.totalTriggers = totalTriggers;
	}
	public Long getSuccTriggers() {
		return succTriggers;
	}
	public void setSuccTriggers(Long succTriggers) {
		this.succTriggers = succTriggers;
	}
	public Long getFailedTriggers() {
		return failedTriggers;
	}
	public void setFailedTriggers(Long failedTriggers) {
		this.failedTriggers = failedTriggers;
	}
	

	

}
