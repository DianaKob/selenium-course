package com.dataart.selenium.models;

/**
 * Created by dianka on 9/18/16.
 */
public class Application {
    private String tittle;
    private String description;
    private String category;
    private String imageUrl;
    private String iconUrl;

    public Application(String tittle, String description, String category, String imageUrl, String iconUrl) {
        this.tittle = tittle;
        this.description = description;
        this.category = category;
        this.imageUrl = imageUrl;
        this.iconUrl = iconUrl;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Application that = (Application) o;

        if (tittle != null ? !tittle.equals ( that.tittle ) : that.tittle != null) return false;
        if (description != null ? !description.equals ( that.description ) : that.description != null) return false;
        if (category != null ? !category.equals ( that.category ) : that.category != null) return false;
        if (imageUrl != null ? !imageUrl.equals ( that.imageUrl ) : that.imageUrl != null) return false;
        return iconUrl != null ? iconUrl.equals ( that.iconUrl ) : that.iconUrl == null;

    }

    @Override
    public int hashCode() {
        int result = tittle != null ? tittle.hashCode () : 0;
        result = 31 * result + (description != null ? description.hashCode () : 0);
        result = 31 * result + (category != null ? category.hashCode () : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode () : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode () : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Application{" +
                "tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
