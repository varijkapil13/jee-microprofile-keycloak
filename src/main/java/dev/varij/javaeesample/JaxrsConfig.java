package dev.varij.javaeesample;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
public class JaxrsConfig extends Application {

}
