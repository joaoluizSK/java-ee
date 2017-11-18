package net.unibave.ecommerce.cliente;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Stateless
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Path("clientes-old")
public class ClienteResourceOld {

    @PersistenceContext(unitName = "unibavePU")
    private EntityManager em;

    @Inject
    private ClienteService service;

    @GET
    public List<Cliente> findAll() {
        return em.createQuery("FROM Cliente a ORDER BY a.id", Cliente.class).getResultList();
    }

    @GET
    @Path(value = "{id}")
    public Cliente find(@PathParam(value = "id") Integer id) {
        return em.find(Cliente.class, id);
//        if (cliente == null) {
//            return Response.status(Response.Status.NOT_FOUND);
//        } else {
//            return Response.ok(cliente);
//        }
    }

    @POST
    public Response create(Cliente cliente) {
//        em.persist(cliente);
        Cliente cliente1 = service.save(cliente);
        return Response.ok(cliente1).build();
//        return cliente;
//        return Response.created(URI.create("/clientes/" + cliente.getId())).build();
    }

    @DELETE
    @Path(value = "{id}")
    public void delete(@PathParam(value = "id") Integer id) {
        Cliente cliente = em.getReference(Cliente.class, id);
        if (cliente != null) {
            em.remove(cliente);
//            return Response.noContent();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND);
        }
    }

    @PUT
    public Cliente update(Cliente cliente) {
        return em.merge(cliente);
//        if (cliente == null) {
//            return Response.status(Response.Status.NOT_FOUND);
//        } else {
//            return Response.ok(cliente);
//        }
    }

}
