'use strict';

module.exports = (sequelize, DataTypes) => {
    let Disco = sequelize.define('Disco', {
        idDisco: {
            field: 'idDisco',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        fkMaquina: {
            field: 'fkMaquina',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        nome: {
            field: 'nome',
            type: DataTypes.STRING,
            allowNull: false
        },
        modelo: {
            field: 'modelo',
            type: DataTypes.STRING,
            allowNull: false
        },
        tamanho: {
            field: 'tamanho',
            type: DataTypes.STRING,
            allowNull: false
        },
        qtdLeitura: {
            field: 'qtdLeitura',
            type: DataTypes.STRING,
            allowNull: false
        },
        bytesLeitura: {
            field: 'bytesLeitura',
            type: DataTypes.STRING,
            allowNull: false
        },
        qtdEscritas: {
            field: 'qtdEscritas',
            type: DataTypes.STRING,
            allowNull: false
        },
        tipo: {
            field: 'tipo',
            type: DataTypes.STRING,
            allowNull: false
        },
        montagem: {
            field: 'montagem',
            type: DataTypes.STRING,
            allowNull: false
        },
        dataDeRegistro: {
            field: 'dataDeRegistro',
            type: DataTypes.DATE,
            allowNull: false
        },
    },
        {
            tableName: 'Disco',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return Disco;
};
