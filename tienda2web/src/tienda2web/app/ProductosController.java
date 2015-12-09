package tienda2web.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tienda2web.dominio.Categoria;
import tienda2web.dominio.Producto;

@Controller
public class ProductosController {

	/**
	 * Saves the static list of users in model and renders it via freemarker
	 * template.
	 * 
	 * @param model
	 * @return The index view (FTL)
	 */
	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("listaCategorias", CicloVidaAplicacion.listaCategorias);
		model.addAttribute("listaProductos", CicloVidaAplicacion.listaProductos);

		return "productos";
	}

	/**
	 * Add a new user into static user lists and display the same into FTL via
	 * redirect
	 * 
	 * @param user
	 * @return Redirect to /index page to display user list
	 */
	@RequestMapping(value = "/crear", params = { "codigo", "nombre", "categoriaOid" }, method = RequestMethod.POST)
	public String add(@RequestParam(value = "codigo") String codigo, @RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "categoriaOid") String categoriaOid) {

		if (codigo != null && !codigo.isEmpty() && nombre != null && !nombre.isEmpty() && categoriaOid != null
				&& !categoriaOid.isEmpty()) {

			CicloVidaAplicacion.OID_GENERATOR++;
			long newOid = CicloVidaAplicacion.OID_GENERATOR;

			synchronized (CicloVidaAplicacion.listaProductos) {
				
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tienda2web_pu");
				EntityManager entitymanager = emfactory.createEntityManager();
				
				entitymanager.getTransaction().begin();
				
				Producto productoNuevo = new Producto();
				productoNuevo.setOid(String.valueOf(newOid));
				productoNuevo.setCodigo(codigo);
				productoNuevo.setNombre(nombre);
				productoNuevo.setCategoria(findCategoria(categoriaOid));
				
				entitymanager.persist(productoNuevo);
				entitymanager.getTransaction().commit();

				CicloVidaAplicacion.listaProductos.add(productoNuevo);
				
				entitymanager.close();
				emfactory.close();
			}

		}

		return "redirect:productos.html";
	}

	private Categoria findCategoria(String oid) {
		List<Categoria> categorias = CicloVidaAplicacion.listaCategorias;
		Categoria categoriaEncontrada = null;
		for (Categoria categoria : categorias) {
			if (categoria.getOid().compareTo(oid) == 0) {
				categoriaEncontrada = categoria;
				break;
			}
		}
		return categoriaEncontrada;
	}
}
