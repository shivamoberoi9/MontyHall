package com.assignment.game.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoundDetail {

    private Result result;

    private boolean hasSwitchedBox;

}
