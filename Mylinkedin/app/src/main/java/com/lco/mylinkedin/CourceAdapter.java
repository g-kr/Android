package com.lco.mylinkedin;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CourceAdapter extends RecyclerView.Adapter<CourceAdapter.CourceViewHolder>{
    private String[] data;
    private int[] images;

    public CourceAdapter(String data[],int images[]){
        this.images=images;
        this.data=data;
    }

    @NonNull
    @Override
    public CourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());//assign krr rha item files
        View view=inflater.inflate(R.layout.item,parent,false);

        return new CourceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourceViewHolder holder, int position) {
        String title=data[position];
        holder.t1.setText(title);
//       int imageid=images[position];
//       holder.img.setImageResource(imageid);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CourceViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView t1;
        public CourceViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.profile_image);
            t1=itemView.findViewById(R.id.txt1);



        }
    }

}
