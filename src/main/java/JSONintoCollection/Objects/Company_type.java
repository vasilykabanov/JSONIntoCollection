package JSONintoCollection.Objects;

/**
 * Created by yasup on 06.11.2019.
 */
public class Company_type {

    private int id;
    private String name_short;
    private String name_full;

    @Override
    public String toString() {
        return "Company_type{" +
                "id=" + id +
                ", name_short='" + name_short + '\'' +
                ", name_full='" + name_full + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_short() {
        return name_short;
    }

    public void setName_short(String name_short) {
        this.name_short = name_short;
    }

    public String getName_full() {
        return name_full;
    }

    public void setName_full(String name_full) {
        this.name_full = name_full;
    }
}
