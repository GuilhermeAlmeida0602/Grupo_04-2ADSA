'use strict';

module.exports = (sequelize, DataTypes) => {
    let Maquina = sequelize.define('Maquina', {
        idMaquina: {
            field: 'idMaquina',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        fkEmpresa: {
            field: 'fkEmpresa',
            type: DataTypes.INTEGER, 
            allowNull: false
        },
        hostname: {
            field: 'hostname',
            type: DataTypes.STRING,
            allowNull: false
        },
        sistemaOperacionalSO: {
            field: 'sistemaOperacionalSO',
            type: DataTypes.STRING,
            allowNull: false
        },
        arquiteturaSO: {
            field: 'arquiteturaSO',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        fabricanteCPU: {
            field: 'fabricanteCPU',
            type: DataTypes.STRING,
            allowNull: false
        },
        nomeCPU: {
            field: 'nomeCPU',
            type: DataTypes.STRING,
            allowNull: false
        },
        identificadorCPU: {
            field: 'identificadorCPU',
            type: DataTypes.STRING,
            allowNull: false
        },
        microArquiteturaCPU: {
            field: 'microArquiteturaCPU',
            type: DataTypes.STRING,
            allowNull: false
        },
        frequenciaCPU: {
            field: 'frequenciaCPU',
            type: DataTypes.STRING,
            allowNull: false
        },
        pacotesFisicosCPU: {
            field: 'pacotesFisicosCPU',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        cpuFisicosCPU: {
            field: 'cpuFisicosCPU',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        cpuLogicosCPU: {
            field: 'cpuLogicosCPU',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        ip: {
            field: 'ip',
            type: DataTypes.STRING,
            allowNull: false
        },
        reiniciar: {
            field: 'reiniciar',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        limpezaDeCache: {
            field: 'limpezaDeCache',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        dataDeRegistro: {
            field: 'dataDeRegistro',
            type: DataTypes.DATE,
            allowNull: false
        },
    },
        {
            tableName: 'Maquina',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return Maquina;
};
