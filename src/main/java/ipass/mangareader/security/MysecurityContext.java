package ipass.mangareader.security;

import ipass.mangareader.domeinlaag.Admin;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MysecurityContext implements SecurityContext {
    private Admin user;
    private String scheme;

    public MysecurityContext (Admin user, String scheme){
        this.user = user;
        this.scheme = scheme;
    }

//    @Override
//    public boolean isUserInRole(Admin admin){
//        if (admin instanceof Admin){
//            return true;
//        }
//        return false;
//    }

    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (user.getRole()!=null){
            return role.equals(user.getRole());
        }
        return false;
    }

    @Override
    public  boolean isSecure(){
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme(){
        return SecurityContext.BASIC_AUTH;
    }
}
