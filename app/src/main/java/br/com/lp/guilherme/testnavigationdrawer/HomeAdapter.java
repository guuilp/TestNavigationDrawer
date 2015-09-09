package br.com.lp.guilherme.testnavigationdrawer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Guilherme on 06-Sep-15.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private final List<Home> homes;
    private final Context context;
    private CarroOnClickListener carroOnClickListener;

    public HomeAdapter(Context context, List<Home> homes, CarroOnClickListener carroOnClickListener) {
        this.homes = homes;
        this.context = context;
        this.carroOnClickListener = carroOnClickListener;
    }

    @Override
    public int getItemCount() {
        return this.homes != null ? this.homes.size() : 0;
    }

    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_home, viewGroup, false);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder homeViewHolder, final int position) {
        Home c = homes.get(position);
        homeViewHolder.tNome.setText(c.nome);
        homeViewHolder.tNota.setText(c.nota);
    }

    public interface CarroOnClickListener{
        public void onClickCarro(View view, int idx);
    }

    //ViewHolder com as views
    public static class HomeViewHolder extends RecyclerView.ViewHolder{
        public TextView tNome;
        public TextView tNota;
        CardView cardView;

        public HomeViewHolder(View view) {
            super(view);
            //Cria as views para salvar no ViewHolder
            tNome = (TextView) view.findViewById(R.id.text);
            tNota = (TextView) view.findViewById(R.id.nota);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }
}