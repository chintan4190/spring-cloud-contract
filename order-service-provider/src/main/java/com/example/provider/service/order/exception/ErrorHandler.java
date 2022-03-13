package com.example.provider.service.order.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public FaultMessage handleSystemException(final Exception exception) {
        log.error("Internal system error occurred. {}", "999", exception);
        final FaultMessage faultMessage = new FaultMessage("999", "Internal error");
        return faultMessage;
    }

    @ExceptionHandler({OrderException.class})
    @ResponseStatus(BAD_REQUEST)
    public FaultMessage handleOrderException(final OrderException exception) {
        log.error("Internal system error occurred. {}", "999", exception);
        final FaultMessage faultMessage = new FaultMessage("100", exception.getMessage());
        return faultMessage;
    }
}
