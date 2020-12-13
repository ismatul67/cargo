import java.util.List;

public class Cargo {
    private String id = "CG64";
    private Integer volume;
    private HazzardType hazzard;
    private String content;
    private String hazzardous;

    public Cargo(String id, Integer volume, HazzardType hazzard, String content, String hazzardous) {
        this.id = this.id + id;
        this.volume = volume;
        this.hazzard = hazzard;
        this.content = content;
        this.hazzardous = hazzardous;
    }

    public Cargo() {

    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getVolume() {
        return volume;
    }

    public String getHazzardous() {
        return hazzardous;
    }

    public HazzardType getHazzard() {
        return hazzard;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void shipCargo(String id) {
        if (this.id.equals(id)) {
            System.out.println("Cargo is been shipped!");
        } else {
            System.out.println("Id not found!");
        }
    }
}
