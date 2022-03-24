package com.elad.CouponSystemV3Spring.exeptions;

public enum ErrMsg {
    ID_ALREADY_EXIST("Id already exist"),
    ID_NOT_EXIST("Id not found"),
    IMAGE_ID_NOT_FOUND("Image id not found"),
    IMAGE_UPLOAD_FAILED("Image upload failed"),
    UNAUTHORIZED("email or password are wrong..."),
    INVALID_TOKEN("Something went wrong with you token..."),
    EMAIL_ALREADY_EXIST("email already exist"),
    UNABLE_LOCATE_API_NAME("unable to locate api name"),
    CONTROLLER_NOT_ALLOWED("you have not permission to play here"),
    INVALID_EMAIL_OR_PASS("Invalid email or password");

    private String description;

    ErrMsg(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}