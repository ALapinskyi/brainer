package com.boss.brainer.domain.mongo;

import lombok.Data;

import java.util.List;

@Data
public class Round {

    private Integer id;
    private Integer roundNumber;
    private Category category;
    private List<GameQuestion> questions;
}
