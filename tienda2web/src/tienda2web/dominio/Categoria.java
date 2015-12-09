package tienda2web.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String oid;
	private String codigo;
	private String nombre;

	public Categoria() {
		super();
	}

	public Categoria(String oid, String codigo, String nombre) {
		super();
		this.oid = oid;
		this.codigo = codigo;
		this.nombre = nombre;
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

}
