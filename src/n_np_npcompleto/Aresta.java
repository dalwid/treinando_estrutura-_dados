package n_np_npcompleto;

import java.util.Objects;

public class Aresta {
    private int u;
    private int v;

    public Aresta(int u, int v) {
        // Garantimos que a ordem dos vértices não importa para a igualdade
        this.u = Math.min(u, v);
        this.v = Math.max(u, v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aresta aresta = (Aresta) o;

        return u == aresta.u && v == aresta.v;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    @Override
    public int hashCode() { return Objects.hash(u, v); }

    @Override
    public String toString() { return "(" + u + ", " + v + ")"; }
}
