package bandtec.com.br.totemsoluction.entity;

/**
 *
 * @author vitor
 */
public class Maquina {

    private Long reiniciar;
    private Long limpezaDeCache;
    private Long processos;

    public Long getReiniciar() {
        return reiniciar;
    }

    public void setReiniciar(Long reiniciar) {
        this.reiniciar = reiniciar;
    }

    public Long getLimpezaDeCache() {
        return limpezaDeCache;
    }

    public void setLimpezaDeCache(Long limpezaDeCache) {
        this.limpezaDeCache = limpezaDeCache;
    }

    public Long getProcessos() {
        return processos;
    }

    public void setProcesos(Long processos) {
        this.processos = processos;
    }

}
