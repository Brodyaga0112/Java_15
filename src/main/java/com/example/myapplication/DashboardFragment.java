package com.example.myapplication;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardFragment extends Fragment {

    private TextView textView;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        textView = rootView.findViewById(R.id.text_dashboard);

        // Register the TextView for context menu
        registerForContextMenu(textView);

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(requireContext(), view);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.action_increment) {
                    counter++;
                    textView.setText("Кол-во: " + counter);
                    return true;
                }
                return false;
            });
            popup.show();
        });
        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.action_change_text_1) {
            textView.setText("TXL");
            return true;
        } else if (item.getItemId() == R.id.action_change_text_2) {
            textView.setText("VX");
            return true;
        } else if (item.getItemId() == R.id.action_change_text_3) {
            textView.setText("RX");
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}
