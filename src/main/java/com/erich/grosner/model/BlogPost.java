package com.erich.grosner.model;

import lombok.Data;

@Data
public class BlogPost {
    private String title;
    private String date;
    private String body;
    private String tags;
}
