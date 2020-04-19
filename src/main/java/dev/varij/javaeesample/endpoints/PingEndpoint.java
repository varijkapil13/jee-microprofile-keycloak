package dev.varij.javaeesample.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingEndpoint {
  
  @GET
  @Path("/")
  @Produces(value = MediaType.APPLICATION_JSON)
  public Response getPing() {
    return Response.ok("The app is working").build();
  }
}
