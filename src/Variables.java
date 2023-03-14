/**
 * Variables
 */
public class Variables<T> {
    T _variable;

    public Variables(T variable) {
        this._variable = variable;
    }

    public <V> void SetQ (V aa){
        this._variable = (T) aa;
    }

}