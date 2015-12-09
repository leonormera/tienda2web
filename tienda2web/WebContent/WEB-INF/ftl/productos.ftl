<html>
<head><title>Tienda Web</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.10/js/dataTables.jqueryui.min.js"></script>

<script>
$(document).ready(function() {
    $('#tablaProductos').DataTable();
} );
</script>

<link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.10/css/dataTables.jqueryui.min.css">

</head>
<body>

<div id="content">
     
  <fieldset>
    <legend>Agregar producto</legend>
  <form name="productoNuevo" action="crear.html" method="post">
    Código: <input type="text" name="codigo" /> <br/>
    Nombre: <input type="text" name="nombre" /> <br/>
    Categoría: 
    <select name="categoriaOid">
	    <#list model["listaCategorias"] as categoria>
    		<option value="${categoria.oid}">${categoria.nombre}</option>
   		</#list>
    </select>
    <br/>
    
    <input type="submit" value="Crear" />
  </form>
  </fieldset>
  
  <br/>
  
  <table id="tablaProductos" class="display" cellspacing="0" width="100%">
  <thead>
            <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Categoría</th>
    </tr>
        </thead>
        <tfoot>
           <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Categoría</th>
    </tr>
        </tfoot>
    <tbody>
    <#list model["listaProductos"] as producto>
    <tr>
        <td>${producto.codigo}</td>
        <td>${producto.nombre}</td>
        <td>${producto.categoria.nombre}</td>
    </tr>
    </#list>
</tbody>
  </table>
 
</div>  
</body>
</html> 
