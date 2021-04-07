package fr.esiea.ex4A.model;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AgifyService {
    public final AgifyClient agifyClient;
    public final HashMap<String, UserInfo> inscrits;

    public AgifyService(AgifyClient agifyClient){
        this.agifyClient = agifyClient;
        this.inscrits = new HashMap<String, UserInfo>();
    }

    public void nouveauInscrit(UserInfo inscriptionData){
        Call<ResponseBody> call = agifyClient.submitInscription(inscriptionData);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) { if(response.isSuccessful()){
                    ResponseBody agifyResponse = (ResponseBody) agifyClient.getMatches(inscriptionData.userCountry, inscriptionData.userName);
                    inscrits.put(inscriptionData.userName + ";"+ inscriptionData.userCountry, new UserInfo(inscriptionData.userEmail, inscriptionData.userName, inscriptionData.userTweeter, inscriptionData.userCountry, inscriptionData.userSex, inscriptionData.userSexPref, inscriptionData.age));
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) { call.cancel(); }
        });
    }

    public List<MatchesInfo> getMatches(String userName, String userCountry){
        final String key = userName + ";" + userCountry;
        final UserInfo data = this.inscrits.get(key);
        if(data == null){
            return null;
        }
        final List<MatchesInfo> matchesData = new ArrayList<>();
        inscrits.forEach((k, v) -> {
            if(data.userSex.equals(v.userSexPref) && data.userSexPref.equals(v.userSex) && (Math.abs(data.age - v.age)) < 5)
            {
                matchesData.add(new MatchesInfo(v.userName,v.userTweeter));
            }
        });
        return matchesData;
    }
}
