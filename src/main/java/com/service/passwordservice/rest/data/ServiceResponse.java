package com.service.passwordservice.rest.data;

/**
 * 
 * @author Gopinadh
 *
 * @param <T>
 */
public class ServiceResponse<T> {
	private static final String SUCCESS = "Success";
	private static final String FAILED = "Failed";

	private long in;
	private long out;
	private long ts;
	private String status;
	private String msg;
	private String description;

	private T payload;

	public long getIn() {
		return in;
	}

	public void setIn(long in) {
		this.in = in;
	}

	public long getOut() {
		return out;
	}

	public void setOut(long out) {
		this.out = out;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSuccess() {
		this.status = SUCCESS;
	}

	public void setFail(String desc) {
		this.status = FAILED;
		this.description = desc;
	}


}

