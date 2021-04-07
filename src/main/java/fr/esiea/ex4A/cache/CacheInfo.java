package fr.esiea.ex4A.cache;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CacheInfo {
    private final ArrayList<CacheCons> cache;

    {
        cache = new ArrayList<>();
    }

    public ArrayList<CacheCons> getCacheRepo(){
        return this.cache;
    }

    public boolean addUser(String name, String country, int age){
        return this.cache.add(new CacheCons(name, country, age));
    }

    public int getUserCachedAge(String name, String country){
        for(CacheCons c : this.cache){
            if(c.name.equals(name) && c.country.equals(country)){
                return c.age;
            }
        }
        return -1;
    }
}
