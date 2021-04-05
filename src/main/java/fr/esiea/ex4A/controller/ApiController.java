package fr.esiea.ex4A.controller;

import fr.esiea.ex4A.model.MatchesInfo;
import fr.esiea.ex4A.model.UserInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @PostMapping(path ="/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    void inscription(@RequestBody UserInfo userInfo ) throws InterruptedException{
        System.out.println(userInfo);
    }
    @PostMapping(path= "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    void matches(@RequestBody MatchesInfo matchesInfo ) throws InterruptedException{
        System.out.println(matchesInfo);
    }
}
