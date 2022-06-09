package hr.tvz.zupanovic.hardwareapp.review;

public class ReviewDTO {
    private String title;
    private String text;
    private int rating;

    public ReviewDTO(String title, String text, int rating) {
        this.title = title;
        this.text = text;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" + "title:'" + title + '\'' + ", text:'" + text + '\'' + ", rating:" + rating + "}";
    }
}
