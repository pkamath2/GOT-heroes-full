package org.wwcode.springboot.GOTheroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.wwcode.springboot.GOTheroes.bo.GOTHero;
import org.wwcode.springboot.GOTheroes.properties.GOTProperties;
import org.wwcode.springboot.GOTheroes.service.GOTService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/GOT")
public class GOTHeroesController {

    @Value("${got.some-prop}")
    private String someProp;

    @Autowired
    private GOTProperties props;

    @Autowired
    private GOTService gotService;


    @RequestMapping(path="/heroes", method = RequestMethod.GET)
    public @ResponseBody List<GOTHero> heroes(@AuthenticationPrincipal UserDetails user){

        List<GOTHero> heroes;

        System.out.println("Some Prop ->"+this.someProp);
        System.out.println("Some other props from file -> "+this.props.getProperty("got.some-other-prop"));
        System.out.println("Logged in User -> " + user.getUsername());
        //heroes = gotService.getAllHeros();-- Using JDBC Template
        heroes = gotService.getAllherosJPA();

        return heroes;
    }

    @RequestMapping(path="/hero/{id}", method=RequestMethod.GET)
    public String getHero(@PathVariable String id){

        System.out.println("id = [" + id + "]");
        return "success";
    }

    @RequestMapping(path="/hero", method=RequestMethod.POST)
    public String saveHero(@RequestBody String requestDetails){
        System.out.println("requestDetails = [" + requestDetails + "]");
        //Do some saving.
        return "success";
    }


    @RequestMapping(path="/search/{searchable}")
    public @ResponseBody List<String> search(@PathVariable String searchable,
                                             @RequestParam(name="start") int start,
                                             @RequestParam(name="end") int end){

        System.out.println("searchable = [" + searchable + "], start = [" + start + "], end = [" + end + "]");

        List<String> heroes = Arrays.asList("Heros1");
        return heroes;
    }


    @RequestMapping(path="/heroesXml/{id}", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody List<String> heroesXml(@PathVariable String id){

        List<String> heroes;
        System.out.println("XML - id = [" + id + "]");

        if(id.equals("all")){
            heroes = Arrays.asList("Hero1", "Hero2");
        }else{
            heroes = Arrays.asList("Hero1");
        }

        return heroes;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(path="/add", method={RequestMethod.GET,RequestMethod.POST})
    public void addHero(){
        System.out.println("You can access this method since you have the ADMIN role.");
    }

}
