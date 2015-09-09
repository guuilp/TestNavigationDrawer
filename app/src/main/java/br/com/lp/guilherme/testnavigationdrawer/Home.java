package br.com.lp.guilherme.testnavigationdrawer;

import java.io.Serializable;

/**
 * Created by Guilherme on 06-Sep-15.
 */
public class Home implements Serializable {
    private static final long serialVersionUID = 6601006766832473959L;

    public long id;
    public String tipo;
    public String nome;
    public String nota;
    public String urlFoto;
    public String urlInfo;
    public String urlVideo;
    public String latitude;
    public String longitude;

    @Override
    public String toString() {
        return "Home{" + "nome='" + nome + '\'' + '}';
    }
}
