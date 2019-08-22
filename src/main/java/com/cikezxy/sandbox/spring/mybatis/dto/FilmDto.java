package com.cikezxy.sandbox.spring.mybatis.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class FilmDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Short id;
    private String title;
    private List<ActorDto> actors;

    private LanguageDto language;
    private LanguageDto originalLanguage;
}
