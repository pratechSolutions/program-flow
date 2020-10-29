package com.programflow.programflow.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ErrorType {
    MANDATORY_FIELD_IS_NULL(1000, "This field can not be blank", NOT_ACCEPTABLE),
    INTERNAL_ERROR(1001, "An internal server error occurred", INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER_ERROR(1002, "Invalid field(s). ", NOT_ACCEPTABLE),
    PHONE_NUMBER_ALREADY_EXISTS(1005, "Phone number already exists.", NOT_ACCEPTABLE),
    USER_NOT_FOUND(1006, "User not found", BAD_REQUEST),
    USER_SERVICE_UNREACHABLE(1007, "User Service is unreachable", INTERNAL_SERVER_ERROR),
    USER_WS_BAD_REQUEST(1008, "User Service Bad Request", INTERNAL_SERVER_ERROR),
    USER_SERVICE_BAD_REQUEST(1023, "User Service Bad Request Error", INTERNAL_SERVER_ERROR),
    USER_SERVICE_INTERNAL_ERROR(1024, "User Service Internal Error", INTERNAL_SERVER_ERROR),
    USER_SERVICE_POST_INTERNAL_ERROR(1025, "User Service Internal Error", INTERNAL_SERVER_ERROR),
    NO_DATA_FOUND(1026, "No data found", BAD_REQUEST),
    EMAIL_SERVICE_ERROR(1027, "An error occurred in the email service", INTERNAL_SERVER_ERROR),
    EMAIL_SERVICE_BAD_REQUEST(1028, "Email service returned request as a bad request", BAD_GATEWAY),
    ASSEMBLY_NOT_FOUND(1030, "Assembly not found", BAD_REQUEST),
    COMPANY_NOT_APPROVED(1032, "The Company is not approved. You are not allowed to take an action!", UNAUTHORIZED),
    USER_HAS_ALREADY_ASSEMBLY(1035, "The user has already an assembly", BAD_REQUEST),
    USER_IS_NOT_VERIFIED(1036, "The user is not verified.", UNAUTHORIZED),
    NOT_ALLOWED_UPDATE(1038, "You are not allowed to update information", UNAUTHORIZED),
    INVALID_COUNTRY(1039, "Invalid country name.", NOT_ACCEPTABLE),
    ASSEMBLY_LINK_ALREADY_EXISTS(1040, "The company already exist", NOT_ACCEPTABLE),
    EMAIL_ALREADY_EXISTS(1041, "Email already exist", NOT_ACCEPTABLE);

    //    FILE_CANNOT_BE_DELETED(1009, "File cannot be deleted", INTERNAL_SERVER_ERROR),
//    FILE_NAME_CONTAINS_INVALID_PATH_SEQUENCE(1013, "File contains invalid path Sequence", INTERNAL_SERVER_ERROR),
//    FILE_READ_ERROR(1014, "File couldn't read", INTERNAL_SERVER_ERROR),
//    FILE_UPLOAD_EMPTY_FILE(1016, "File is empty ", INTERNAL_SERVER_ERROR),
//    MAX_NUMBER_OF_FILES_PER_REQUEST_EXCEEDED(1017, "Not allowed more than 5 files per request", INTERNAL_SERVER_ERROR),
//    MAX_NUMBER_OF_FILES_PER_COMPANY_EXCEEDED(1018, "Not allowed more than 5 files per company", INTERNAL_SERVER_ERROR),
//    NOT_ALLOWED_PROCESS_FILE(1019, "No permission to file process.", UNAUTHORIZED),
//    FILE_NOT_FOUND(1020, "File not found", NOT_FOUND),
//    AWS_FILE_UPLOAD_ERROR(1021, "File couldn't be uploaded to AWS", INTERNAL_SERVER_ERROR),
//    AWS_FILE_DOWNLOAD_ERROR(1022, "The file couldn't be downloaded from Amazon S3", INTERNAL_SERVER_ERROR),
//    APPLICATION_NOT_FOUND(1029, "Application cannot be found", BAD_REQUEST),

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
}
