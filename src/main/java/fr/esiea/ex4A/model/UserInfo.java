package fr.esiea.ex4A.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    public final String userCountry;
    public final String userName;
    public final String userEmail;
    public final String userTweeter;
    public final String userSex;
    public final String userSexPref;
    public final int age;

    public UserInfo(@JsonProperty("userCountry") String userCountry,
                    @JsonProperty("userName") String userName,
                    @JsonProperty("userEmail") String userEmail,
                    @JsonProperty("userTweeter") String userTweeter,
                    @JsonProperty("userSex") String userSex,
                    @JsonProperty("userSexPref")String userSexPref,
                    @JsonProperty("age") int age) {
        this.userCountry = userCountry;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userTweeter = userTweeter;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
        this.age = age;
    }
    @Override
    public String toString() {
        return userName + "(" + age + ", " + userSex + "->" + userSexPref + ", " + userCountry + ")";
    }

    MatchesInfo asMatch() {
        return new MatchesInfo(userName, userTweeter);
    }
}
