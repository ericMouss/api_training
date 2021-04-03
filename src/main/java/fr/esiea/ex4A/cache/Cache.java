package fr.esiea.ex4A.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Cache {
    private final List<Cachedata> cache = new ArrayList<Cachedata>();

    public List<Cachedata> getCachedRepo(){
        return this.cache;
    }

    public boolean addUser(String name, String country, int age){
        return this.cache.add(new Cachedata(name, country, age));
    }

    public int getUserCachedAge(String name, String country){
        for(Cachedata c : this.cache){
            if(c.name.equals(name) && c.country.equals(country)){
                return c.age;
            }
        }
        return -1;
    }
}
