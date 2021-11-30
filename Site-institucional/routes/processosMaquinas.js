var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var processosMaquina = require('../models').processosMaquina;
var env = process.env.NODE_ENV || 'development';


router.get('/statusProcessosMaquina/:fkMaquina', function (req, res, next) {

    //Para pegar uma máquina em especifico
    let fkMaquina = req.params.fkMaquina;

    console.log("Verificando status do card CPU");

    let instrucaoSql = ``;

    if(env == "production"){
        instrucaoSql = `SELECT TOP 6 * FROM processosMaquina WHERE usoMemoria >= 0.4 and usoCPU >= 5 and fkMaquina = ${fkMaquina} ORDER BY usoCPU DESC;`;
    }else{
        instrucaoSql = `SELECT * FROM processosMaquina WHERE usoMemoria >= 0.4 and usoCPU >= 5 and fkMaquina = ${fkMaquina} ORDER BY usoCPU DESC LIMIT 6;`;
    }

    sequelize.query(instrucaoSql, {
        model: processosMaquina,
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


router.get('/selectProcessos/:fkMaquina', function (req, res, next) {

    //Para pegar uma máquina em especifico
    let fkMaquina = req.params.fkMaquina;

    console.log("Verificando status do card CPU");

    let instrucaoSql = `SELECT * FROM ProcessosMaquina WHERE fkMaquina = ${fkMaquina};`;

    sequelize.query(instrucaoSql, {
        model: processosMaquina,
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


router.put('/encerrarProcesso/:fkMaquina/:idProcessosMaquina', function(req, res, next) {
	console.log('Iniciando agendamento no banco');	

    let fkMaquina = req.params.fkMaquina;
    let idProcessosMaquina = req.params.idProcessosMaquina;
	
	let instrucaoSql = `UPDATE ProcessosMaquina SET encerrarprocessos=1 WHERE fkMaquina=${fkMaquina} AND idprocessoMaquina=${idProcessosMaquina}`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql)
});


module.exports = router;