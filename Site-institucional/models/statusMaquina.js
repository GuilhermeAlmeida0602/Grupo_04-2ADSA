'use strict';

module.exports = (sequelize, DataTypes) => {
    let StatusMaquina = sequelize.define('StatusMaquina',{	
		fkMaquina: {
			field: 'fkMaquina',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: false
		},	
		fkEmpresa: {
			field: 'fkEmpresa',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: false
		},	
		statusMaq: {
			field: 'statusMaq',
			type: DataTypes.STRING,
			allowNull: false
		},
		dataStatus: {
			field: 'dataStatus',
			type: DataTypes.DATE, // NÃO existe DATETIME. O tipo DATE aqui já tem data e hora
			allowNull: false
		}
	}, 
	{
		tableName: 'StatusMaquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return StatusMaquina;
};
