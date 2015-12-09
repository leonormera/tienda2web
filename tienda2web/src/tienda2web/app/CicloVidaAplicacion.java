package tienda2web.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tienda2web.dominio.Categoria;
import tienda2web.dominio.Producto;

@WebListener
public class CicloVidaAplicacion implements ServletContextListener {

	public static long OID_GENERATOR = 1;
	public static List<Categoria> listaCategorias = new ArrayList<Categoria>();
	public static List<Producto> listaProductos = new ArrayList<Producto>();

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tienda2web_pu");
			EntityManager entitymanager = emfactory.createEntityManager();

			// Scalar function
			TypedQuery<Categoria> query = entitymanager.createQuery("SELECT c FROM Categoria c", Categoria.class);
			List<Categoria> categorias = query.getResultList();

			for (Categoria categoria : categorias) {
				listaCategorias.add(categoria);
			}

			entitymanager.close();
			emfactory.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// do on application destroy
	}
}
