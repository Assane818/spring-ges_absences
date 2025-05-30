package com.ism.gestion_absences.mobile.dto.Response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class RestResponse {
    public static Map<String,Object> response(HttpStatus status, Object results, Object type) 
    {
        Map<String,Object> reponse =new  HashMap<>();
        reponse.put("status", status.value());
        reponse.put("results", results);
        reponse.put("type", type);
        return reponse;
    }

    public static Map<String,Object> responsePaginate(HttpStatus status, Object results, Object page, Object currentpage, Object totalPages, Object totalItems, Boolean first, Boolean last, Object type) 
    {
        Map<String,Object> reponse =new  HashMap<>();
        reponse.put("status", status.value());
        reponse.put("results", results);
        reponse.put("type", type);
        reponse.put("page", page);
        reponse.put("currentpage", currentpage);
        reponse.put("totalPages", totalPages);
        reponse.put("totalItems", totalItems);
        reponse.put("first", first);
        reponse.put("last", last);
        return reponse;
    }
}
