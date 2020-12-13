package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Role;
import tn.nouvelair.BackFormationPN.Interfaces.RoleServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("role")
@RequestScoped
public class RoleRessource {
    @EJB
    RoleServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoles(){

        return Response.ok(metier.GetRoles()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteRole (@PathParam (value = "id") int id)
    {

        metier.deleteRole(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterRole(Role role) {
        metier.AjouterRole(role);

        return Response.status(Response.Status.CREATED).entity(role).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateRole(@PathParam (value = "id") int id,Role role) {
        metier.UpdateRole(role);
        Response.status(Status.CREATED).entity(role).build();
        return Response.ok(role).build();
    }

    @GET
    @Path("/fcts/{idRole}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFonctionnalites(@PathParam (value = "idRole") int idRole){

        return Response.ok(metier.GetFonctionnalites(idRole)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/detail/{id}")
    public Response getRoleById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getRoleById(id)).build() ;
    }

}
