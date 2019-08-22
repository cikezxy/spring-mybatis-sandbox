package com.cikezxy.sandbox.spring.mybatis;

import java.util.Arrays;
import java.util.List;

import com.cikezxy.sandbox.spring.mybatis.dao.FilmDao;
import com.cikezxy.sandbox.spring.mybatis.dto.FilmDto;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@MapperScan("com.cikezxy.sandbox.spring.mybatis.dao")
public class MybatisSandboxApplication implements ApplicationRunner {

    @Autowired
    private FilmDao filmDao;

    public static void main(String[] args) {
        SpringApplication.run(MybatisSandboxApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动...");
        FilmDto film = filmDao.selectFilmDtoByTitle("ACADEMY DINOSAUR");
        log.info("ACADEMY DINOSAUR:{}", film);

        List<FilmDto> films = filmDao.selectFilmDtoByTitleIn(Arrays.asList("ACADEMY DINOSAUR", "ACE GOLDFINGER"));
        log.info("ACADEMY DINOSAUR/ACE GOLDFINGER:{}", films);

        List<String> titles = filmDao.selectFilmTitleStartsWith("A",1,10);
        log.info("Films starts with A:{}", titles);

        List<String> ratingTitles = filmDao.selectFilmTitleByRating("PG-13", new RowBounds(2, 10));
        log.info("Films rating PG-13: {}", ratingTitles);

        log.info("结束...");
    }
}
