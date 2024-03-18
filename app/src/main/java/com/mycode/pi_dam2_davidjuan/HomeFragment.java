package com.mycode.pi_dam2_davidjuan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static ArrayList<ItemLista> lista;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getDatos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDatos();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Usar un administrador de diseño lineal
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Especificar un adaptador
        MiAdaptador adaptador = new MiAdaptador(lista);
        recyclerView.setAdapter(adaptador);

        // Configurar el manejador de clics si es necesario
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = recyclerView.getChildAdapterPosition(v);
                Toast.makeText(getContext(), "Seleccionado elemento en posición: " + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void getDatos() {
        lista = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        FirebaseStorage storage = FirebaseStorage.getInstance();

        // Lee los datos de tu base de datos
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String nombreCuenta = postSnapshot.child("nombreCuenta").getValue(String.class);
                    String pieDeFoto = postSnapshot.child("pieDeFoto").getValue(String.class);
                    String pieDeFotoC = nombreCuenta + ": " + pieDeFoto;
                    String rutaRelativaFoto = postSnapshot.child("rutaRelativaFoto").getValue(String.class);

                    // Cargar imagen
                    StorageReference storageRef = storage.getReference();
                    StorageReference pathReference = storageRef.child("accesodatosdam.appspot.com/c1.jpg");
                    String url = pathReference.getDownloadUrl().toString();

                    lista.add(new ItemLista(url, nombreCuenta, pieDeFotoC));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // No se pudo leer el valor
                System.out.println("Failed to read value." + error.toException());
            }
        });
    }


    public ArrayList<ItemLista> getLista() {
        return lista;
    }
}