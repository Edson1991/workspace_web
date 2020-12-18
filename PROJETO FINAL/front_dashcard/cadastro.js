function cadastrar(){

    var txtNome  = document.getElementById("txtNome").value; // recupera os dados digitados e armazena na varialve txtNome
    var txtEmail = document.getElementById("txtEmail").value; // recupera os dados digitados e armazena na varialve txtEmail
    var txtRacf  = document.getElementById("txtRacf").value; // recupera os dados digitados e armazena na varialve txtRacf
    var txtSenha = document.getElementById("txtSenha").value; // recupera os dados digitados e armazena na varialve txtSenha
    var txtFoto  = document.getElementById("txtFoto").value; // recupera os dados digitados e armazena na varialve txtFoto


    console.log("Valores digitados = " + txtNome + "/" + txtEmail + "/" + txtRacf + "/" + txtSenha + "/" + txtFoto); 

     //preciso agora montar essa mensagem para enviar ao BackEnd atraves do metodo POST e
    // depois tratar o resultado
    //passo 1 - montar o corpo da mensagem
    //passo 2 - montar o cabeçalho como se fosse o POSTMAN
    //passo 3 - enviar a URL com a mensagem para o BackEnd
    //passo 4 - tratar

   // Passo 1 - corpo da mensagem em JSON
    var msgBody = {
        nome : txtNome,
        email : txtEmail,
        racf  : txtRacf,
        senha : txtSenha,
        linkFoto : txtFoto
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
    fetch("http://localhost:8080/novouser", cabecalho)
    .then(res => tratastatus(res));

    // Passo 4 - Tratar o status para mostrar paro usuario
    function tratastatus(res){
        if(res.status == 201){ // Resultado OK 
            res.json().then(user => registrarUser(user)); // extraindo o conteúdo do corpo da mensagem em JSON
        }
        else if (res.status != 201){
            document.getElementById("msgErro").innerHTML = "Erro de cadastro"      
        }
    }

    function registrarUser(user){
        localStorage.setItem("dashcardUser",JSON.stringify(user)); // deixa o user em cache local em dashcardUser
        window.location = "agentes.html"; // chama a pagina agentes.html
    }

    

}

function retornar(){
    window.location = "index.html"; //se não, manda pra pagina de index.html
}