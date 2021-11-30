var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var statusMaquina = require('../models').statusMaquina;
var env = process.env.NODE_ENV || 'development';


router.get('/:fkEmpresa', function (req, res, next) {

	//Para pegar uma máquina em especifico
	let fkEmpresa = req.params.fkEmpresa;

	console.log("Recuperando o status das máquinas");

	let instrucaoSql = `select sm.fkMaquina, sm.statusMaq, sm.dataStatus from maquina as m inner 
	join statusmaquina as sm on sm.fkMaquina = (idMaquina) where m.fkEmpresa = ${fkEmpresa};`;

	sequelize.query(instrucaoSql, {
		model: statusMaquina,
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
