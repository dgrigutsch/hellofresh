package com.example.bitninja.hellofrashtest.receipes.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import com.example.bitninja.hellofrashtest.R;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinder;
import com.example.bitninja.hellofrashtest.ui.binder.ItemBinderBase;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bitninja on 26.10.2015.
 */
public class ReceipesModel {

    @SerializedName("calories")
    @Expose
    private String calories;
    @SerializedName("carbos")
    @Expose
    private String carbos;
    @SerializedName("card")
    @Expose
    private String card;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("deliverable_ingredients")
    @Expose
    private List<String> deliverableIngredients = new ArrayList<>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("difficulty")
    @Expose
    private Integer difficulty;
    @SerializedName("fats")
    @Expose
    private String fats;
    @SerializedName("favorites")
    @Expose
    private Integer favorites;
    @SerializedName("fibers")
    @Expose
    private String fibers;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("highlighted")
    @Expose
    private Boolean highlighted;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("incompatibilities")
    @Expose
    private Object incompatibilities;
    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients = new ArrayList<>();
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = new ArrayList<>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("products")
    @Expose
    private List<String> products = new ArrayList<>();
    @SerializedName("proteins")
    @Expose
    private String proteins;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("ratings")
    @Expose
    private Integer ratings;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("undeliverable_ingredients")
    @Expose
    private List<Object> undeliverableIngredients = new ArrayList<>();
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("weeks")
    @Expose
    private List<String> weeks = new ArrayList<>();

    /**
     * @return The calories
     */
    public String getCalories() {
        return calories;
    }

    /**
     * @param calories The calories
     */
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     * @return The carbos
     */
    public String getCarbos() {
        return carbos;
    }

    /**
     * @param carbos The carbos
     */
    public void setCarbos(String carbos) {
        this.carbos = carbos;
    }

    /**
     * @return The card
     */
    public String getCard() {
        return card;
    }

    /**
     * @param card The card
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The deliverableIngredients
     */
    public List<String> getDeliverableIngredients() {
        return deliverableIngredients;
    }

    /**
     * @param deliverableIngredients The deliverable_ingredients
     */
    public void setDeliverableIngredients(List<String> deliverableIngredients) {
        this.deliverableIngredients = deliverableIngredients;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The difficulty
     */
    public Integer getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty The difficulty
     */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return The fats
     */
    public String getFats() {
        return fats;
    }

    /**
     * @param fats The fats
     */
    public void setFats(String fats) {
        this.fats = fats;
    }

    /**
     * @return The favorites
     */
    public Integer getFavorites() {
        return favorites;
    }

    /**
     * @param favorites The favorites
     */
    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    /**
     * @return The fibers
     */
    public String getFibers() {
        return fibers;
    }

    /**
     * @param fibers The fibers
     */
    public void setFibers(String fibers) {
        this.fibers = fibers;
    }

    /**
     * @return The headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * @param headline The headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * @return The highlighted
     */
    public Boolean getHighlighted() {
        return highlighted;
    }

    /**
     * @param highlighted The highlighted
     */
    public void setHighlighted(Boolean highlighted) {
        this.highlighted = highlighted;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return The incompatibilities
     */
    public Object getIncompatibilities() {
        return incompatibilities;
    }

    /**
     * @param incompatibilities The incompatibilities
     */
    public void setIncompatibilities(Object incompatibilities) {
        this.incompatibilities = incompatibilities;
    }

    /**
     * @return The ingredients
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients The ingredients
     */
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return The keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords The keywords
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The products
     */
    public List<String> getProducts() {
        return products;
    }

    /**
     * @param products The products
     */
    public void setProducts(List<String> products) {
        this.products = products;
    }

    /**
     * @return The proteins
     */
    public String getProteins() {
        return proteins;
    }

    /**
     * @param proteins The proteins
     */
    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    /**
     * @return The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * @param rating The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * @return The ratings
     */
    public Integer getRatings() {
        return ratings;
    }

    /**
     * @param ratings The ratings
     */
    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    /**
     * @return The thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * @param thumb The thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The undeliverableIngredients
     */
    public List<Object> getUndeliverableIngredients() {
        return undeliverableIngredients;
    }

    /**
     * @param undeliverableIngredients The undeliverable_ingredients
     */
    public void setUndeliverableIngredients(List<Object> undeliverableIngredients) {
        this.undeliverableIngredients = undeliverableIngredients;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The weeks
     */
    public List<String> getWeeks() {
        return weeks;
    }

    /**
     * @param weeks The weeks
     */
    public void setWeeks(List<String> weeks) {
        this.weeks = weeks;
    }
}
