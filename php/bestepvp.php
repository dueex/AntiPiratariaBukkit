<?php 
	include "conexao.php";

	$dono2=$_REQUEST['dono'];

	$sql = mysql_query("SELECT * FROM dados WHERE dono LIKE '".$dono2."'");
	$row = mysql_num_rows($sql);

	if($row > 0) {
		while($linha = mysql_fetch_array($sql)) {
			$dono = $linha['dono'];
			$key = $linha['chave'];
			$ip = $linha['ip'];

			if($_REQUEST['ip'] == $ip & $_REQUEST['key'] == $key & $_REQUEST['dono'] == $dono) {
				echo "true";
			}
			else {
				echo "false";
			}

		}
	}
	else {
		echo "false";
	}

?>