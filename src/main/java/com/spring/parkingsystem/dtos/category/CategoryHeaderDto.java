package com.spring.parkingsystem.dtos.category;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class CategoryHeaderDto {
    private String id;
    private Integer tarif;
    private Integer tariflanjut;
}
