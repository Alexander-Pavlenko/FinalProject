package model;

import lombok.Data;

/**
 * Created by Alexandr on 16.12.2016.
 */
@Data
public class Entity<T> {
    private T id;
}
