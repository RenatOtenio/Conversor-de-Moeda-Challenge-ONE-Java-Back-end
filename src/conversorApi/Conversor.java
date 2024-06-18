package conversorApi;

public class Conversor {
    private String base_code;
    private String target_code;
    private  double conversion_result;
    private double conversion_rate;
    private double valor;

    public Conversor(String base_code, String target_code, double valor){
        this.base_code = base_code;
        this.target_code = target_code;
        this.valor = valor;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Conversor{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_result=" + conversion_result +
                ", conversion_rate=" + conversion_rate +
                '}';
    }
}