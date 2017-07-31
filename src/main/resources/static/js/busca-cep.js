$(document).ready(function () {

    function limpa_formulário_cep() {
        // Limpa valores do formulário de cep.
        $("#rua").val("");
        $("#bairro").val("");
        $("#cidade").val("");
        $("#uf").val("");
        $("#ibge").val("");

    }

    //Quando o campo cep perde o foco.
    $("#cep").blur(function () {
        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if (validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $("#rua").val("...");
                $("#bairro").val("...");
                $("#cidade").val("...");
                $("#uf").val("...");
                $("#ibge").val("...");
                $("#endereco").val("...");

                //Consulta o webservice viacep.com.br/
                $.getJSON("//viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {
                    var enderecoCompleto = "";
                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.

                        if (dados.logradouro.trim()) {

                            enderecoCompleto = enderecoCompleto.concat(dados.logradouro);
                        }
                        if (dados.bairro.trim()) {

                            enderecoCompleto = enderecoCompleto.concat(", " + dados.bairro);
                        }
                        if (dados.localidade.trim()) {

                            enderecoCompleto = enderecoCompleto.concat(", " + dados.localidade);
                        }
                        if (dados.uf.trim()) {
                            enderecoCompleto = enderecoCompleto.concat(", " + dados.uf);
                        }


                        console.log("endereco-->" + enderecoCompleto);
                        console.log("rua-->" + dados.logradouro);
                        console.log("bairro-->" + dados.bairro);
                        console.log("cidade-->" + dados.localidade);
                        console.log("uf-->" + dados.uf);
                        console.log("ibge-->" + dados.ibge);

                        $("#endereco").val(enderecoCompleto);
                    } //end if.
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        alert("CEP não encontrado.");
                    }
                });
            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    });
});

/*
function atualizacep(cep) {
    cep = cep.replace(/\D/g, "");
    url = "http://viacep.com.br/ws/" + cep + "/json/";
    console.log(url);
    s = document.createElement('script');
    s.setAttribute('charset', 'utf-8');
    s.src = url;
    document.querySelector('head').appendChild(s);
}

function correiocontrolcep(valor) {
    if (valor.erro) {
        alert('Cep não encontrado');
        return;
    };
     document.getElementById('endereco').value = "teste";
    document.getElementById('endereco').value = valor.logradouro.concat(valor.bairro).concat(valor.localidade).concat(valor.uf);
}
*/
