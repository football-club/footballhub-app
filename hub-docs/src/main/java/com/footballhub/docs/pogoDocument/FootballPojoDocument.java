package com.footballhub.docs.pogoDocument;

import com.footballhub.docs.pogo.FootballPOJO;
import com.google.gson.Gson;

public class FootballPojoDocument {

    private FootballPOJO footballPOJO = new FootballPOJO();
    public FootballPojoDocument(){
        footballPOJO.setMatchNumber(0);
        footballPOJO.setRoundNumber(0);
        footballPOJO.setDateUtc("");
        footballPOJO.setLocation("");
        footballPOJO.setHomeTeam("");
        footballPOJO.setAwayTeam("");
        footballPOJO.setGroup(null);
        footballPOJO.setHomeTeamScore(null);
        footballPOJO.setAwayTeamScore(null);
    }
    public FootballPojoDocument(String request){
        Gson gson = new Gson();

    }

    public static void main(String[] args) {
        // Your input JSON string
        String inputJsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";


    }
}

