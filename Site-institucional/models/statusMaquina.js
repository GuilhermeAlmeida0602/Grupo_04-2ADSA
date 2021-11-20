'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let StatusMaquina = sequelize.define('StatusMaquina',{	
		fkMaquina: {
			field: 'fkMaquina',
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
