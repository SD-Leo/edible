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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Word word = (Word) o;

        return id != null ? id.equals(word.id) : word.id == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
