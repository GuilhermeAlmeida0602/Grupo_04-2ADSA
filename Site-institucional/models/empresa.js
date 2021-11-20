'use strict';

module.exports = (sequelize, DataTypes) => {
    let Empresa = sequelize.define('Empresa', {
        idEmpresa: {
            field: 'idEmpresa',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        nomeEmpresa: {
            field: 'nomeEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        cnpj: {
            field: 'cnpj',
            type: DataTypes.CHAR,
            allowNull: false
        },
        nomeResponsavel: {
            field: 'nomeResponsavel',
            type: DataTypes.STRING,
            allowNull: false
        },
        telResponsavel: {
            field: 'telResponsavel',
            type: DataTypes.CHAR,
            allowNull: false
        },
        emailEmpresa: {
            field: 'emailEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        senhaEmpresa: {
            field: 'senhaEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        cepEmpresa: {
            field: 'cepEmpresa',
            type: DataTypes.CHAR,
            allowNull: false
        },
        logradouroEmpresa: {
            field: 'logradouroEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        numeroEmpresa: {
            field: 'numeroEmpresa',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        complementoEmpresa: {
            field: 'complementoEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        bairroEmpresa: {
            field: 'bairroEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        cidadeEmpresa: {
            field: 'cidadeEmpresa',
            type: DataTypes.STRING,
            allowNull: false
        },
        ufEmpresa: {
            field: 'ufEmpresa',
            type: DataTypes.CHAR,
            allowNull: false
        },
    },
        {
            tableName: 'Empresa',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return Empresa;
};
