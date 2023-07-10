package dominio;

import com.google.gson.annotations.SerializedName;

public class Moeda {
    private String coden;
    private String codein;
    private String name;
    private String bid;
    @SerializedName("create_date")
    private String createDate;

    public String getCoden() {
        return coden;
    }

    public void setCoden(String coden) {
        this.coden = coden;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
