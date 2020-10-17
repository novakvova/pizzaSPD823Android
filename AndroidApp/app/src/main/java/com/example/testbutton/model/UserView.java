package com.example.testbutton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserView {
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("image")
    @Expose
    private String image;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
