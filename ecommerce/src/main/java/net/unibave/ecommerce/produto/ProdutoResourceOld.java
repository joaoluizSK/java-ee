package net.unibave.ecommerce.produto;

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
@Path("produtos-old")
public class ProdutoResourceOld {

    @PersistenceContext(unitName = "unibavePU")
    private EntityManager em;

    @Inject
    private ProdutoService service;

    @GET
    public List<Produto> findAll() {
        return em.createQuery("SELECT a FROM Produto a ORDER BY a.id", Produto.class).getResultList();
    }

    @GET
    @Path(value = "{id}")
    public Produto find(@PathParam(value = "id") Integer id) {
        return em.find(Produto.class, id);
//        if (produto == null) {
//            return Response.status(Response.Status.NOT_FOUND);
//        } else {
//            return Response.ok(produto);
//        }
    }

    @POST
    public Response create(Produto produto) {
//        em.persist(produto);
        Produto produto1 = service.save(produto);
        return Response.ok(produto1).build();
//        return produto;
//        return Response.created(URI.create("/produtos/" + produto.getId())).build();
    }

    @DELETE
    @Path(value = "{id}")
    public void delete(@PathParam(value = "id") Integer id) {
        Produto produto = em.getReference(Produto.class, id);
        if (produto != null) {
            em.remove(produto);
//            return Response.noContent();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND);
        }
    }

    @PUT
    public Produto update(Produto produto) {
        return em.merge(produto);
//        if (produto == null) {
//            return Response.status(Response.Status.NOT_FOUND);
//        } else {
//            return Response.ok(produto);
//        }
    }

}
