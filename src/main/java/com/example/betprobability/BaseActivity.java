package com.example.betprobability;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public MenuItem mWelcome;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu.size() == 0) {
            getMenuInflater().inflate(R.menu.activity_main, menu);
            mWelcome = menu.findItem(R.id.testlog);
            return true;

        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
}
