<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<%--! ArrayList<Usuario> todosUsuarios; --%>
<%-- todosUsuarios = ServicioUsuarios.getInstancia().obtenerTodos(); --%>

<html>
    <%= head() %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Todos los usuarios sql</h1>
        <div border="2">
        <sql:setDataSource var = "squery" driver = "com.mysql.jdbc.Driver"
                           url = "jdbc:derby://localhost:1527/UsuarioDB"
                           user = "user1"  password = "user1"/>

        <sql:query dataSource = "${squery}" var = "resultado">
            SELECT * FROM usuario
        </sql:query>
            <c:forEach var = "fila" items = "${resultado.rows}">
                <form action="usuarios.do" method="post" name="form_${fila.id}">                 
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="${fila.id}"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="${fila.nombre}"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="${fila.edad}"/>
                    <input id="email" name="email" type="email" required="true" value="${fila.email}"/>
                    <input id="password" name="password" type="password" required="true" value="${fila.password}"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>

                    <input type="submit" value="EDIT" 
                           onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM"                           
                           onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                </form>
            </c:forEach>
        </div>
    </body>
</html>