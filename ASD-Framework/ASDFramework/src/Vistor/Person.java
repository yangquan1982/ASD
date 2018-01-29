package ASDFramework.src.Vistor;

public abstract class Person {

    private Integer id; // ���
    private String userName; // �û���
    private String password; // ����
    private String trueName; // ��ʵ����

    public Person(String userName, String password, String trueName) {
//        this.id = id;
        this.userName = userName;
        this.password = password;
        this.trueName = trueName;
    }

    public Person(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public abstract void add(Person p);
    public abstract void remove(Person p);
}
