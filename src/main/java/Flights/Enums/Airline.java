package Flights.Enums;

public enum Airline {
    AAL("AMERICAN AIRLINES"),
    COA("CONTINENTAL AIRLINES"),
    NWA("NORTHWEST AIRLINES"),
    ACA("AIR CANADA"),
    DLH("LUFTHANSA CARGO"),
    FDX("FEDEX"),
    AFR("AIR FRANCE"),
    MSR("EGYPTAIR"),
    PAL("PHILIPPINE AIRLINES"),
    QFA("QANTAS AIRWAYS"),
    ANZ("AIR NEW ZEALAND"),
    FIN("FINNAIR O/Y"),
    BAW("BRITISH AIRWAYS"),
    JAL("JAPAN AIRLINES"),
    VIR("VIRGIN ATLANTIC");

    public final String label;

    private Airline(String label) {
        this.label = label;
    }
}