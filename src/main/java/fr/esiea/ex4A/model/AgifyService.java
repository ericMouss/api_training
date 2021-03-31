package fr.esiea.ex4A.model;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final HashMap<String, UserInfo> ListeInscrit;

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
        this.ListeInscrit = new HashMap<String, UserInfo>();
    }
}
