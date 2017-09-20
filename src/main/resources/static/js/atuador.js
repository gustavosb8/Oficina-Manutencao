function preecheTabela(lista, tbody) {
    var i = 0;
    
  //jacks.addClass('glyphicon glyphicon-trash');
    		
        var tr = $('<tr>');
        var novaLinhaServico = $('<td>');
        var novaLinhaStatus = $('<td>');
        var novaLinhaDescricao = $('<td>');

        novaLinhaServico.text("Aplicação");
        if(lista.status == "UP"){
        	
        	novaLinhaStatus.addClass("success");
        	novaLinhaStatus.text(lista.status);
        	
        		
        }
        novaLinhaDescricao.text("Servidor: Online");

        tr.append(novaLinhaServico);
        tr.append(novaLinhaStatus);
        tr.append(novaLinhaDescricao);

        tbody.append(tr);
        
        var tr = $('<tr>');
        var novaLinhaServico = $('<td>');
        var novaLinhaStatus = $('<td>');
        var novaLinhaDescricao = $('<td>');

        novaLinhaServico.text("Banco de dados");
        if(lista.db.status == "UP"){
        	novaLinhaStatus.addClass("success");
        	novaLinhaStatus.text(lista.db.status);
        		
        }
  
        novaLinhaDescricao.text(lista.db.database);

        tr.append(novaLinhaServico);
        tr.append(novaLinhaStatus);
        tr.append(novaLinhaDescricao);

        tbody.append(tr);
        
        var tr = $('<tr>');
        var novaLinhaServico = $('<td>');
        var novaLinhaStatus = $('<td>');
        var novaLinhaDescricao = $('<td>');

        novaLinhaServico.text("Espaço em disco");
        if(lista.diskSpace.status == "UP"){
        	novaLinhaStatus.addClass("success");
        	novaLinhaStatus.text(lista.diskSpace.status);
        		
        }
        
        
        var resumo = "Total: "+lista.diskSpace.total+"  Free: "+lista.diskSpace.free+"  threshold: "+lista.diskSpace.threshold;
        
        novaLinhaDescricao.text(resumo);

        tr.append(novaLinhaServico);
        tr.append(novaLinhaStatus);
        tr.append(novaLinhaDescricao);

        tbody.append(tr);

    
}

$(document).ready(function () {

    $.getJSON("https://oficina-manutencao.herokuapp.com/health", function (lista) {

        var tbody = $("#tbody");

        console.log(lista);
        
        preecheTabela(lista, tbody)


    });
});