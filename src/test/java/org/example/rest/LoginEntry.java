package org.example.rest;

import cucumber.api.DataTable;
import ru.sbtqa.tag.api.EndpointEntry;
import ru.sbtqa.tag.api.annotation.Body;
import ru.sbtqa.tag.api.annotation.Header;
import ru.sbtqa.tag.api.junit.ApiSteps;
import ru.sbtqa.tag.pagefactory.Rest;
import ru.sbtqa.tag.pagefactory.actions.PageActions;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.rest.Endpoint;
import ru.sbtqa.tag.api.annotation.Validation;

import javax.xml.ws.Action;

import static org.hamcrest.Matchers.*;
import static ru.sbtqa.tag.api.utils.CastUtils.toMap;

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