package POO.endereco;

public class Documento {
    private String tipoDocumento;
    private String numero;
    private String orgaoExpedidor;

    public Documento(String tipoDocumento, String numero, String orgaoExpedidor) {
        this.tipoDocumento = tipoDocumento;
        this.numero = numero;
        this.orgaoExpedidor = orgaoExpedidor;
    }

    @Override
    public String toString() {
        return "Documento " +
                "\ntipoDocumento: " + tipoDocumento +
                "\nnumero: " + numero +
                "\norgaoExpedidor: " + orgaoExpedidor;
    }
}
