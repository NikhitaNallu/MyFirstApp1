package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentFirstBinding;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView showCountTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //View fragmentFirsLayout = inflater.inflate(R.layout.fragment_first, container, false);
        //get the count text view
        //showCountTextView = fragmentFirsLayout.findViewById(R.id.textview_first);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View fragmentFirstLayout = binding.getRoot();
        showCountTextView = binding.textviewFirst;

        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        }
        ); */
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countMe(view);
            }
        });
    }
    private void countMe(View view){
        //Get the value of the text view
        String countString = showCountTextView.getText().toString();
        //Convert value to a number and increment in
        Integer count = Integer.parseInt(countString);
        count++;
        showCountTextView.setText(count.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}