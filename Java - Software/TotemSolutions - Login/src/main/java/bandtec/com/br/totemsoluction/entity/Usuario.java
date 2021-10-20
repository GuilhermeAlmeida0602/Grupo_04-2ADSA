package bandtec.com.br.totemsoluction.entity;

/**
 *
 * @author vitor
 */
public class Usuario {

    private Integer idUsuario;
    private Integer fkEmpresa;
    private String login;
    private String senha;

    public Usuario() {

    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}
