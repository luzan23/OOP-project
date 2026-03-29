package assignment1;
import java.util.ArrayList;
import java.util.Collection;

public class Polynomial {

    private Collection<Monomial> polynomial;

    public Polynomial(){
        this.polynomial= new ArrayList<>();
    }

    public Polynomial add(Polynomial p){
        return null;
    }

    public Polynomial mul(Polynomial p){
        return null;
    }

    public Scalar evaluate(Scalar s){
        return null;
    }

    public  Monomial derivative(){
        return null;
    }

    public int sign(){
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
