package com.assignment.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box {
    private boolean hasPrize;
    private boolean userSelected;
    private boolean opened;
    public Box() {
        this.hasPrize = false;
        this.userSelected = false;
        this.opened = false;
    }

}
