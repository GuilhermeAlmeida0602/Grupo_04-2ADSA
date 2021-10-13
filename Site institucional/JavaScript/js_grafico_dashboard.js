
function vermelho() {

    for (var n_vezes = 0; n_vezes < 2; n_vezes++) {

        document.querySelectorAll(".tabela_tr .td_status")[n_vezes].textContent = "Emergência";
        var status = document.querySelectorAll(".tabela_tr .td_status")[n_vezes];
        status.style.color = '#EA2027';
        document.querySelectorAll(".tabela_tr")[n_vezes].style.visibility = 'visible';
    }

    // document.querySelectorAll(".tabela_tr")[1].style.visibility = 'visible';
    document.querySelectorAll(".tabela_tr")[2].style.visibility = 'hidden';

    document.querySelectorAll(".tabela_tr .td_id")[0].textContent = "1";
    document.querySelectorAll(".tabela_tr .td_hora")[0].textContent = "2";
    document.querySelectorAll(".tabela_tr .td_id")[1].textContent = "4";
    document.querySelectorAll(".tabela_tr .td_hora")[1].textContent = "1";
}

function amarelo() {

    for (var n_vezes = 0; n_vezes < 1; n_vezes++) {

        document.querySelectorAll(".tabela_tr .td_status")[n_vezes].textContent = "Alerta";
        var status = document.querySelectorAll(".tabela_tr .td_status")[n_vezes];
        status.style.color = '#FFC312';
    }

    document.querySelectorAll(".tabela_tr")[1].style.visibility = 'hidden';
    document.querySelectorAll(".tabela_tr")[2].style.visibility = 'hidden';

    document.querySelectorAll(".tabela_tr .td_id")[0].textContent = "10";
    document.querySelectorAll(".tabela_tr .td_hora")[0].textContent = "3";
}

function verde() {

    for (var n_vezes = 0; n_vezes <= 2; n_vezes++) {

        document.querySelectorAll(".tabela_tr .td_status")[n_vezes].textContent = "Ok";
        var status = document.querySelectorAll(".tabela_tr .td_status")[n_vezes];
        status.style.color = '#009432';
        document.querySelectorAll(".tabela_tr")[n_vezes].style.visibility = 'visible';
    }

    document.querySelectorAll(".tabela_tr .td_id")[0].textContent = "7";
    document.querySelectorAll(".tabela_tr .td_hora")[0].textContent = "0";
    document.querySelectorAll(".tabela_tr .td_id")[1].textContent = "8";
    document.querySelectorAll(".tabela_tr .td_hora")[1].textContent = "0";
    document.querySelectorAll(".tabela_tr .td_id")[2].textContent = "15";
    document.querySelectorAll(".tabela_tr .td_hora")[2].textContent = "0";
}