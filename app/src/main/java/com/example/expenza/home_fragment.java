package com.example.expenza;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class home_fragment extends Fragment {

    private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;
    private List<CategoryItem> categoryItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        rvCategory = view.findViewById(R.id.rvCategory);
        categoryItemList = generateSampleData(); // Replace this with your actual data
        categoryAdapter = new CategoryAdapter(categoryItemList, getContext());

        // Set up RecyclerView
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCategory.setAdapter(categoryAdapter);

        return view;
    }

    private List<CategoryItem> generateSampleData() {
        List<CategoryItem> data = new ArrayList<>();
        data.add(new CategoryItem("Housing", R.drawable.house, 100.50));
        data.add(new CategoryItem("Transportation", R.drawable.tranportation, 75.20));
        data.add(new CategoryItem("Groceries", R.drawable.groceries, 100.50));
        data.add(new CategoryItem("Insurance", R.drawable.insurance, 75.20));
        data.add(new CategoryItem("Personal Care", R.drawable.personalcare, 100.50));
        data.add(new CategoryItem("Entertainment", R.drawable.entertainment, 75.20));
        data.add(new CategoryItem("Education", R.drawable.education, 100.50));

        // Add more items as needed
        return data;
    }
}
