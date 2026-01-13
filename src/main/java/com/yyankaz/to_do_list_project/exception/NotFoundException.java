package com.yyankaz.to_do_list_project.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private String message;
}
