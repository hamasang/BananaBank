package com.example.bananabank.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bananabank.model.BankInfoModel;

/**
 * 메인화면 viewModel
 */
public class MainViewModel extends ViewModel {

    final private MutableLiveData<BankInfoModel> bankInfoModelData = new MutableLiveData<>();

    public void setBankInfoModel(BankInfoModel bankInfoModel) {
        bankInfoModelData.setValue(bankInfoModel);
    }

    public LiveData<BankInfoModel> getBankInfoModelData() {
        return bankInfoModelData;
    }
}
