package com.footballhub.docs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.footballhub.docs.pogo.FootballPOJO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JDocument {

    private ObjectMapper objectMapper = new ObjectMapper();
    private JsonNode jsonNode;
    private JsonNode updatePathNode;
    private String path = System.getProperty("user.dir") + File.separator + "hub-docs" + File.separator + "src"+ File.separator +"main"+ File.separator +"java" + File.separator +"com" + File.separator +"footballhub" + File.separator +"docs";
    private  String inputJsonString;
    private String rootPath;

    /**
     *
     */
    public JDocument() {
        inputJsonString = "{}";
        init();
    }

    /**
     *
     * @param JSON
     */
    public JDocument(String JSON) {
        inputJsonString = JSON;
        init();
    }

    private void init() {
        try{
            jsonNode = objectMapper.readTree(inputJsonString);
        } catch (final Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param path: String
     * @return: true -> if the full path exist
     */
    public boolean pathExist(String path){
        rootPath = path.substring(2).replace('.','/');
        if(jsonNode.at(rootPath).toString() == null){
            return false;
        }
        return true;
    }
    /**
     *
     * @param path: String
     * @return: returns the value of the key if the path exist
     */
    public String getString(String path){
        rootPath = path.substring(2).replace('.','/');
        return jsonNode.at(rootPath).toString();
    }
    /**
     *
     * @param path:
     * @return
     */
    public boolean getBoolean(String path){
        rootPath = path.substring(2).replace('.','/');
        return jsonNode.at(rootPath).asBoolean();
    }

    /**
     *
     * @param path
     * @return
     */
    public int getInt(String path){
        rootPath = path.substring(2).replace('.','/');
        return jsonNode.at(rootPath).asInt();
    }

    /**
     *
     * @param path
     * @param value
     */
    public void setString(String path, String value){
        setObject(path, value, "String");
    }

    /**
     *
     * @param path
     * @param value
     */
    public void setBoolean(String path, boolean value){
        setObject(path, value, "boolean");
    }

    /**
     *
     * @param path
     * @param value
     */
    public void setInt(String path, int value){
        setObject(path, value, "int");
    }
    private void setObject(String path, Object value, String datatype){
        String[] nodes = path.substring(2).split("\\.");
        updatePathNode = jsonNode.path(nodes[0]);
        for (int i = 1; i < nodes.length; i++){
            updatePathNode = updatePathNode.path(nodes[i]);
        }
        switch (datatype){
            case "String":
                ((ObjectNode) updatePathNode).put(updatePathNode.toString(), (String) value);
                break;
            case "int":
                ((ObjectNode) updatePathNode).put(updatePathNode.toString(), (int) value);
                break;
            default:
                ((ObjectNode) updatePathNode).put(updatePathNode.toString(), (boolean) value);
                break;
        }

    }

}