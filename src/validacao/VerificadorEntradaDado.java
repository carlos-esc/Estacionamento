package validacao;

public class VerificadorEntradaDado {

    private final String placa = "[A-Z]{3}[0-9]{4}";
    private final String prisma = "[0-9]{2,4}";
    String dadoRetornoTipo;
    
    public String verificaDadoTipo(String dadoEntrada) {
        
        if (dadoEntrada.matches(placa)){
            dadoRetornoTipo = "placa";
        } else if (dadoEntrada.matches(prisma)) {
            dadoRetornoTipo = "prisma";
        } else {
            dadoRetornoTipo = "invalido";
        }
        return dadoRetornoTipo;
    }  
}
