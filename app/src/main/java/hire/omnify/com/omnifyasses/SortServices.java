package hire.omnify.com.omnifyasses;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import hire.omnify.com.omnifyasses.Adapters.QuickSortAdapter;

/**
 * Created by Dell on 22-01-2018.
 */

public class SortServices extends Service {
    RecyclerView quick, merge;
    ArrayList<Integer> arrayList = new ArrayList<>();
    QuickSortAdapter quickSortAdapter;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        quickSortFun();

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    public void quickSortFun() {
        arrayList = new ArrayList<>();


        for (int i = 0; i < 20; ) {
            Random random = new Random();
            int min = 10;
            int max = 98;
            int rand = random.nextInt((max - min) + 1) + min;
            if (!arrayList.contains(rand)) {
                arrayList.add(rand);
                i++;
                quickSort(arrayList);
            }
        }





    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {

        if (array.size() <= 1) {
            return array;
        }

        int middle = (int) Math.ceil((double) array.size() / 2);
        int pivot = array.get(middle);

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) <= pivot) {
                if (i == middle) {
                    continue;
                }
                less.add(array.get(i));
            } else {
                greater.add(array.get(i));
            }
        }

        return concatenate(quickSort(less), pivot, quickSort(greater), array);
    }

    private static ArrayList<Integer> concatenate(ArrayList<Integer> less, int pivot, ArrayList<Integer> greater, ArrayList<Integer> list) {

        list.clear();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }

        return list;
    }


}
