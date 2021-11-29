var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Maquina = require('../models').Maquina;
var dadosMaquina = require('../models').dadosMaquina;
var Disco = require('../models').Disco;
var env = process.env.NODE_ENV || 'development';


router.put('/reiniciar/:fkMaquina', function (req, res, next) {
	console.log('Iniciando agendamento de reiniciamento no banco');

	let fkMaquina = req.params.fkMaquina;

	let instrucaoSql = `UPDATE Maquina SET reiniciar= 1 WHERE idMaquina=${fkMaquina};`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql)
});

router.put('/limparCache/:fkMaquina', function (req, res, next) {
	console.log('Iniciando agendamento de limpeza de cache no banco');

	let fkMaquina = req.params.fkMaquina;

	let instrucaoSql = `UPDATE Maquina SET limpezaDeCache=1 WHERE idMaquina=${fkMaquina};`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql)
});

router.get('/infoMaquina/:fkMaquina', function (req, res, next) {

	//Para pegar uma máquina em especifico
	let fkMaquina = req.params.fkMaquina;

	console.log("Verificando status do card CPU");

	let instrucaoSql = `SELECT TOP 1 m.idMaquina, m.hostname, m.sistemaOperacionalSO, m.nomeCPU, m.dataDeRegistro, d.nome, d.tamanho, dm.totalMEM, dm.inicializadoSO, 
	dm.tempoDeAtividadeSO FROM Maquina as m INNER JOIN Disco AS d ON d.fkMaquina = (m.idMaquina) INNER JOIN DadosMaquina AS dm ON dm.fkMaquina = (m.idMaquina) WHERE 
	 m.idMaquina = ${fkMaquina} AND d.idDisco=(SELECT min(idDisco) FROM Disco WHERE fkMaquina = ${fkMaquina}) 
	 AND dm.idDadosMaquina=(SELECT max(idDadosMaquina) FROM DadosMaquina WHERE fkMaquina = ${fkMaquina});`;

	sequelize.query(instrucaoSql, {
		model: (Maquina, dadosMaquina, Disco),
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