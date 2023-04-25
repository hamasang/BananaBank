package com.example.bananabank.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.bananabank.R;
import com.example.bananabank.ui.MainViewModel;

public class HomeFragment extends Fragment {

    private final String TAG = "HomeFragment";

    private HomeViewModel homeViewModel;
    private MainViewModel mainViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        if (getActivity() != null) {
            mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        }
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initObserve();
        return root;
    }

    private void initObserve() {

        if (mainViewModel == null) {
            Log.d(TAG, "mainViewModel == null ");
            return;
        }

        mainViewModel.getBankInfoModelData().observe(getViewLifecycleOwner(), bankInfoModel -> {
            // view set
            TextView tvHomeBank = (TextView) getView().findViewById(R.id.bank);
            TextView tvSafeBank = (TextView) getView().findViewById(R.id.safe);
            tvHomeBank.setText(bankInfoModel.getHomeBank());
            tvSafeBank.setText(bankInfoModel.getSafeBank());
        });
    }
}