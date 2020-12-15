package com.sampleproject.sampleproject.exception;

import com.google.gson.JsonObject;

public class ErrorResponse {
    public static String jsonErrorResponse(int errorCode, String errorMessage) {
        JsonObject jobj = new JsonObject();

        jobj.addProperty("errorCode", errorCode);
        jobj.addProperty("errorMessage", errorMessage);

        return jobj.toString();
    }
}
