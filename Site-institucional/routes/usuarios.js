var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Empresa = require('../models').Empresa; // Variável necessária para cadastro das empresas
var Usuario = require('../models').Usuario; // Variável necessária para cadastro dos usuários

let sessoes = [];

/* Recuperar usuário por email e senha */ // PARA LOGIN COMO EMPRESA
router.post('/autenticarE', function(req, res, next) {
	console.log('Recuperando usuário por email e senha');

	var emailEmpresa = req.body.emailEmpresa;
	var senhaEmpresa = req.body.senhaEmpresa;	
	
	let instrucaoSql = `select * from Empresa where emailEmpresa='${emailEmpresa}' and senhaEmpresa='${senhaEmpresa}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Empresa
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.emailEmpresa); // adicionando no vetor 'sessoes' que o login foi executado OK
			console.log('sessoes: ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) { // se retornar como 0, significa que o email e senha está vazio
			res.status(403).send('email e/ou senha inválido(s)');
		} else { // esse aqui verifica se existe mais de um usuario com o mesmo email e senha
			res.status(403).send('Mais de um usuário com o mesmo email e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message); // a mensagem é voltada automaticamente do java, como se fosse no JAVA
  	});
});

/* Recuperar usuário por email e senha */ // PARA LOGIN COMO USUARIO
router.post('/autenticarU', function(req, res, next) {
	console.log('Recuperando usuário por email e senha');

	var emailUsuario = req.body.emailUsuario;
	var senhaUsuario = req.body.senhaUsuario;	
	
	let instrucaoSql = `select * from Usuario where emailUsuario='${emailUsuario}' and senhaUsuario='${senhaUsuario}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.emailUsuario); // adicionando no vetor 'sessoes' que o login foi executado OK
			console.log('sessoes: ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) { // se retornar como 0, significa que o email e senha está vazio
			res.status(403).send('email e/ou senha inválido(s)');
		} else { // esse aqui verifica se existe mais de um usuario com o mesmo email e senha
			res.status(403).send('Mais de um usuário com o mesmo email e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message); // a mensagem é voltada automaticamente do java, como se fosse no JAVA
  	});
});

/* Cadastrar uma EMPRESA */
router.post('/cadastrarE', function(req, res, next) {
	console.log('Criando uma empresa');
	
	Empresa.create({
		nomeEmpresa : req.body.nomeEmpresa,
		cnpj : req.body.cnpj,
		nomeResponsavel : req.body.nomeResponsavel,
		telResponsavel : req.body.telResponsavel,
		emailEmpresa : req.body.emailEmpresa,
		senhaEmpresa : req.body.senhaEmpresa,
		cepEmpresa : req.body.cepEmpresa,
		logradouroEmpresa : req.body.logradouroEmpresa,
		numeroEmpresa : req.body.numeroEmpresa,
		complementoEmpresa : req.body.complementoEmpresa,
		bairroEmpresa : req.body.bairroEmpresa,
		cidadeEmpresa : req.body.cidadeEmpresa,
		ufEmpresa : req.body.ufEmpresa
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Cadastrar um USUARIO */
router.post('/cadastrarU/:idEmpresa', function(req, res, next) {
	console.log('Criando uma usuário');
	
	let id = req.params.idEmpresa
	// const idEmpresa = req.params.idEmpresa

	Usuario.create({
		fkEmpresa : id,
		priNome : req.body.priNome,
		ultNome : req.body.ultNome,
		telCelUsuario : req.body.telCelUsuario,
		telFixUsuario : req.body.telFixUsuario,
		emailUsuario : req.body.emailUsuario,
		senhaEmpresa : req.body.senhaEmpresa,
		senhaUsuario : req.body.senhaUsuario
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});


/* Verificação de usuário */
router.get('/sessao/:emailEmpresa', function(req, res, next) {
	let emailEmpresa = req.params.emailEmpresa;
	console.log(`Verificando se o usuário ${emailEmpresa} tem sessão`);
	
	let tem_sessao = false;
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] == emailEmpresa) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${emailEmpresa} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
	
});


/* Logoff de usuário */
router.get('/sair/:login', function(req, res, next) {
	let emailEmpresa = req.params.emailEmpresa;
	console.log(`Finalizando a sessão do usuário ${emailEmpresa}`);
	let nova_sessoes = []
	for (let u=0; u<sessoes.length; u++) {
		if (sessoes[u] != emailEmpresa) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${emailEmpresa} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', function(req, res, next) {
	console.log('Recuperando todos os usuários');
	Empresa.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;
