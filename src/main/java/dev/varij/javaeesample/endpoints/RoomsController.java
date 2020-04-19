package dev.varij.javaeesample.endpoints;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;

@Path("/api/rooms")
@Counted
@RequestScoped
public class RoomsController {
  
  @Inject
  @ConfigProperty(name = "max.rooms.in.db", defaultValue = "20")
  private int maxRooms;
  
  @GET
  @Path("/user")
  @RolesAllowed({"USER"})
  public Response getSomeRooms() {
    List<String> rooms = new ArrayList<>();
    for (int i = 0; i < maxRooms / 2; i++) {
      rooms.add("Room No. " + i);
    }
    return Response.ok(rooms).build();
  }
  
  @GET
  @Path("/admin")
  @RolesAllowed({"ADMIN"})
  public Response getAllRooms(@Context SecurityContext context) {
    
    List<String> rooms = new ArrayList<>();
    for (int i = 0; i < maxRooms; i++) {
      rooms.add("Room No. " + i);
    }
    return Response.ok(rooms).build();
  }
  
}
