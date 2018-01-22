package hire.omnify.com.omnifyasses.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import hire.omnify.com.omnifyasses.Fragments.SortingFragment;
import hire.omnify.com.omnifyasses.R;

/**
 * Created by Dell on 20-01-2018.
 */

public class SortingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting);
        FragmentManager fragmentManager = getSupportFragmentManager();
        SortingFragment sortingFragment = new SortingFragment();
        fragmentManager.beginTransaction()
                .add(R.id.sorting_fragment, sortingFragment)
                .commit();
    }
}
