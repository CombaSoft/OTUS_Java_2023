package homework;

public class Customer implements Comparable<Customer>, Cloneable {
    private final long id;
    private String name;
    private long scores;

    //todo: 1. в этом классе надо исправить ошибки

    public Customer(long id, String name, long scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id == customer.getId();
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public int compareTo(Customer o) {
        return o == null ? 1 : Long.compare(this.scores, o.scores);
    }

    @Override
    public Customer clone() {
        // Завернул здесь в try..catch, чтобы избежать этого в местах вызова метода
        // Т.к. "глубокая" копия объекта не требуется, использую Object.clone()
        // Можно было просто создать объект через new Customer(...)
        try {
            return (Customer) super.clone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}