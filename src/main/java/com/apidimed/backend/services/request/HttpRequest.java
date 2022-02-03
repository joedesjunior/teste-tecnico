package com.apidimed.backend.services.request;

import com.apidimed.backend.dtos.BusDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    private final Client client;
    private static final String URL_BUS = "http://www.poatransporte.com.br";

    public HttpRequest() {
        this.client = ClientBuilder.newClient();
    }

    public void close() {
        this.client.close();
    }


    // Classe Responsável por fazer a request GET no site e trazer os onibus
    public List<BusDTO> buscaLinhasTransporte() throws Exception {
        WebTarget resource = this.client.target(URL_BUS).path("php/facades/process.php");
        Map<String, Object> templateValues = new HashMap<>();
        templateValues.put("a", "nc");
        templateValues.put("p", "%");
        templateValues.put("t", "o");
        //Por algum motivo o resolveTemplates não adiciona os params
        for (Map.Entry<String, Object> query : templateValues.entrySet()) {
            resource = resource.queryParam(query.getKey(), query.getValue());
        }
        Response response = resource.request("application/json;charset=UTF-8").get(Response.class);
        String respString = response.readEntity(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(respString, BusDTO[].class));
    }

}
