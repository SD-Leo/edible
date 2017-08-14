/*
 * 2017-08-14
 */
package ru.edible.domain;

import lombok.Data;

/**
 * @author StarovoytovD
 */
@Data
public class Word {

    private String id;

    private String word;

    private Boolean edible;

    private String description;
}
