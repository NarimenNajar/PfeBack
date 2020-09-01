package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Syllabus;
import tn.nouvelair.BackFormationPN.Interfaces.SyllabusServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("syllabus")
@RequestScoped
public class SyllabusRessource {
    @EJB
    SyllabusServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSyllabuss(){

        return Response.ok(metier.GetSyllabuss()).build();
    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteSyllabus (@PathParam (value = "id") int id)
    {

        metier.deleteSyllabus(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterSyllabus(Syllabus syllabus) {
        metier.AjouterSyllabus(syllabus);

        return Response.status(Response.Status.CREATED).entity("success").build();


    }


    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateSyllabus(@PathParam (value = "id") int id,Syllabus syllabus) {
        metier.UpdateSyllabus(syllabus);
        Response.status(Status.CREATED).entity(" Modified").build();
        return Response.ok("Modified!").build();
    }

}
