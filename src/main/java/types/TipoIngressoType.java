
package types;

public enum TipoIngressoType {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String value;

    private TipoIngressoType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}
