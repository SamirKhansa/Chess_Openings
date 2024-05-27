package com.example.chessopenings;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ContactRecViewAdapter extends RecyclerView.Adapter<ContactRecViewAdapter.ViewHolder>{
    private ArrayList<Contacts> contacts=new ArrayList<>();
    private Context context;

    private FragmentManager fragmentManager;
    public ContactRecViewAdapter(Context contect){

        this.context=contect;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_items,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtPosition.setText(contacts.get(position).getPosition());
        int k = position + 1;


        int imageResource = context.getResources().getIdentifier(contacts.get(position).getImageName(), "drawable", context.getPackageName());
        holder.image.setImageResource(imageResource);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                Toast.makeText(context, contacts.get(adapterPosition).getName() + " Selected", Toast.LENGTH_SHORT).show();

                if (contacts.get(adapterPosition).getPosition1() <= 5) {
                    Intent intent = new Intent(context, OpeningsActivity.class);
                    intent.putExtra("name", contacts.get(adapterPosition).getName());
                    intent.putExtra("Position", contacts.get(adapterPosition).getPosition());
                    intent.putExtra("Description", contacts.get(adapterPosition).getDescription());
                    intent.putExtra("Variations", contacts.get(adapterPosition).getVariations());
                    intent.putExtra("ID", contacts.get(adapterPosition).getPosition1());
                    context.startActivity(intent);
                } else {
                    VariationsFragment fragment = new VariationsFragment();

                    String Headder = contacts.get(position).getName();
                    String Desc=contacts.get(position).getDescription();
                    String ImgName=contacts.get(position).getImageName();
                    Bundle bundle = new Bundle();
                    bundle.putString("Headder", Headder);
                    bundle.putString("Desc", Desc);
                    bundle.putString("ImgName", ImgName);


                    fragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();





                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName,txtPosition;
        private ImageView image;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtPosition=itemView.findViewById(R.id.txtPosition);
            image=itemView.findViewById(R.id.image11);
            parent=itemView.findViewById(R.id.parent);


        }
    }
    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }


}


