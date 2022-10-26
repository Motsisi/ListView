package com.cet.listview;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<User> users;
    ReclyclerAdapter adapter;
    RecyclerView.ItemDecoration itemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        recyclerView = findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.canScrollHorizontally();

        adapter = new ReclyclerAdapter(users);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setClickListener(this);

        itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        

    }

    private void initData() {
        users = new ArrayList<>();
        users.add(new User(R.drawable.bezos, "Jeff Bezos", "22:54", "Le nkitse lotlhe mos"));
        users.add(new User(R.drawable.cook, "Tim Cook", "01:45", "Im the CEO of tech Giant Apple"));
        users.add(new User(R.drawable.pichai, "Sundar Pichai", "22:54", "Google and Alphabet CEO"));
        users.add(new User(R.drawable.zuck, "Mark Zuckerberg", "11:32", "Pardon my arrogance"));
        users.add(new User(R.drawable.elon, "Elon Musk", "22:54", "😆 Man on a mission"));
        users.add(new User(R.drawable.safra, "Safra Catz", "12.19", "The highest paid female CEO"));
        users.add(new User(R.drawable.christian, "Christian Klein", "23:22", "Chief Executive Officer at SAP SE"));
        users.add(new User(R.drawable.daniel, "Daniel Ek", "22:54", "Spotify's 30 under 30 CEO"));
        users.add(new User(R.drawable.satya, "Satya Nadella", "22:19", "The new Bill Gates"));
        users.add(new User(R.drawable.reed, "Reed Hastings", "19:37", "Sharing password is caring"));
        users.add(new User(R.drawable.andy, "Andy Jessy", "19:37", "There is no compression algorithm for experience"));
        users.add(new User(R.drawable.aliko, "Aliko Dangote", "19:37", "Dangote is the founder and current chairman and CEO of the Dangote Group"));
        users.add(new User(R.drawable.bezos, "Daniel Zhang", "19:37", "Alibaba Group CEO"));

    }

    @Override
    public void onClick(View view, int position) {
        final User user = users.get(position);
        Toast.makeText(this.getApplicationContext(), user.getName(), Toast.LENGTH_SHORT).show();
    }
}