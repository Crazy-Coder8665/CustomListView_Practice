package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.example.listviewpractice.ListAdapter;

import com.example.listviewpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
        String[] name = {"Hamza","Ali","Talha","Abdullah","Rizwan","Tahir","Masood"};
        String[] lastmessage = {"Life is Okay","Be a man of Deeds","Train like Beast","Happy","Broken","Poetic","Enjoying"};
        String[] time = {"10: 30 pm","01: 05 am","12: 40 am","06:10 pm","05:30 pm","09:16 am","11:00 pm"};
        String[] phoneno = {"123456788","9876654332","8743683764","3847638734","3473874348","837438487","93847384"};
        String[] country = {"Pakistan","Bangladesh","Iran","Afghanistan","Iraq","China","Oman"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0 ; i< imageId.length;i++){
            User user = new User(name[i],lastmessage[i],time[i],phoneno[i],country[i],imageId[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,user_activity.class);
                intent.putExtra("name",name[i]);
                intent.putExtra("phone",phoneno[i]);
                intent.putExtra("country",country[i]);
                intent.putExtra("imageid",imageId[i]);
                startActivity(intent);
            }

        });

    }
}