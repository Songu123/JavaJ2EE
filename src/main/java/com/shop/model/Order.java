package com.shop.model;

public class Order {
    private int id;
    private String code;
    private String status;
    private int userId;

    public Order() {}

    public Order(int id, String code, String status, int userId) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.userId = userId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}
