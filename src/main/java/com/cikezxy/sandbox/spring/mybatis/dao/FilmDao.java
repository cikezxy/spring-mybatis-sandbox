package com.cikezxy.sandbox.spring.mybatis.dao;


import java.util.Date;
import java.util.List;

import com.cikezxy.sandbox.spring.mybatis.dto.FilmDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * FilmDao继承基类
 */
public interface FilmDao {

    FilmDto selectFilmDtoByTitle(@Param("title") String title);

    List<FilmDto> selectFilmDtoByTitleIn(@Param("list") List<String> list);

    List<String> selectFilmTitleStartsWith(@Param("prefix") String prefix,
                                           @Param("pageNum") int pageNum,
                                           @Param("pageSize") int pageSize);

    List<String> selectFilmTitleByRating(@Param("rating") String rating, RowBounds rowBounds);
}