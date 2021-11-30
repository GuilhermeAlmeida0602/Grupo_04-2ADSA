var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Disco = require('../models').Disco;
var dadosDisco = require('../models').dadosDisco;
var env = process.env.NODE_ENV || 'development';


router.get('/idDisco/:fkMaquina', function (req, res, next) {

    //Para pegar uma máquina em especifico
    let fkMaquina = req.params.fkMaquina;

    console.log("Verificando status do card CPU");

    let instrucaoSql;

    if(env == "production"){
        instrucaoSql = `SELECT TOP 1 idDisco FROM disco WHERE fkMaquina = ${fkMaquina} ORDER BY idDisco;`;
    }else{
        instrucaoSql = `SELECT idDisco FROM disco WHERE fkMaquina = ${fkMaquina} ORDER BY idDisco LIMIT 1;`;
    }

    sequelize.query(instrucaoSql, {
        model: Disco
    })
        .then(resultado => {
            if (resultado.length == 1) {
                console.log(`Encontrados: ${resultado.length}`);
                res.json(resultado[0]);
            }
        }).catch(erro => {
            console.error(erro);
            res.status(500).send(erro.message);
        });

});

router.get('/statusDisco/:fkDisco/:fkMaquina', function (req, res, next) {

    //Para pegar uma máquina em especifico
    let fkDisco = req.params.fkDisco;
    let fkMaquina = req.params.fkMaquina;

    console.log("Verificando status do card CPU");

    let instrucaoSql = ``;

    if(env == "production"){
        instrucaoSql = `SELECT TOP 1 discoDisponivelHD FROM dadosdisco where fkDisco = ${fkDisco} ORDER BY idDadosDisco DESC;`;
    }else{
        instrucaoSql = `SELECT discoDisponivelHD FROM dadosdisco where fkDisco = ${fkDisco} ORDER BY idDadosDisco DESC LIMIT 1;`;
    }

    sequelize.query(instrucaoSql, {
        model: dadosDisco,
        mapToModel: true
    })
        .then(resultado => {
            console.log(`Encontrados: ${resultado.length}`);
            res.json(resultado);
        }).catch(erro => {
            console.error(erro);
            res.status(500).send(erro.message);
        });

});

module.exports = router;