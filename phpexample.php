<?php 

# Login
if (trim($_POST['username']) and trim($_POST['password'])) { 
    $connection = mysql_connect("localhost", 'root', '1234');
    $db = 'typ';
    mysql_select_db($db, $connection) or die("No se pudo establecer la conexion con la base de datos");
    $username = $_POST['username'];
    $password = $_POST['password'];
    $query = "SELECT * FROM UsuariosWeb LEFT JOIN Propietarios ON propID=usrPropID WHERE usrEmail='{$username}' and AES_DECRYPT(usrPass,'typ2012')='{$password}'"; 
    $result = mysql_query($query, $connection) or die("No se pudo consultar la base de datos. Intente luego.");
    $usuario = mysql_fetch_array($result);
    if(! mysql_num_rows($result)){
        mostrar_form(true);
    }else{
        mostrar_bienvenido($usuario);
    }
}else{
    mostrar_form(true);
}

function mostrar_form($invalid=false){
?>
<html>
    <head>
        <title>30 y Playa :: Ingreso</title>
    </head>
    <body>
    <h2>Por favor, identifiquese</h2>
    <form action="<?php $PHP_SELF; ?>" method='POST'>
        Usuario:<input name='username' type='text'/><br/>
        Clave:  <input name='password' type='password'/><br/>
        <input value='Ingresar' type='submit'/>
<?php
        if ($invalid){
            $invalid = false;
?>
            <span color=red>Usuario invalido</span>
<?php
        
        }
?>
    </form>
    </body>
</html>
<?php
        $invalid = true;
}

function mostrar_bienvenido($usuario){
?>
<html>
<body>
       <h2>
<?php
    if(trim($usuario['propApellido']) and trim($usuario['propNombre'])){
        $title ="{$usuario['propApellido']}, {$usuario['propNombre']}";
    }else{
        $title = $usuario['usrEmail']; 
    }
    $title = "Bienvenido/a: {$title}";
    echo $title;
?>
       </h2>
</body>
</html>
<?php
}
?>
