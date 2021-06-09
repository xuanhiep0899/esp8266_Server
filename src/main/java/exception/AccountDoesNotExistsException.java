package exception;

import org.springframework.web.client.RestClientException;

public class AccountDoesNotExistsException extends RestClientException {

    public AccountDoesNotExistsException(String msg) {
        super(msg);
    }
}
