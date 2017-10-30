package com.example.demo.Message;

public class Response {
    private String status;
    private String usedText;

    public Response(){

    }

    public Response(String status, String usedText){
        this.status = status;
        this.usedText = usedText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getUsedText() {
        return usedText;
    }

    public void setUsedText(String usedText) {
        this.usedText = usedText;
    }
}