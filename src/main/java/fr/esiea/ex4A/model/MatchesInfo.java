package fr.esiea.ex4A.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class MatchesInfo {
    public final String name;
    public final String twitter;

    @JsonCreator
    public MatchesInfo( @JsonProperty(value = "userName", required = true) String name,
        @JsonProperty(value = "userTweeter", required = true) String twitter){
        this.name = name;
        this.twitter = twitter;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchesInfo userMatch = (MatchesInfo) o;
        return Objects.equals(name, userMatch.name) && Objects.equals(twitter, userMatch.twitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, twitter);
    }

    @Override
    public String toString() {
        return "UserMatch{" +
            "name='" + name + '\'' +
            ", twitter='" + twitter + '\'' +
            '}';
    }
}
