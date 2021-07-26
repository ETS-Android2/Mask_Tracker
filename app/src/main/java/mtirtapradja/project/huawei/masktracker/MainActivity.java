package mtirtapradja.project.huawei.masktracker;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

import mtirtapradja.project.huawei.masktracker.Fragments.ExploreFragment;
import mtirtapradja.project.huawei.masktracker.Fragments.HistoryFragment;
import mtirtapradja.project.huawei.masktracker.Fragments.HomeFragment;
import mtirtapradja.project.huawei.masktracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragment = new HomeFragment();
        loadFrame(fragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_bottom_nav:
                fragment = new HomeFragment();
                loadFrame(fragment);
                return true;
            case R.id.explore_bottom_nav:
                fragment = new ExploreFragment();
                loadFrame(fragment);
                return true;
            case R.id.history_bottom_nav:
                fragment = new HistoryFragment();
                loadFrame(fragment);
                return true;
        }
        return false;
    }

    private void loadFrame(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}