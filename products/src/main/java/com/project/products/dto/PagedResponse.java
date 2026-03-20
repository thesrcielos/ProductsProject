package com.project.products.dto;

import java.util.List;

public record PagedResponse<T>(
        List<T> content,
        int currentPage,
        int totalPages,
        long totalItems
) {
}
