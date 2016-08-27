package com.graywolf.cucumber.persistance;

import lombok.*;

/**
 * Created by aprey on 25.08.2016.
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String title;

    private String author;

    private int year;
}
