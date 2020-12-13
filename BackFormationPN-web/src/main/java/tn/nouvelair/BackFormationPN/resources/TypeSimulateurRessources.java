package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.Interfaces.TypeSimulateurServiceRemote;
import tn.nouvelair.BackFormationPN.entities.TypeSimulateur;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("typeSimulateur")
@RequestScoped
public class TypeSimulateurRessources {
    @EJB
    TypeSimulateurServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypeSimulateurs(){

        return Response.ok(metier.GetTypeSimulateurs()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteTypeSimulateur (@PathParam (value = "id") int id)
    {

        metier.deleteTypeSimulateur(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterTypeSimulateur(TypeSimulateur typeSimulateur) {
        metier.AjouterTypeSimulateur(typeSimulateur);

        return Response.status(Response.Status.CREATED).entity(typeSimulateur).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateTypeSimulateur(@PathParam (value = "id") int id,TypeSimulateur typeSimulateur) {
        metier.UpdateTypeSimulateur(typeSimulateur);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok(typeSimulateur).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/detail/{id}")
    public Response getTypeSimulateurById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getTypeSimulateurById(id)).build() ;
    }
}
