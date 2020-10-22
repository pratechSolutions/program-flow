package com.programflow.programflow.service.impl;

import com.programflow.programflow.dto.UserDto;
import com.programflow.programflow.exception.ErrorType;
import com.programflow.programflow.exception.ProgramFlowException;
import com.programflow.programflow.service.WebClientUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

@Service
@Slf4j
public class WebClientUserServiceImpl implements WebClientUserService {

    private final WebClient webClient;

    public WebClientUserServiceImpl(@Value("${usermanager.url}") String userBaseUrl,
                                    WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder
                .baseUrl(userBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    @Override
    public Optional<UserDto> findByUserId(String userId) {
        UserDto userDto = webClient.get()
                .uri("/v1/user/" + userId)
                .retrieve()
                .onStatus(httpStatus -> httpStatus.equals(HttpStatus.UNAUTHORIZED),
                        response -> Mono.error(new ProgramFlowException(ErrorType.USER_IS_NOT_VERIFIED)))
                .onStatus(HttpStatus::is4xxClientError,
                        response -> Mono.error(new ProgramFlowException(ErrorType.USER_SERVICE_BAD_REQUEST)))
                .onStatus(HttpStatus::is5xxServerError,
                        response -> Mono.error(new ProgramFlowException(ErrorType.USER_SERVICE_INTERNAL_ERROR)))
                .bodyToMono(UserDto.class)
                .block(Duration.ofSeconds(20));
        return Optional.ofNullable(userDto);
    }

    @Override
    public void updateUser(UserDto userDto, String userId) {

    }

//    @Override
//    public void updateUser(UserDto userDto, String userId) {
//        webClient.put()
//                .uri("/v1/user?userid=" + userId)
//                .body(Mono.just(userDto), UserDto.class)
//                .retrieve()
//                .onStatus(httpStatus -> httpStatus == HttpStatus.NOT_ACCEPTABLE,
//                        response -> Mono.error(new CompanyManagerException(ErrorType.PHONE_NUMBER_ALREADY_EXISTS)))
//                .onStatus(HttpStatus::is4xxClientError,
//                        response->Mono.error(new CompanyManagerException(ErrorType.EMAIL_ALREADY_EXISTS)))
//                .onStatus(HttpStatus::is4xxClientError,
//                        clientResponse -> Mono.error(new CompanyManagerException(ErrorType.USER_SERVICE_BAD_REQUEST)))
//                .onStatus(HttpStatus::is5xxServerError,
//                        clientResponse -> Mono.error(new CompanyManagerException(ErrorType.USER_SERVICE_POST_INTERNAL_ERROR)))
//                .bodyToMono(String.class)
//                .doOnError(error -> log.error(error.toString()))
//                .block(Duration.ofSeconds(20));
//    }
}
