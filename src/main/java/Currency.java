public class Currency {
    public String code;
    public Rates[] rates;

    @Override
    public String toString() {
       return code + " " + rates[0].mid + ", 100PLN -> " + (100.0 * rates[0].ask);
    }
}
