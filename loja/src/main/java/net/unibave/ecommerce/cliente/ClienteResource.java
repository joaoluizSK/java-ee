package net.unibave.ecommerce.cliente;

import net.unibave.ecommerce.base.jaxrs.CrudResource;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("clientes")
public class ClienteResource extends CrudResource<Cliente, Long> {

}
