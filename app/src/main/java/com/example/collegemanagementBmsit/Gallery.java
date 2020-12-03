package com.example.collegemanagementBmsit;


public class Gallery {
    private String ImageName;
    private String ImageUrl;

    public Gallery(String Imagename, String imageUrl) {
        ImageName = Imagename;
        ImageUrl = imageUrl;
    }

    public Gallery() {
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String ImageName) {
        ImageName = ImageName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
