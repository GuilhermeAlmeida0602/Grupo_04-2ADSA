src = "https://cdn.jsdelivr.net/npm/chart.js";
src = "JavaScript/js_menu.js";
src = "JavaScript/js_grafico_dashboard.js";

var maquinas;
obterMaquinas();

var qntdOk = 0;
var qntdAlerta = 0;
var qntdEmergencia = 0;
var colorStatus;


function vermelho() {

    var qntdEmergencia = 0;

    for (let i = 0; i < maquinas.length; i++) {
        let encontrados = maquinas[i];

        var situacaoMaq = encontrados[i].statusMaq;


        if (situacaoMaq == "Emergência") {
            qntdEmergencia++;
        }

        for (var n_vezes = 0; n_vezes < qntdEmergencia; n_vezes++) {

            document.querySelectorAll(".tabela_tr .td_status")[n_vezes].textContent = "Emergência";
            var status = document.querySelectorAll(".tabela_tr .td_status")[n_vezes];
            status.style.color = '#EA2027';
            document.querySelectorAll(".tabela_tr")[n_vezes].style.visibility = 'visible';
            document.querySelectorAll(".tabela_tr .td_id")[n_vezes].textContent = encontrados[i].fkMaquina;
        }
    }




}

function amarelo() {

    var qntdAlerta = 0;



    for (let i = 0; i < maquinas.length; i++) {
        let encontrados = maquinas[i];

        var situacaoMaq = encontrados[i].statusMaq;

        if (situacaoMaq == "Alerta") {
            qntdAlerta++;
        }

        for (var n_vezes = 0; n_vezes < qntdAlerta; n_vezes++) {

            document.querySelectorAll(".tabela_tr .td_status")[n_vezes].textContent = "Alerta";
            var status = document.querySelectorAll(".tabela_tr .td_status")[n_vezes];
            status.style.color = '#FFC312';
            document.querySelectorAll(".tabela_tr")[n_vezes].style.visibility = 'visible';
            document.querySelectorAll(".tabela_tr .td_id")[n_vezes].textContent = encontrados[i].fkMaquina;
        }
    }


}

function verde() {
    var qntdOk = 0;

    for (let i = 0; i < maquinas.length; i++) {
        let encontrados = maquinas[i];

        var situacaoMaq = encontrados[i].statusMaq;

        if (situacaoMaq == "Ok") {
            qntdOk++;
        }

        for (var n_vezes = 0; n_vezes < qntdOk; n_vezes++) {

            if (situacaoMaq == "Ok") {
                document.querySelectorAll(".tabela_tr .td_status")[n_vezes].textContent = "Ok";
                var status = document.querySelectorAll(".tabela_tr .td_status")[n_vezes];
                status.style.color = '#009432';
                document.querySelectorAll(".tabela_tr")[n_vezes].style.visibility = 'visible';
                document.querySelectorAll(".tabela_tr .td_id")[n_vezes].textContent = encontrados[i].fkMaquina;
            }

        }

    }

}

function obterMaquinas() {

    fetch(`./statusMaquina`)
        .then(resposta => {
            if (resposta.ok) {
                resposta.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    // alert(JSON.stringify(resposta))
                    var maquinas_encontradas = resposta;
                    maquinas = maquinas_encontradas;

                    //let teste = maquinas[0]

                    //alert(teste[0].statusMaq);

                    carregar_maquinas()
                });
            } else {
                console.error('Nenhum dado encontrado ou erro na API');
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção das publicações do usuário: ${error.message}`);
        });
}

function contarStatus() {

    for (let i = 0; i < maquinas.length; i++) {
        let encontrados = maquinas[i];

        var situacaoMaq = encontrados[i].statusMaq;

        if (situacaoMaq == "Ok") {
            colorStatus = "green";
            qntdOk++;
        } else if (situacaoMaq == "Alerta") {
            colorStatus = "orange";
            qntdAlerta++;
        } else {
            colorStatus = "red";
            qntdEmergencia++;
        }

    }

}

function carregar_maquinas() {

    contarStatus();

 
        cardStatus.innerHTML =
            `<p class="p_status">Selecione o status</p>
            <a href="#" onclick="vermelho()">
                <div class="quadrado_informativo vermelho">
                    <div class="cor_status">Emergência</div>
                    <!--<div class="indicadores_grafico">2 toten(s)</div>-->
                    <div class="indicadores_grafico" id="indic_grafico">${qntdEmergencia} toten(s)</div>
                </div>
            </a>
            <a href="#" onclick="amarelo()">
                <div class="quadrado_informativo amarelo">
                    <div class="cor_status">Alerta</div>
                    <div class="indicadores_grafico" id="indic_grafico">${qntdAlerta} toten(s)</div>
                </div>
            </a>
            <a href="#" onclick="verde()">
                <div class="quadrado_informativo verde">
                    <div class="cor_status">Ok</div>
                    <div class="indicadores_grafico" id="indic_grafico">${qntdOk} toten(s)</div>
                </div>
            </a>`;

        sessao_grafico.innerHTML =
            `<div class="quadrado_grafico">
                <p class="p_grafico">Situação atual dos totens</p>
                <!-- Grafico -->
                <div class="div_grafico">
                    <canvas id="myChartt"></canvas>
                    <div class="info_totens">
                        Total de totens: ${qntdEmergencia+qntdAlerta+qntdOk}
                        <br>
                        Totens em status de emergência: ${qntdEmergencia}<br>
                        Totens em status de alerta: ${qntdAlerta}<br>
                        Totens em status ok: ${qntdOk}<br>
                    </div>
                </div>
                
            </div>`

        var idBody = document.getElementById('myChartt').getContext('2d');
        var myChartt = new Chart(idBody, {
            type: 'doughnut',
            data: {
                labels: ['Emergência', 'Alerta', 'Ok'],
                datasets: [{
                    label: '# of Votes',
                    data: [qntdEmergencia, qntdAlerta, qntdOk],
                    backgroundColor: [
                        'rgba(231, 76, 60, 0.9)',
                        'rgba(241, 196, 15, 0.9)',
                        'rgba(39, 174, 96, 0.9)'
                    ]
                }]
            },
            options: {
                plugins: {
                    legend: {
                        display: true,
                        position: 'bottom',
                        labels: {
                            color: 'black',
                        }
                    }
                }
            }
        });

        //Zerando variavel para não acumular sem precisar
        qntdOk = 0



}