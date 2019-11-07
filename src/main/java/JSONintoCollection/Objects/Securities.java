package JSONintoCollection.Objects;


/**
 * Created by yasup on 06.11.2019.
 */

public class Securities {

    private int id;
    private String code;
    private String name_full;
    private String cfi;
    private String date_to;
    private String state_reg_date;
    public State state;
    public Currency currency;

    @Override
    public String toString() {
        return "Securities{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + name_full + '\'' +
                ", cfi='" + cfi + '\'' +
                ", date_to='" + date_to + '\'' +
                ", state_reg_date='" + state_reg_date + '\'' +
                ", state=" + state +
                ", currency=" + currency +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName_full() {
        return name_full;
    }

    public void setName_full(String name_full) {
        this.name_full = name_full;
    }

    public String getCfi() {
        return cfi;
    }

    public void setCfi(String cfi) {
        this.cfi = cfi;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public String getState_reg_date() {
        return state_reg_date;
    }

    public void setState_reg_date(String state_reg_date) {
        this.state_reg_date = state_reg_date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
