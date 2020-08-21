package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.Role;
import tn.nouvelair.BackFormationPN.services.CategorieServiceRemote;
import tn.nouvelair.BackFormationPN.services.RoleServiceRemote;

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
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterRole(Role role) {
        metier.AjouterRole(role);

        return Response.status(Response.Status.CREATED).entity("success").build();

    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateRole(@PathParam (value = "id") int id,Role role) {
        metier.UpdateRole(role);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }
}
