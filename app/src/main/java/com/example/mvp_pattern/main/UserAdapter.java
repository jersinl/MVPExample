package com.example.mvp_pattern.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.mvp_pattern.R;
import com.example.mvp_pattern.main.model.UserListDTO;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MainViewHolder>  {

    private ArrayList<UserListDTO> users;
    private Context context;
    private Listener listener;

    UserAdapter (ArrayList<UserListDTO> users, Context context , Listener listener)
    {
        this.users = users;
        this.context = context;
        this.listener = listener;

    }


    interface  Listener
    {
        void onClickItem(UserListDTO user);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_user, parent, false);
        return new MainViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
         final TextView txtUserId = holder.itemView.findViewById(R.id.txtUserId);
        final TextView txtUserName = holder.itemView.findViewById(R.id.txtUserName);
        final TextView txtEmail = holder.itemView.findViewById(R.id.txtEmail);
        final TextView txtAdmin = holder.itemView.findViewById(R.id.txtAdmin);
        final Button btnOk = holder.itemView.findViewById(R.id.btnOk);

        txtUserId.setText(Integer.toString(users.get(position).getUserId()));
        txtUserName.setText(users.get(position).getUserName());
        txtEmail.setText(users.get(position).getEmail());
        txtAdmin.setText(users.get(position).isAdmin()? context.getResources().getString(R.string.textview_text_admin)
                        :context.getResources().getString(R.string.textview_text_noadmin));

        btnOk.setOnClickListener(view -> listener.onClickItem(users.get(position)));

    }


    @Override
    public int getItemCount() {
        return  users!=null ?  users.size() : 0;
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        MainViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }}
