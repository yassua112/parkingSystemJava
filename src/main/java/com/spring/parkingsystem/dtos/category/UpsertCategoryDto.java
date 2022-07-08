package com.spring.parkingsystem.dtos.category;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class UpsertCategoryDto {
    @NotBlank(message="Category name is required")
    private String id;
    @NotNull(message="Category tarif is required")
    private Integer tarif;
    @NotNull(message="Category tariflanjut is required")
    private Integer tariflanjut;
}
