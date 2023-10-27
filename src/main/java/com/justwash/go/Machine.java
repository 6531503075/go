package com.justwash.go;

import java.time.LocalDateTime;

public class Machine {

    //add attributes
    private int id;
    private String status;
    private int queue;
    private LocalDateTime time;
    
    public Machine() {
    }
    public Machine(int id, String status, int queue, LocalDateTime time) {
        //set attributes
        this.id = id;
        this.status = status;
        this.queue = queue;
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public void setId(int nextId) {
        this.id = nextId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getQueue() {
        return queue;
    }
    public void setQueue(int queue) {
        this.queue = queue;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    
}
