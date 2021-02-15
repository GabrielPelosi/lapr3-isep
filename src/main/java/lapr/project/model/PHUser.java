package lapr.project.model;

import lapr.project.data.PHUserDB;

import java.util.Objects;

/**
 * The type Ph user.
 */
public class PHUser {

    private long id;
    private long idRole;
    private Address add;
    private String userName;
    private String passwd;
    private String email;

    /**
     * Instantiates a new Ph user.
     *
     * @param id       the id
     * @param idRole   the id role
     * @param add      the add
     * @param userName the user name
     * @param passwd   the passwd
     * @param email    the email
     */
    public PHUser(long id, long idRole, Address add, String userName, String passwd, String email) {

        this.id = id;
        this.idRole = idRole;
        this.add = add;
        this.userName = userName;
        this.passwd = passwd;
        this.email = email;
    }

    /**
     * Instantiates a new Ph user.
     *
     * @param id       the id
     * @param idRole   the id role
     * @param userName the user name
     * @param passwd   the passwd
     * @param email    the email
     */
    public PHUser(long id, long idRole, String userName, String passwd, String email) {

        this.id = id;
        this.idRole = idRole;
        this.userName = userName;
        this.passwd = passwd;
        this.email = email;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets id add.
     *
     * @return the id add
     */
    public Address getIdAdd() {
        return add;
    }

    /**
     * Gets id role.
     *
     * @return the id role
     */
    public long getIdRole() {
        return idRole;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets passwd.
     *
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets passwd.
     *
     * @param passwd the passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Sets id add.
     *
     * @param add the add
     */
    public void setIdAdd(Address add) {
        this.add = add;
    }




}
