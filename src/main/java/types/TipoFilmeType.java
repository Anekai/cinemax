
package types;

public enum TipoFilmeType {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String value;

    private TipoFilmeType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}
