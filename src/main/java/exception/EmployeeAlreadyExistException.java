package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import java.util.UUID;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeAlreadyExistException extends RestClientException {
    public EmployeeAlreadyExistException(UUID accountId, UUID employeeId)  {
        super(String.format("Employee: '%s' already exist in account: '%s'", accountId, employeeId));
    }
}
