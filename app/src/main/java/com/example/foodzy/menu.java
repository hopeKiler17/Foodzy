package com.example.foodzy;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity implements CategoryOptionAdaptor.CategoryClickInterface {
    private RecyclerView recyclerViewMenuMainCourse,recyclerViewMenuAppetizers,
            recyclerViewMenuEntree, recyclerViewMenuDesert,
            recyclerViewMenuBeverages, recyclerViewCategory;
    private GridLayoutManager layoutManagerMenuMainCourse, layoutManagerMenuAppetizers,
            layoutManagerMenuEntree, layoutManagerMenuDesert,
            layoutManagerMenuBeverages;
    private LinearLayoutManager layoutManagerCategory;
    private List<MenuOptionsModal> userListMenuMainCourse, userListMenuAppetizers,
            userListMenuEntree, userListMenuDesert, userListMenuBeverages;
    private List<CategoryOptionModal> userListCategory ;
    private MenuOptionsAdaptor adaptorMenuMainCourse, adaptorMenuAppetizers, adaptorMenuEntree,
            adaptorMenuDesert, adaptorMenuBeverages;
    CategoryOptionAdaptor adaptorCategory;
    FloatingActionButton f1;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        title = findViewById(R.id.idTVFoodtype);
        f1 = findViewById(R.id.floatingActionButton);

        initDataCategory();
        initRecyclerViewCategory();

        initDataMenuMainCourse();
        initRecyclerViewMenuMainCourse();

        initDataMenuAppetizers();
        initRecyclerViewMenuAppetizers();

        initDataMenuEntree();
        initRecyclerViewMenuEntree();

        initDataMenuDesert();
        initRecyclerViewMenuDesert();

        initDataMenuBeverages();
        initRecyclerViewMenuBeverages();

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,cart_details.class);
                startActivity(intent);
            }
        });

    }
    private void initDataCategory() {
        userListCategory = new ArrayList<>();
        userListCategory.add(new CategoryOptionModal(R.drawable.main_course, "Main Course"));
        userListCategory.add(new CategoryOptionModal(R.drawable.appetizers, "Appetizers"));
        userListCategory.add(new CategoryOptionModal(R.drawable.entres, "Entrées"));
        userListCategory.add(new CategoryOptionModal(R.drawable.dessets,"Desserts"));
        userListCategory.add(new CategoryOptionModal(R.drawable.beverages, "Beverages"));

    }
    private void initRecyclerViewCategory() {
        recyclerViewCategory = findViewById(R.id.typeFood);
        layoutManagerCategory = new LinearLayoutManager(this);

        adaptorCategory = new CategoryOptionAdaptor(userListCategory, this, this::onCategoryClick);
        recyclerViewCategory.setAdapter(adaptorCategory);
        adaptorCategory.notifyDataSetChanged();
    }

    private void initDataMenuMainCourse(){
        title.setText("Main Course");
        userListMenuMainCourse = new ArrayList<>();
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.chicken_shashlic, "Chicken Shashlic", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.malai_kofta, "Malai Kofta", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.palak_paneer, "Palak Paneer", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.saag_aloo, "Saag Aloo", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.paneer_jalfrezi, "Paneer Jalfrezi", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.paneer_vindaloo, "Paneer Vindaloo", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.vegetable_biriyani, "Vegetable Biryani", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.tandoori_chicken, "Tandoori Chicken", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.lamb_meatballs, "Lamb Meatballs", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.paneer_tikka_masala, "Paneer Tikka Masala", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.palak_chicken, "Palak Chicken", 100));
        userListMenuMainCourse.add(new MenuOptionsModal(R.drawable.chicken_curry, "Chicken Curry", 100));
    }
    private void initRecyclerViewMenuMainCourse(){
        recyclerViewMenuMainCourse = findViewById(R.id.foodPlate);
        layoutManagerMenuMainCourse = new GridLayoutManager(menu.this, 2);

        adaptorMenuMainCourse = new MenuOptionsAdaptor(userListMenuMainCourse, getApplicationContext());
        recyclerViewMenuMainCourse.setAdapter(adaptorMenuMainCourse);
        adaptorMenuMainCourse.notifyDataSetChanged();
    }

    private void initDataMenuAppetizers() {
        title.setText("Appetizers");
        userListMenuAppetizers = new ArrayList<>();
        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.appetizers, "Crescents", 100));
        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.canapes, "Canapes", 100));
        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.stuffed_samosa, "Stuffed Samosa", 100));
        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.pita_chips, "Pita Chips", 100));

        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.chilli_paneer, "Chilli Paneer", 100));
        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.medu_vada, "Medu Vada", 100));
        userListMenuAppetizers.add(new MenuOptionsModal(R.drawable.stuffed_mashrooms, "Stuffed Mushroom", 100));
    }
    private void initRecyclerViewMenuAppetizers() {
        recyclerViewMenuAppetizers = findViewById(R.id.foodPlateAppetizers);
        layoutManagerMenuAppetizers = new GridLayoutManager(menu.this, 2);

        adaptorMenuAppetizers = new MenuOptionsAdaptor(userListMenuAppetizers, getApplicationContext());
        recyclerViewMenuAppetizers.setAdapter(adaptorMenuAppetizers);
        adaptorMenuAppetizers.notifyDataSetChanged();
    }

    private void initDataMenuEntree() {
        title.setText("Entrées");
        userListMenuEntree = new ArrayList<>();
        userListMenuEntree.add(new MenuOptionsModal(R.drawable.antipasto_platter, "Antipasto Platter", 100));
        userListMenuEntree.add(new MenuOptionsModal(R.drawable.chicken_dumpling, "Chicken and Spinach Dumpling", 100));
        userListMenuEntree.add(new MenuOptionsModal(R.drawable.crispy_bocconcini, "Crispy Bacconcini", 100));
        userListMenuEntree.add(new MenuOptionsModal(R.drawable.chilli_prawns, "Chilli Prawns", 100));

        userListMenuEntree.add(new MenuOptionsModal(R.drawable.bacon_and_cheese_croquettes, "Bacon and Cheese Croquettes", 100));
        userListMenuEntree.add(new MenuOptionsModal(R.drawable.bruschetta, "Bruschetta", 100));
        userListMenuEntree.add(new MenuOptionsModal(R.drawable.steamed_dumplings, "Steamed Dumplings", 100));


    }
    private void initRecyclerViewMenuEntree() {
        recyclerViewMenuEntree = findViewById(R.id.foodPlateEntree);
        layoutManagerMenuEntree = new GridLayoutManager(menu.this, 2);

        adaptorMenuEntree = new MenuOptionsAdaptor(userListMenuEntree, getApplicationContext());
        recyclerViewMenuEntree.setAdapter(adaptorMenuEntree);
        adaptorMenuEntree.notifyDataSetChanged();
    }

    private void initDataMenuDesert() {
        title.setText("Desert");
        userListMenuDesert = new ArrayList<>();
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.molten_cake, "Chocolate molten     Cake", 100));
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.chocolate_truffle, "Chocolate truffle ", 100));
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.ube_cheesecake, "Ube Cheesecake", 100));
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.allrecipes_brownies, "TikTok Brownies", 100));
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.cinnamon_cake, "Cinnamon Roll Dump Cake", 100));
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.pumpkin_pie, "Marbled Chocolate Pumpkin Pie", 100));
        userListMenuDesert.add(new MenuOptionsModal(R.drawable.pecan_pie_cheesecake, "Marbled Chocolate Pumpkin Pie", 100));

    }
    private void initRecyclerViewMenuDesert() {
        recyclerViewMenuDesert = findViewById(R.id.foodPlateDesert);
        layoutManagerMenuDesert = new GridLayoutManager(menu.this, 2);

        adaptorMenuDesert = new MenuOptionsAdaptor(userListMenuDesert, getApplicationContext());
        recyclerViewMenuDesert.setAdapter(adaptorMenuDesert);
        adaptorMenuDesert.notifyDataSetChanged();
    }


    private void initDataMenuBeverages() {
        title.setText("Beverages");
        userListMenuBeverages = new ArrayList<>();
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.pink_gin, "Pink Gin", 100));
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.lemon_fizz, "Lemon Fizz", 100));
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.sake_fizz_cocktail, "Sake Fizz Cocktail", 100));
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.vanilla_strawbeyy_iced_tea, "Refreshing Vanilla Strawberry Iced Tea", 100));
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.peach_smoothie, "Peach Smoothie", 100));
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.raspberry_smoothie, "Rhubarb Bellini Smoothie", 100));
        userListMenuBeverages.add(new MenuOptionsModal(R.drawable.turquoise_tonic, " Turquoise Tonic", 100));



    }
    private void initRecyclerViewMenuBeverages() {
        recyclerViewMenuBeverages = findViewById(R.id.foodPlateBeverages);
        layoutManagerMenuBeverages = new GridLayoutManager(menu.this, 2);

        adaptorMenuBeverages = new MenuOptionsAdaptor(userListMenuBeverages, getApplicationContext());
        recyclerViewMenuBeverages.setAdapter(adaptorMenuBeverages);
        adaptorMenuBeverages.notifyDataSetChanged();
    }


    @Override
    public void onCategoryClick(int position) {
        String category = userListCategory.get(position).getText();

        setRecyclerView(category);
    }

    private void setRecyclerView(String category) {
        if (category.equals("Main Course") ){
            recyclerViewMenuMainCourse.setVisibility(View.VISIBLE);recyclerViewMenuAppetizers.setVisibility(View.GONE);recyclerViewMenuEntree.setVisibility(View.GONE);
            recyclerViewMenuDesert.setVisibility(View.GONE);recyclerViewMenuBeverages.setVisibility(View.GONE);

            initDataMenuMainCourse();
            initRecyclerViewMenuMainCourse();
        }

        else if(category.equals("Appetizers")) {
            recyclerViewMenuMainCourse.setVisibility(View.GONE);recyclerViewMenuAppetizers.setVisibility(View.VISIBLE);recyclerViewMenuEntree.setVisibility(View.GONE);
            recyclerViewMenuDesert.setVisibility(View.GONE);recyclerViewMenuBeverages.setVisibility(View.GONE);
            initDataMenuAppetizers();
            initRecyclerViewMenuAppetizers();
        }

        else if(category.equals("Entrées")) {
            recyclerViewMenuMainCourse.setVisibility(View.GONE);recyclerViewMenuAppetizers.setVisibility(View.GONE);recyclerViewMenuEntree.setVisibility(View.VISIBLE);
            recyclerViewMenuDesert.setVisibility(View.GONE);recyclerViewMenuBeverages.setVisibility(View.GONE);
            initDataMenuEntree();
            initRecyclerViewMenuEntree();
        }

        else if(category.equals("Desserts")) {
            recyclerViewMenuMainCourse.setVisibility(View.GONE);recyclerViewMenuAppetizers.setVisibility(View.GONE);recyclerViewMenuEntree.setVisibility(View.GONE);
            recyclerViewMenuDesert.setVisibility(View.VISIBLE);recyclerViewMenuBeverages.setVisibility(View.GONE);
            initDataMenuDesert();
            initRecyclerViewMenuDesert();
        }
        else if (category.equals("Beverages")) {
            recyclerViewMenuMainCourse.setVisibility(View.GONE);recyclerViewMenuAppetizers.setVisibility(View.GONE);recyclerViewMenuEntree.setVisibility(View.GONE);
            recyclerViewMenuDesert.setVisibility(View.GONE);recyclerViewMenuBeverages.setVisibility(View.VISIBLE);
            initDataMenuBeverages();
            initRecyclerViewMenuBeverages();
        }
    }
}