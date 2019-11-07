package JSONintoCollection.Objects;

import java.util.List;


/**
 * Created by yasup on 06.11.2019.
 */
public class Company {

    private int id;
    private String code;
    private String name_full;
    private String name_short;
    private String inn;
    private Company_type company_type;
    private String ogrn;
    private String egrul_date;
    private Country country;
    private String fio_head;
    private String address;
    private String phone;
    private String e_mail;
    private String www;
    private boolean is_resident;
    public List<Securities> securities;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + name_full + '\'' +
                ", name_short='" + name_short + '\'' +
                ", inn='" + inn + '\'' +
                ", company_type=" + company_type +
                ", ogrn='" + ogrn + '\'' +
                ", egrul_date='" + egrul_date + '\'' +
                ", country=" + country +
                ", fio_head='" + fio_head + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", www='" + www + '\'' +
                ", is_resident=" + is_resident +
                ", securities=" + securities +
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

    public String getName_short() {
        return name_short;
    }

    public void setName_short(String name_short) {
        this.name_short = name_short;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Company_type getCompany_type() {
        return company_type;
    }

    public void setCompany_type(Company_type company_type) {
        this.company_type = company_type;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getEgrul_date() {
        return egrul_date;
    }

    public void setEgrul_date(String egrul_date) {
        this.egrul_date = egrul_date;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFio_head() {
        return fio_head;
    }

    public void setFio_head(String fio_head) {
        this.fio_head = fio_head;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public boolean isIs_resident() {
        return is_resident;
    }

    public void setIs_resident(boolean is_resident) {
        this.is_resident = is_resident;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }
}
