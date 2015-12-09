package tienda2web.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String oid;
	private String codigo;
	private String nombre;
	private Categoria categoria;

	public Producto() {
		super();
	}

	public Producto(String oid, String codigo, String nombre, Categoria categoria) {
		super();
		this.oid = oid;
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [oid=" + oid + ", codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + "]";
	}
}
