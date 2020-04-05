package org.example.rest;

import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.annotation.Body;
import ru.sbtqa.tag.api.annotation.Header;
import ru.sbtqa.tag.api.annotation.Validation;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@Endpoint(method = Rest.POST, path = "/api/auth/login", title = "login", template = "apitemplates/user.json")
public class LoginEntry extends EndpointEntry {

    @Body(name = "login")
    private String login;

    @Body(name = "password")
    private String password;

    @Header(name = "Content-Type")
    private String contentType;

    @Validation(title = "incorrectContentType")
    public void incorrectContentType() {
        getResponse()
                .statusCode(415)
                .body("message", containsString("not supported"));
    }

    @Validation(title = "incorrectLoginOrPassword")
    public void incorrectLoginOrPassword() {
        getResponse()
                .statusCode(401)
                .body("message", equalTo("incorrect login or password"));
    }
}