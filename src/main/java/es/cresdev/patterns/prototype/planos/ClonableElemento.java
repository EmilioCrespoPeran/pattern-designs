package es.cresdev.patterns.prototype.planos;

public interface ClonableElemento<T> extends Cloneable {
    T clonar() throws CloneNotSupportedException;
    boolean esValido();
}
