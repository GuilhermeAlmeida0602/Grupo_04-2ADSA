src = "https://cdn.jsdelivr.net/npm/chart.js";
src = "JavaScript/js_menu.js";
src = "JavaScript/js_grafico_dashboard.js";



var maquinas;
var qntdOk = 0;
var qntdAlerta = 0;
var qntdEmergencia = 0;
var colorStatus;
var fkEmpresa = sessionStorage.fk_empresa_meuapp;

function vermelho() {

    var qntdEmergencia = 0;
    lista_totens.innerHTML = ""
    let infoMaq = maquinas[1];


    for (let i = 0; i < infoMaq.length; i++) {

        var situacaoMaq = infoMaq[i].statusMaq;
        
        if (situacaoMaq == "Emergência") {

            lista_totens.innerHTML +=
            `
                <tr class="tabela_tr">
                    <td id="fk_totem" class="td_id">${infoMaq[i].fkMaquina}</td>
                    <td id="status_totem" class="td_status" style="color:red;">${infoMaq[i].statusMaq}</td>
                    <td onclick="idTotem(${infoMaq[i].fkMaquina})">
                        <a href="visao_detalhada.html">
                        <i class="fas fa-tools ferramenta"></i>
                        </a>
                    </td>
                </tr>
            `
            qntdEmergencia++;
        }
    }
}

function amarelo() {

    var qntdAlerta = 0;
    lista_totens.innerHTML = ""
    let infoMaq = maquinas[1];


    for (let i = 0; i < infoMaq.length; i++) {

        var situacaoMaq = infoMaq[i].statusMaq;

        if (situacaoMaq == "Alerta") {

            lista_totens.innerHTML +=
            `
                <tr class="tabela_tr">
                    <td id="fk_totem" class="td_id">${infoMaq[i].fkMaquina}</td>
                    <td id="status_totem" class="td_status" style="color:orange;">${infoMaq[i].statusMaq}</td>
                    <td  onclick="idTotem(${infoMaq[i].fkMaquina})">
                        <a href="visao_detalhada.html">
                        <i class="fas fa-tools ferramenta"></i>
                        </a>
                    </td>
                </tr>
            `
            
            qntdAlerta++;
        }
 
    }
}

function verde() {
    var qntdOk = 0;
    lista_totens.innerHTML = ""
    let infoMaq = maquinas[1];


    for (let i = 0; i < infoMaq.length; i++) {

        var situacaoMaq = infoMaq[i].statusMaq;

        if (situacaoMaq == "Ok") {
            
            lista_totens.innerHTML +=
            `
                <tr class="tabela_tr">
                    <td id="fk_totem" class="td_id">${infoMaq[i].fkMaquina}</td>
                    <td id="status_totem" class="td_status" style="color:green;">${infoMaq[i].statusMaq}</td>
                    <td onclick="idTotem(${infoMaq[i].fkMaquina})">
                        <a href="visao_detalhada.html">
                        <i class="fas fa-tools ferramenta"></i>
                        </a>
                    </td>
                </tr>
            `
            qntdOk++;
        }
    }
}

function obterMaquinas() {

    fetch(`/statusMaquina/${fkEmpresa}`)
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
    let infoMaq = maquinas[1];

    qntdOk = 0;
    qntdAlerta = 0;
    qntdEmergencia = 0;

    for (let i = 0; i < infoMaq.length; i++) {

        var situacaoMaq = infoMaq[i].statusMaq;

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
    let infoMaq = maquinas[1];

    contarStatus();

    setTimeout(() => obterMaquinas(), 30000);
    

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

    vermelho()


}

function idTotem(fkMaquina){
    sessionStorage.fk_maquina_meuapp = fkMaquina;
}