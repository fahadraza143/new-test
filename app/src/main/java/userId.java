public class userId {
    String fn;
    String ln;
    String cn;
    String em;
    String pass;
    public userId(){

    }

    public userId(String fn, String ln, String cn, String em, String pass) {
        this.fn = fn;
        this.ln = ln;
        this.cn = cn;
        this.em = em;
        this.pass = pass;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
