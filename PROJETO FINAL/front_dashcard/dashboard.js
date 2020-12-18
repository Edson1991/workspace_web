function carregaDash(){
    var strUser = localStorage.getItem("dashcardUser"); // verifica se o cara esta logado em cache
    if (!strUser){
        window.location = "index.html"; //se não, manda pra pagina de index.html
    }


    //usuario está conectado... preciso consultar o relatorio consolidado no backend


    var strId = window.location.search; // recupero a informação a apartir do ? pra frente no browser ?id=xpto 
    console.log(strId);

    var idAgente = strId.substr(4); // recupera a informação do ID agente removendo a ?id= 
    console.log("ID recuperado = "+ idAgente);

    fetch("http://localhost:8080/totaisconsolidados?id="+idAgente)
    .then(res => res.json())
    .then(lista => preencheDash(lista));

}

function preencheDash(lista){
    var nome;
    var volume;
    var sucessos;
    var falhas;
    var fraudes;    
   

    for (i=0; i<lista.length;i++){
        var ag = lista[i];
        nome = ag.nomeAgente;
        volume = ag.volume;
        
        if (ag.status == 0){
            sucessos = ag.numeroOp;
        }
        else if(ag.status == 1){
            falhas = ag.numeroOp;
        }
        else{
            fraudes = ag.numeroOp;
        }
        
    }

    document.getElementById("nomeAgenteVolumeAgente").innerHTML =   "<h4>"+nome+"<br>"+ "Volume: "+volume+"</h4>";
   // document.getElementById("sucessosAgente").innerHTML = "<h4>Sucesso: "+sucessos+"</h4>";
   // document.getElementById("falhasAgente").innerHTML = "<h4>Falhas: "+falhas+"</h4>";
   // document.getElementById("fraudesAgente").innerHTML = "<h4>Fraudes: "+fraudes+"</h4>";

   var ctx = document.getElementById('meuGrafico');
   var myChart = new Chart(ctx, {
       type: 'doughnut',
       data: {
           labels: ['Sucesso', 'Falha', 'Fraude'],
           datasets: [{
               label: '# de operacoes',
               data: [sucessos, falhas, fraudes],
               backgroundColor : [
                   'rgba(0, 255, 0, 0.5)',
                   'rgba(255, 255, 0, 0.5)',
                   'rgba(255, 0, 0, 0.5)'
               ]              
           }]
       },


       options : {
           scales: {
            xAxes: [{
                gridLines: {
                    color: 'rgba(0, 0, 0, 0)',
                }
             }],

               yAxes: [{
                   
                    ticks: {
                       beginAtZero: true
                   }
               }]
           }
       }
   });
}

function retornarAgentes(){
    window.location = "agentes.html"; //se não, manda pra pagina de index.html
}
