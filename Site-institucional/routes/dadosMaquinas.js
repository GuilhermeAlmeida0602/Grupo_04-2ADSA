var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var dadosMaquina = require('../models').dadosMaquina;
var env = process.env.NODE_ENV || 'development';


router.get('/statusCpu/:fkMaquina', function (req, res, next) {

	//Para pegar uma máquina em especifico
	let fkMaquina = req.params.fkMaquina;

	console.log("Verificando status do card CPU");

	let instrucaoSql = ``;

	if(env == "production"){
        instrucaoSql = `SELECT TOP 7 emUsoCPU, dataRegistro FROM dadosMaquina WHERE fkMaquina = ${fkMaquina} ORDER BY idDadosMaquina DESC;`
    }else{
        instrucaoSql = `SELECT emUsoCPU, dataRegistro FROM dadosMaquina WHERE fkMaquina = ${fkMaquina} ORDER BY idDadosMaquina DESC LIMIT 7;`;
    }

	sequelize.query(instrucaoSql, {
		model: dadosMaquina,
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

router.get('/statusRam/:fkMaquina', function (req, res, next) {

	//Para pegar uma máquina em especifico
	let fkMaquina = req.params.fkMaquina;

	console.log("Verificando status do card CPU");

	let instrucaoSql = ``;

	if(env == "production"){
        instrucaoSql = `SELECT TOP 7 emUsoMEM, dataRegistro FROM dadosMaquina WHERE fkMaquina = ${fkMaquina} ORDER BY idDadosMaquina DESC;`
    }else{
        instrucaoSql = `SELECT emUsoMEM, dataRegistro FROM dadosMaquina WHERE fkMaquina = ${fkMaquina} ORDER BY idDadosMaquina DESC LIMIT 7;`;
    }

	sequelize.query(instrucaoSql, {
		model: dadosMaquina,
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