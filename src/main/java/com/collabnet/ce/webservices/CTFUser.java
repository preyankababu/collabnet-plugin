package com.collabnet.ce.webservices;

import com.collabnet.ce.soap50.webservices.cemain.ProjectMemberSoapRow;

/**
 * @author Kohsuke Kawaguchi
 */
public class CTFUser {
    private java.lang.String userName;
    private java.lang.String fullName;
    private java.lang.String email;

    CTFUser(ProjectMemberSoapRow data) {
        this.userName = data.getUserName();
        this.fullName = data.getFullName();
        this.email = data.getEmail();
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}