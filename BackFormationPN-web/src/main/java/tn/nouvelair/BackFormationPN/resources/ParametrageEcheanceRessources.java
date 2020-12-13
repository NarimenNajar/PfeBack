package tn.nouvelair.BackFormationPN.resources;

import tn.nouvelair.BackFormationPN.Interfaces.ParametrageEcheanceServiceRemote;
import tn.nouvelair.BackFormationPN.entities.ParametrageEcheance;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("parametrageEcheance")
@RequestScoped
public class ParametrageEcheanceRessources {

    @EJB
    ParametrageEcheanceServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParametrageEcheances(){

        return Response.ok(metier.GetParametrageEcheances()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteParametrageEcheance (@PathParam (value = "id") int id)
    {

        metier.deleteParametrageEcheance(id);
        return Response.status(Status.OK).build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterParametrageEcheance(ParametrageEcheance parametrageEcheance) {
        metier.AjouterParametrageEcheance(parametrageEcheance);

        return Response.status(Response.Status.CREATED).entity(parametrageEcheance).build();

    }


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateParametrageEcheance(@PathParam (value = "id") int id,ParametrageEcheance parametrageEcheance) {
        metier.UpdateParametrageEcheance(parametrageEcheance);
        Response.status(Status.CREATED).entity(parametrageEcheance).build();
        return Response.ok(parametrageEcheance).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/detail/{id}")
    public Response getParametrageEcheanceById (@PathParam (value = "id") int id)
    {

        return Response.ok(metier.getParametrageEcheanceById(id)).build() ;
    }
}
