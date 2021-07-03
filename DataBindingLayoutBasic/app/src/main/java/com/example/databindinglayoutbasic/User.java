package com.example.databindinglayoutbasic;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
public class User extends BaseObservable {
    String strName;
    public User(String strName) {
        this.strName = strName;
    }
@Bindable
    public String getStrName() {
        return strName;
    }
   @Bindable
    public void setStrName(String strName) {
        this.strName = strName;
        notifyPropertyChanged(BR.strName);
    }
}
