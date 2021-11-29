module.exports = {
  // Insira aqui seus dados do banco NA NUVEM AZURE
  production: {
      // altere APENAS username, password, database e host.
      username: 'infosystems-bd',
      password: '#Gfgrupo4',
      database: 'infoSystems',
      host: 'infosystems-server.database.windows.net',
      dialect: 'mssql',
      xuse_env_variable: 'DATABASE_URL',
      dialectOptions: {
          options: {
              encrypt: true
          }
      },
      pool: {
          max: 5,
          min: 1,
          acquire: 5000,
          idle: 30000,
          connectTimeout: 5000
      }
  },
// 
  // Insira aqui seus dados do banco LOCAL - MySQL Workbench
  dev: {
      // altere APENAS username, password e database.
      username: 'root',
      password: 'senha',
      database: 'InfoSystems',
      host: '127.0.0.1',
      dialect: 'mysql',
      xuse_env_variable: 'DATABASE_URL',
      dialectOptions: {
          options: {
              encrypt: true
          }
      },
      pool: {
          max: 5,
          min: 1,
          acquire: 5000,
          idle: 30000,
          connectTimeout: 5000
      }
  },
};