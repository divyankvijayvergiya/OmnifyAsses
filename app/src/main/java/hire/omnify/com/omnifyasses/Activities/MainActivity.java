package hire.omnify.com.omnifyasses.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import hire.omnify.com.omnifyasses.Fragments.RandomNumberFragment;
import hire.omnify.com.omnifyasses.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        RandomNumberFragment numberFragment = new RandomNumberFragment();
        fragmentManager.beginTransaction()
                .add(R.id.random_fragment, numberFragment)
                .commit();
    }


}
