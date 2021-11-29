'use strict';

module.exports = (sequelize, DataTypes) => {
    let dadosMaquina = sequelize.define('dadosMaquina', {
        idDadosMaquina: {
            field: 'idEmpresa',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        fkMaquina: {
            field: 'fkMaquina',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        inicializadoSO: {
            field: 'inicializadoSO',
            type: DataTypes.STRING,
            allowNull: false
        },
        tempoDeAtividadeSO: {
            field: 'tempoDeAtividadeSO',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        usuarioSO: {
            field: 'usuarioSO',
            type: DataTypes.STRING,
            allowNull: false
        },
        emUsoCPU: {
            field: 'emUsoCPU',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        emUsoMEM: {
            field: 'emUsoMEM',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        disponivelMEM: {
            field: 'disponivelMEM',
            type: DataTypes.CHAR,
            allowNull: false
        },
        totalMEM: {
            field: 'totalMEM',
            type: DataTypes.STRING,
            allowNull: false
        },
        dataRegistro: {
            field: 'dataRegistro',
            type: DataTypes.DATE,
            allowNull: false
        },
    },
        {
            tableName: 'dadosMaquina',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return dadosMaquina;
};
