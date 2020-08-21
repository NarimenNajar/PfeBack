package tn.nouvelair.BackFormationPN.resources;
import tn.nouvelair.BackFormationPN.entities.Categorie;
import tn.nouvelair.BackFormationPN.entities.SystemeExterne;
import tn.nouvelair.BackFormationPN.services.CategorieServiceRemote;
import tn.nouvelair.BackFormationPN.services.SystemeExterneServiceRemote;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("systemeExterne")
@RequestScoped
public class SystemeExterneRessource {
    @EJB
    SystemeExterneServiceRemote metier;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSysExternes(){

        return Response.ok(metier.GetSystemesExternes()).build();
    }

    @POST
    @Path("/addSys")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AjouterSysExterne(SystemeExterne systemeExterne) {
        metier.AjouterSysExterne(systemeExterne);

        return Response.status(Response.Status.CREATED).entity("success").build();
        //return Response.ok(metier.AjouterCategorie(categorie)).build();

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response deleteSysExterne (@PathParam (value = "id") int id)
    {

        metier.deleteSysExterne(id);
        return Response.status(Status.OK).entity("suppression avec succées").build() ;
    }

}
