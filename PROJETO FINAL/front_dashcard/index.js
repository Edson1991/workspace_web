function logar(){
    var txtLogin = document.getElementById("txtLogin").value; // recupera os dados digitados e armazena na varialve txtLogin
    var txtSenha = document.getElementById("txtSenha").value; // recupera os dados digitados e armazena na varialve txtSenha

    console.log("Valores digitados = " + txtLogin + "/" + txtSenha); 

    //preciso agora montar essa mensagem para enviar ao BackEnd atraves do metodo POST e
    // depois tratar o resultado
    //passo 1 - montar o corpo da mensagem
    //passo 2 - montar o cabeçalho como se fosse o POSTMAN
    //passo 3 - enviar a URL com a mensagem para o BackEnd
    //passo 4 - tratar

   // Passo 1 - corpo da mensagem em JSON
    var msgBody = {
        email : txtLogin,
        racf  : txtLogin,
        senha : txtSenha
    };

    // Passo 2 - Cabeçalho
    var cabecalho = {
        method : "POST",
        body   : JSON.stringify(msgBody),
        headers: {
            "content-type": "application/json"
        }
    };

    // Passo 3 - Eviar a URL com a mensagem para o BackEnd
    fetch("http://localhost:8080/login", cabecalho).then(res => tratastatus(res));

    // Passo 4 - Tratar o status para mostrar paro usuario
    function tratastatus(res){
        if(res.status == 200){ // Resultado OK 
            res.json().then(user => registrarUser(user)); // extraindo o conteúdo do corpo da mensagem em JSON
        }
        else if (res.status == 401){
            document.getElementById("msgErro").innerHTML = "Senha Inválida"
        }
        else if (res.status == 404){
            document.getElementById("msgErro").innerHTML = "Usuário Não Encontrado"
        }
        else{
            document.getElementById("msgErro").innerHTML = "Erro Desconhecido"
        }
    }

    function registrarUser(user){
        localStorage.setItem("dashcardUser",JSON.stringify(user)); // deixa o user em cache local em dashcardUser
        window.location = "agentes.html"; // chama a pagina agentes.html
    }

}