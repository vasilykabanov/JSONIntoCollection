package JSONintoCollection.Objects;

/**
 * Created by yasup on 06.11.2019.
 */
public class State extends Securities {

    public int id;
    public String name;

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
