package com.example.bitninja.hellofresh.recipes.model;

import com.example.bitninja.hellofresh.login.model.User;
import com.example.bitninja.hellofresh.util.factory.SharedPreferencesFactory;
import com.google.gson.annotations.SerializedName;

import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class RecipesModel {

    @SerializedName("calories")
    private String calories;
    @SerializedName("carbos")
    private String carbos;
    @SerializedName("card")
    private String card;
    @SerializedName("country")
    private String country;
    @SerializedName("deliverable_ingredients")
    private List<String> deliverableIngredients = new ArrayList<>();
    @SerializedName("description")
    private String description;
    @SerializedName("difficulty")
    private Integer difficulty;
    @SerializedName("fats")
    private String fats;
    @SerializedName("favorites")
    private Integer favorites;
    @SerializedName("fibers")
    private String fibers;
    @SerializedName("headline")
    private String headline;
    @SerializedName("highlighted")
    private Boolean highlighted;
    @SerializedName("id")
    private String id;
    @SerializedName("image")
    private String image;
    @SerializedName("incompatibilities")
    private Object incompatibilities;
    @SerializedName("ingredients")
    private List<String> ingredients = new ArrayList<>();
    @SerializedName("keywords")
    private List<String> keywords = new ArrayList<>();
    @SerializedName("name")
    private String name;
    @SerializedName("products")
    private List<String> products = new ArrayList<>();
    @SerializedName("proteins")
    private String proteins;
    @SerializedName("rating")
    private Double rating;
    @SerializedName("ratings")
    private Integer ratings;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("time")
    private String time;
    @SerializedName("undeliverable_ingredients")
    private List<Object> undeliverableIngredients = new ArrayList<>();
    @SerializedName("user")
    private User user;
    @SerializedName("weeks")
    private List<String> weeks = new ArrayList<>();

    public String getCalories() {
        return calories;
    }

    public String getCarbos() {
        return carbos;
    }

    public String getCard() {
        return card;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getDeliverableIngredients() {
        return deliverableIngredients;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public String getFats() {
        return fats;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public String getFibers() {
        return fibers;
    }

    public String getHeadline() {
        return headline;
    }

    public Boolean getHighlighted() {
        return highlighted;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public Object getIncompatibilities() {
        return incompatibilities;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getName() {
        return name;
    }

    public List<String> getProducts() {
        return products;
    }

    public String getProteins() {
        return proteins;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatings() {
        return ratings;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTime() {
        return time;
    }

    public String getFormatedTime() {
        PeriodFormatter pf = ISOPeriodFormat.standard();
        Period period = pf.parsePeriod(time);
        String tempDate = PeriodFormat.getDefault().print(period);
        return tempDate;
    }

    public List<Object> getUndeliverableIngredients() {
        return undeliverableIngredients;
    }

    public User getUser() {
        return user;
    }

    public List<String> getWeeks() {
        return weeks;
    }

    public boolean isMarked() {
        return SharedPreferencesFactory.getInstance().getMarkState(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipesModel)) return false;

        RecipesModel model = (RecipesModel) o;
        return id.equals(model.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
