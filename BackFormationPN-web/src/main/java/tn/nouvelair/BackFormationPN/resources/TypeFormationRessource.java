package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.TypeFonction;
import tn.nouvelair.BackFormationPN.entities.TypeFormation;
import tn.nouvelair.BackFormationPN.services.TypeFonctionServiceRemote;
import tn.nouvelair.BackFormationPN.services.TypeFormationServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("typeFormation")
@RequestScoped
public class TypeFormationRessource {
    @EJB
    TypeFormationServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypeFormations(){

        return Response.ok(metier.GetTypeFormations()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteTypeFormation (@PathParam (value = "id") int id)
    {

        metier.deleteTypeFormation(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterTypeFormation(TypeFormation typeFormation) {
        metier.AjouterTypeFormation(typeFormation);

        return Response.status(Response.Status.CREATED).entity("success").build();

    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateTypeFormation(@PathParam (value = "id") int id,TypeFormation typeFormation) {
        metier.UpdateTypeFormation(typeFormation);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }

}
