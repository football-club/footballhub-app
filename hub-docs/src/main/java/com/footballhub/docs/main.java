package com.footballhub.docs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class main {
    private static String path = System.getProperty("user.dir") + File.separator + "hub-docs" + File.separator + "src"+ File.separator +"main"+ File.separator +"java" + File.separator +"com" + File.separator +"footballhub" + File.separator +"docs";

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String inputJsonString = "{\n" +
                    "    \"MatchNumber\": 1,\n" +
                    "    \"RoundNumber\": 1,\n" +
                    "    \"DateUtc\": \"2022-08-05 19:00:00Z\",\n" +
                    "    \"Location\": \"Selhurst Park\",\n" +
                    "    \"HomeTeam\": \"Crystal Palace\",\n" +
                    "    \"AwayTeam\": \"Arsenal\",\n" +
                    "    \"Group\": null,\n" +
                    "    \"HomeTeamScore\": 0,\n" +
                    "    \"AwayTeamScore\": 2\n" +
                    "  }";

            JsonNode jsonNode = objectMapper.readTree(inputJsonString);

            int MatchNumber = jsonNode.get("MatchNumber").asInt();

            String Group = jsonNode.get("Group").asText();

            String DateUtc = jsonNode.get("DateUtc").toString();

            String asb = jsonNode.get("12").toString();


            System.out.println(path);
            objectMapper.writeValue(new File(path + File.separator + "test.json"), MatchNumber +"<"+Group+"<"+DateUtc);


        }catch (final Exception e){
            e.printStackTrace();
        }
    }
}
