package com.tech.eleccomm.application.exceptions;

import java.io.Serializable;
import java.net.http.HttpHeaders;

public class HttpException extends RuntimeException implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9177000942020800324L;
	private final Integer code;
    private transient HttpHeaders headers;
    private final String body;

    public HttpException(String message) {
        super(message);
        this.code = null;
        this.body = null;
        this.headers = null;
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
        this.code = null;
        this.body = null;
        this.headers = null;
    }

    public HttpException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.body = null;
        this.headers = null;
    }

    public HttpException(Integer code, String message, String body, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.body = body;
        this.headers = null;
    }

    public HttpException(Integer code, String message, String body, HttpHeaders headers, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.body = body;
        this.headers = headers;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getBody() {
        return this.body;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }
}