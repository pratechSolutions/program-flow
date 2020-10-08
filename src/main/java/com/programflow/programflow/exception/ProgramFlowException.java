package com.programflow.programflow.exception;

import lombok.Getter;

@Getter
public class ProgramFlowException extends RuntimeException {

    private final ErrorType errorType;

    public ProgramFlowException(ErrorType errorType) {
        this.errorType = errorType;
    }
}
