
package types;

public enum PoltronaType {
    
    A1("A1"),A2("A2"),A3("A3"),A4("A4"),A5("A5"),A6("A6"),A7("A7"),A8("A8"),A9("A9"),A10("A10"),
    B1("B1"),B2("B2"),B3("B3"),B4("B4"),B5("B5"),B6("B6"),B7("B7"),B8("B8"),B9("B9"),B10("B10"),
    C1("C1"),C2("C2"),C3("C3"),C4("C4"),C5("C5"),C6("C6"),C7("C7"),C8("C8"),C9("C9"),C10("C10"),
    D1("D1"),D2("D2"),D3("D3"),D4("D4"),D5("D5"),D6("D6"),D7("D7"),D8("D8"),D9("D9"),D10("D10"),
    E1("E1"),E2("E2"),E3("E3"),E4("E4"),E5("E5"),E6("E6"),E7("E7"),E8("E8"),E9("E9"),E10("E10"),
    F1("F1"),F2("F2"),F3("F3"),F4("F4"),F5("F5"),F6("F6"),F7("F7"),F8("F8"),F9("F9"),F10("F10"),
    G1("G1"),G2("G2"),G3("G3"),G4("G4"),G5("G5"),G6("G6"),G7("G7"),G8("G8"),G9("G9"),G10("G10"),
    H1("H1"),H2("H2"),H3("H3"),H4("H4"),H5("H5"),H6("H6"),H7("H7"),H8("H8"),H9("H9"),H10("H10"),
    I1("I1"),I2("I2"),I3("I3"),I4("I4"),I5("I5"),I6("I6"),I7("I7"),I8("I8"),I9("I9"),I10("I10"),
    J1("J1"),J2("J2"),J3("J3"),J4("J4"),J5("J5"),J6("J6"),J7("J7"),J8("J8"),J9("J9"),J10("J10");

    private String value;

    private PoltronaType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}