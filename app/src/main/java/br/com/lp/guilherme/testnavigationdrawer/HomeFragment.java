package br.com.lp.guilherme.testnavigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Guilherme on 07-Sep-15.
 */
public class HomeFragment extends Fragment {
    protected RecyclerView recyclerView;
    private List<Home> homes;
    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        taskCarros();
    }

    private void taskCarros() {
        //Busca os carros
        this.homes = HomeService.getCarros(getContext());
        //Atualiza a lista
        recyclerView.setAdapter(new HomeAdapter(getContext(), homes, onClickCarro()));
    }

    private HomeAdapter.CarroOnClickListener onClickCarro() {
        return new HomeAdapter.CarroOnClickListener() {
            @Override
            public void onClickCarro(View view, int idx) {
                Home c = homes.get(idx);
                Toast.makeText(getContext(), "Home: " + c.nome, Toast.LENGTH_LONG).show();
            }
        };
    }
}
