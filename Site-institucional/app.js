process.env.NODE_ENV = 'production'; // altere para 'production' ou 'dev'

var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usuariosRouter = require('./routes/usuarios');
var maquinasRouter = require('./routes/maquinas');
var statusMaquinaRouter = require('./routes/statusMaquina');
var dadosMaquinasRouter = require('./routes/dadosMaquinas');
var dadosDiscosRouter = require('./routes/dadosDiscos');
var processosMaquinasRouter = require('./routes/processosMaquinas');

var app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/usuarios', usuariosRouter);
app.use('/maquinas', maquinasRouter);
app.use('/statusMaquina', statusMaquinaRouter);
app.use('/dadosMaquinas', dadosMaquinasRouter);
app.use('/dadosDiscos', dadosDiscosRouter);
app.use('/processosMaquinas', processosMaquinasRouter);


module.exports = app;
