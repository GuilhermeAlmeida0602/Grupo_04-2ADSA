'use strict';

module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario', {
        idUsuario: {
            field: 'idUsuario',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        fkEmpresa: {
            field: 'fkEmpresa',
            type: DataTypes.INTEGER,
            allowNull: false
        },
        priNome: {
            field: 'priNome',
            type: DataTypes.STRING,
            allowNull: false
        },
        ultNome: {
            field: 'ultNome',
            type: DataTypes.STRING,
            allowNull: false
        },
        telCelUsuario: {
            field: 'telCelUsuario',
            type: DataTypes.CHAR,
            allowNull: false
        },
        telFixUsuario: {
            field: 'telFixUsuario',
            type: DataTypes.CHAR,
            allowNull: false
        },
        emailUsuario: {
            field: 'emailUsuario',
            type: DataTypes.STRING,
            allowNull: false
        },
        senhaUsuario: {
            field: 'senhaUsuario',
            type: DataTypes.CHAR,
            allowNull: false
        },
    },
        {
            tableName: 'Usuario',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return Usuario;
};
