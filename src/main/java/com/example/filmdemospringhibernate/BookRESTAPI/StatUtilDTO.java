package com.example.filmdemospringhibernate.BookRESTAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatUtilDTO {

    private String author;
    private Long nr;
}
