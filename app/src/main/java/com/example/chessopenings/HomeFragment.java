package com.example.chessopenings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private RecyclerView contactsRecView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HoneFragment.
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hone, container, false);



        contactsRecView=rootView.findViewById(R.id.ContactsRecyleView);
        ArrayList<Contacts> contacts=new ArrayList<>();
        String[] variations={"Open Sicilian","Closed Sicilian","Alapin Variation","Smith-Morra Gambit","Grand Prix Attack","Closed Sicilian with g3"};
        String[] variations2={"Morphy Defense","Closed Ruy Lopez","Berlin Defense","Schliemann Defense","Bird Variation","Classical Variation","Steinitz Defense"};
        String[] variations3={"Gioco Piano","Two Knights Defense","Evans Gambit","Giuoco Pianissimo","Scotch Gambit","Center Game"};
        String[] variations4={"Accepted Variation","Declined Variation","Falkbeer Countergambit","Classical Variation","Modern Defense","King's Knight's Gambit"};
        String[] variations5={"Advance Variation","Classical Variation","Panov-Botvinnik Attack","Exchange Variation","Tartakower (or Fantasy) Variation","Two Knights Variation"};
        String[] imagename1={"img_1"};
        String[] imagename2={"img_2"};
        String[] imagename3={"img_3"};
        String[] imagename4={"img_4"};
        String[] imagename5={"img_5"};

        contacts.add(new Contacts("Sicilian defence","e4 c5","The moves 1. e4 c5 constitute the Sicilian Defence, a counter-attacking opening in which players typically attack on opposite sides of the board.\n\nBlack's move 1...c5 seeks to create a half-open file, controls the important d4 square, and allows the black queen to venture out if desired, while the c-pawn itself is safe from attack, unlike the e-pawn after 1. e4 e5.",variations,1,"img_1"));
        contacts.add(new Contacts("Ruy Lopez","e4 e5, Nf3 Nc6, Bb5","The essential move marking the Spanish Game, or Ruy Lopez. \"It is the double king's pawn opening most commonly used in master play; it has been adopted by almost all players at some point in their careers and many play it from both the White and Black sides.\"",variations2,2,"img_2"));
        contacts.add(new Contacts("Italian Opening","e4 e5, Nf3 Nc6, Bc4","The Italian Game is very popular and one of the oldest openings in chess. White develops the bishop to a good square where it controls the centre and targets f7. This opening is very easy to study and one of the best choices for beginners.",variations3,3,"img_3"));
        contacts.add(new Contacts("King Gambit","e4 e5,Nf3 f5","White attacks Black's pawn on e5 with their f-pawn, but the pawn on f4 is attacked and undefended. A gambit is an opening that involves a sacrifice of material (chess pieces, usually pawns) for positional gain. In the case of the King's Gambit, White seeks to tempt Black's pawn away from the centre onto f4, which would give White the freedom to play d4 and e5. The move d4 will not only gain centre space but will also uncover an attack by the c1-bishop on Black's f4-pawn, and Black will have to make further non-developing moves to retain the pawn on f4.",variations4,4,"img_4"));
        contacts.add(new Contacts("Caro Kann","e4 c6","The Caro-Kann is considered solid and safe with a better pawn structure (often leading to good endgames). However, White has many possible responses and may develop faster than Black. Out of the Semi-Open games, the opening is thought to be less dynamic than the Sicilian and the French.\n\nIn choosing the Caro-Kann, Black gives up the centre in exchange for easier development. Black often aims to let White's pawns overextend, or develop a poor structure, and take advantage in the endgame.",variations5,5,"img_5"));

        ContactRecViewAdapter adapter=new ContactRecViewAdapter(getActivity());
        adapter.setContacts(contacts);
        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
}