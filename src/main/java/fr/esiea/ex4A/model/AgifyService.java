package fr.esiea.ex4A.model;

import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final HashMap<String, UserInfo> ListeInscrit;

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
        this.ListeInscrit = new HashMap<String, UserInfo>();
    }
    public void nouveauInscrit(UserInfo userInfo){
        final String key = userInfo.userName + ";"+ userInfo.userCountry;
        if(ListeInscrit.containsKey(key)){
            return;
        }
        Call<ResponseBody> call = agifyClient.submitInscription(userInfo);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    ResponseBody agifyResponse = response.body();
                    //ListeInscrit.put(userInfo.userName + ";"+ userInfo.userCountry, new UserInfo(UserInfo.userName, UserInfo.userName, UserInfo.userTweeter, UserInfo.userCountry, UserInfo.userSex, UserInfo.userSexPref));
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public List<MatchesInfo> getMatches(String userName, String userCountry){
        final String key = userName + ";" + userCountry;
        final UserInfo data = this.ListeInscrit.get(key);
        if(data == null){
            return null;
        }
        final List<MatchesInfo> matchesDatas = new ArrayList<MatchesInfo>();
        ListeInscrit.forEach((k, v) -> {
            if(data.userSex.equals(v.userSexPref) && data.userSexPref.equals(v.userSex))
            {
                matchesDatas.add(new MatchesInfo(v.userName,v.userTweeter));
            }
        });
        return matchesDatas;
    }
}
