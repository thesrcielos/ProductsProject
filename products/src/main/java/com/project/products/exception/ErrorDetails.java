package com.project.products.exception;

import java.time.LocalDateTime;

public record ErrorDetails(String message, int code, LocalDateTime date) {
}
