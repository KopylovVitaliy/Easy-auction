package ru.skypro.cweasyauction.pojo;

import lombok.Getter;

@Getter
public enum Status {
    STARTED("STARTED"),
    STOPPED("STOPPED"),
    CREATED("CREATED");

    private String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
