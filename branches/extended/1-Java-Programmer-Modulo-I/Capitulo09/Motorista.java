public class Motorista extends Funcionario {

    private String cnh;
    private String placaAutomovel;

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getPlacaAutomovel() {
        return placaAutomovel;
    }

    public void setPlacaAutomovel(String placaAutomovel) {
        this.placaAutomovel = placaAutomovel;
    }

    public String toString() {
        return "\nCNH      : " + cnh
             + "\nPlaca    : " + placaAutomovel;
    }
}
