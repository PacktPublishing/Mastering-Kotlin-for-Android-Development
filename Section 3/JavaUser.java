package classes;

@SuppressWarnings("ALL")
public class JavaUser {

    private final String name;

    private final String country;

    public JavaUser(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 27 + name.hashCode();
        hash = hash * 27 + country.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JavaUser) {
            JavaUser other = (JavaUser) obj;
            return this.country.equals(other.country) && this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " name: " + this.name + " country: " + this.country;
    }
}
