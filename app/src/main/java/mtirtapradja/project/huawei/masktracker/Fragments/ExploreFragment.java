package mtirtapradja.project.huawei.masktracker.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mtirtapradja.project.huawei.masktracker.Adapter.ArticleAdapter;
import mtirtapradja.project.huawei.masktracker.Adapter.IconAdapter;
import mtirtapradja.project.huawei.masktracker.Model.Article;
import mtirtapradja.project.huawei.masktracker.Model.Icon;
import mtirtapradja.project.huawei.masktracker.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = ExploreFragment.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recycler_category, recycler_article;
    private ArrayList<Icon> iconList = new ArrayList<>();
    private ArrayList<Article> articleList = new ArrayList<>();

    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore,null);
        recycler_category = view.findViewById(R.id.category_recycle_view);
        recycler_article = view.findViewById(R.id.article_recycle_view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        LinearLayoutManager iconLayout = new LinearLayoutManager(getContext());
        iconLayout.setOrientation(LinearLayoutManager.HORIZONTAL);

        IconAdapter iconAdapter = new IconAdapter(getContext(), iconList);
        recycler_category.setAdapter(iconAdapter);
        recycler_category.setLayoutManager(iconLayout);

        LinearLayoutManager articelLayout = new LinearLayoutManager(getContext());
        articelLayout.setOrientation(RecyclerView.HORIZONTAL);

        ArticleAdapter articelAdapter = new ArticleAdapter(getContext(), articleList);
        recycler_article.setAdapter(articelAdapter);
        recycler_article.setLayoutManager(articelLayout);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void init(){
        // For Category
        int[] iconImages = {R.drawable.restaurant, R.drawable.petrol, R.drawable.onlineshopping,
                R.drawable.museum, R.drawable.hotel, R.drawable.hospital,
                R.drawable.cinema, R.drawable.bank, R.drawable.amusementpark};
        String[] iconName = getResources().getStringArray(R.array.icon);

        for(int index = 0; index < iconImages.length; index++){
            Icon icon = new Icon(iconImages[index], iconName[index]);
            iconList.add(icon);
        }

        // For Article
        int[] articleImage = {R.drawable.articel1, R.drawable.articel2,R.drawable.articel3,R.drawable.articel4,R.drawable.articel5};
        String[] articleTitle = getResources().getStringArray(R.array.articelTitle);
        String[] articelContain = getResources().getStringArray(R.array.articelContain);
        String[] articleAuthor = getResources().getStringArray(R.array.articelAuthor);
        Log.d("RECYCLE","MASUK");

        for(int index = 0; index < articleImage.length; index++){
            Article articel = new Article(articleImage[index],articelContain[index],articleTitle[index],articleAuthor[index]);
            articleList.add(articel);
        }
    }
}