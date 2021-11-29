'use strict';

module.exports = (sequelize, DataTypes) => {
    let dadosDisco = sequelize.define('dadosDisco', {
        idDisco: {
            field: 'idDadosDisco',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        fkMaquina: {
            field: 'fkDisco',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        discoDisponivelHD: {
            field: 'discoDisponivelHD',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        dataRegistroDados: {
            field: 'dataRegistroDados',
            type: DataTypes.DATE,
            allowNull: false
        },
    },
        {
            tableName: 'dadosDisco',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return dadosDisco;
};
