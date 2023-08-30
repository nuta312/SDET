package com.digitalnomads.api.entities;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;

@Slf4j
public abstract class BaseEntity {

    public void isEquals(BaseEntity expectedEntity) {
        Assertions.assertThat(this)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .withFailMessage("Objects not match")
                .isEqualTo(expectedEntity);
        log.info("Objects is match, Actual {}, Expected {}", this, expectedEntity);
    }
}
