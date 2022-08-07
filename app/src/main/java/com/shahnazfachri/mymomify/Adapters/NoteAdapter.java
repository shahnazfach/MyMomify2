package com.shahnazfachri.mymomify.Adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shahnazfachri.mymomify.Models.NoteModel;
import com.shahnazfachri.mymomify.R;
import com.shahnazfachri.mymomify.addnote;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private Context context;
    private List<NoteModel> notes;

    public NoteAdapter(Context context) {
        this.context = context;
        this.notes = new ArrayList<>();
    }

    public void setNotes(List<NoteModel> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_itemnote, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final NoteModel noteModel = notes.get(i);

        viewHolder.tvTitle.setText(noteModel.getNoteTitle());
        viewHolder.tvContent.setText(noteModel.getNoteContent());
        viewHolder.tvDate.setText(noteModel.getNoteDate());
        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, addnote.class);
                intent.putExtra("isEdit", true);
                intent.putExtra("noteID", noteModel.getNoteID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvTitle, tvContent, tvDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}

