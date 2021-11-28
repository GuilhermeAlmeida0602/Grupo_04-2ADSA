'use strict';

module.exports = (sequelize, DataTypes) => {
    let processosMaquina = sequelize.define('processosMaquina', {
        idprocessoMaquina: {
            field: 'idprocessoMaquina',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        fkMaquina: {
            field: 'fkDisco',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        processo: {
            field: 'processo',
            type: DataTypes.STRING,
            allowNull: false
        },
        pid: {
            field: 'pid',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        usoCPU: {
            field: 'usoCPU',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        usoMemoria: {
            field: 'usoMemoria',
            type: DataTypes.FLOAT,
            allowNull: false
        },
        encerrarProcessos: {
            field: 'encerrarProcessos',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        dataProcesso: {
            field: 'dataProcesso',
            type: DataTypes.DATE,
            allowNull: false
        },
    },
        {
            tableName: 'processosMaquina',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return processosMaquina;
};
