public class Pagina {
    private int idPagina;
    private int idProceso;
    private boolean bitUso;

    public Pagina(int idPagina,int idProceso) {
        this.idPagina = idPagina;
        this.idProceso = idProceso;
    }

    public int getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(int idPagina) {
        this.idPagina = idPagina;
    }

    public boolean getBitUso() {
        return bitUso;
    }

    public void setBitUso(boolean bitUso) {
        this.bitUso = bitUso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public String toString() {
        return "Pagina{" +
                "idPagina=" + idPagina +
                ", idProceso=" + idProceso +
                ", bitUso=" + bitUso +
                '}';
    }
}

