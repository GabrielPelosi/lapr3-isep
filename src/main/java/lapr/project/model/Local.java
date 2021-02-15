package lapr.project.model;

/**
 * The type Local.
 */
public class Local {

    private final String local;

    /**
     * Instantiates a new Local.
     *
     * @param local      the local
     * @param outroLocal the outro local
     */
    public Local(String local, String outroLocal) {
        this.local = local;
    }

    /**
     * Instantiates a new Local.
     *
     * @param local the local
     */
    public Local(String local) {
        this.local = local;
    }

    /**
     * Instantiates a new Local.
     *
     * @param local the local
     */
    public Local(Local local) {
        this.local = local.getLocal();
    }

    public Local(){
        local = "LOCAL_POR_OMISSAO";
    }


    /**
     * Gets local.
     *
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    @Override
    public String toString() {
        return "Local{" +
                "local='" + local + '\'' +
                '}';
    }
}
