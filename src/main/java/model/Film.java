package model;

import lombok.Data;

/**
 * Created by Alexandr on 05.12.2016.
 */
@Data
public class Film extends Entity<Integer> {

    private String name;
    private Description description;

    public Film( String name) {

        this.name = name;

    }

    public Film() {
    }
}
