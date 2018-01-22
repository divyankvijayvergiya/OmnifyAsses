package hire.omnify.com.omnifyasses.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

import hire.omnify.com.omnifyasses.Adapters.MergeSortAdapter;
import hire.omnify.com.omnifyasses.Adapters.QuickSortAdapter;
import hire.omnify.com.omnifyasses.R;

/**
 * Created by Dell on 20-01-2018.
 */

public class SortingFragment extends Fragment {
    RecyclerView quick, merge;
    MergeSortAdapter mergeSortAdapter;
    ArrayList<Integer> arrayList;
    QuickSortAdapter quickSortAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sorting, container, false);
        quick = view.findViewById(R.id.recycler_view_quick);
        merge = view.findViewById(R.id.recycler_view_merge);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        quick.setLayoutManager(layoutManager);
        merge.setLayoutManager(layoutManager1);
        mergeSortFun(view);
        quickSortFun(view);

        return view;
    }

    public void mergeSortFun(View v) {
        arrayList = new ArrayList<>();


        for (int i = 0; i < 20; ) {
            Random random = new Random();
            int min = 10;
            int max = 98;
            int rand = random.nextInt((max - min) + 1) + min;
            if (!arrayList.contains(rand)) {
                arrayList.add(rand);
                i++;
                mergeSort(arrayList);
            }
        }


        mergeSortAdapter = new MergeSortAdapter(arrayList);
        merge.setAdapter(mergeSortAdapter);


    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> whole) {
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                left.add(whole.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                right.add(whole.get(i));
            }

            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);

            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }

    private void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }


    public void quickSortFun(View v) {
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


        quickSortAdapter = new QuickSortAdapter(arrayList);
        quick.setAdapter(quickSortAdapter);


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
