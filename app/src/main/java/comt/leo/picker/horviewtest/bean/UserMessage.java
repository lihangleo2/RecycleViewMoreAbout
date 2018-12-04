package comt.leo.picker.horviewtest.bean;

import java.io.Serializable;

/**
 * Created by leo
 * on 2018/12/3.
 */
public class UserMessage implements Serializable {
    private String id;
    private String name;

    public UserMessage(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
