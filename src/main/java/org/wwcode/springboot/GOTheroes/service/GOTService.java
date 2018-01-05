package org.wwcode.springboot.GOTheroes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.wwcode.springboot.GOTheroes.bo.GOTHero;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GOTService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GOTHeroesRepository gotHeroesRepository;

    public List<GOTHero> getAllHeros(){
        String sql = "Select * from GOT_HEROES";

        List<GOTHero> heroes = new ArrayList<>();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                GOTHero hero = new GOTHero();
                hero.setId(resultSet.getInt("HERO_ID"));
                hero.setTitle(resultSet.getString("HERO_TITLE"));
                hero.setName(resultSet.getString("HERO_NAME"));
                hero.setAllegiance(resultSet.getString("HERO_ALLEGIANCE"));
                hero.setImageUrl(resultSet.getString("HERO_IMAGE_URL"));
                heroes.add(hero);

            }
        });

        return heroes;
    }

    public List<GOTHero> getAllherosJPA(){

        List<GOTHero> heroes = new ArrayList<>();
        gotHeroesRepository.findAll().forEach(heroes::add);
        return heroes;
    }
}
