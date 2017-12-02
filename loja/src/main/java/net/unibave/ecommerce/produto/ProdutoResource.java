package net.unibave.ecommerce.produto;

import net.unibave.ecommerce.base.jaxrs.CrudResource;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("produtos")
public class ProdutoResource extends CrudResource<Produto, Long> {

}
