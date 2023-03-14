
public class Classe_Q <T> {
    T _variable;

    public Classe_Q(T variable) {
        this._variable = variable;
    }

    public <V> void SetQ (V aa){
        this._variable = (T) aa;
    }

}
