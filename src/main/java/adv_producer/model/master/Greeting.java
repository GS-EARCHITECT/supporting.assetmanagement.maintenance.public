package adv_producer.model.master;

import java.io.Serializable;

public class Greeting implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -983151269779663188L;
	private String msg;
    private String name;

    public Greeting() {   }

    public Greeting(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return msg + ", " + name + "!";
    }
    
}
