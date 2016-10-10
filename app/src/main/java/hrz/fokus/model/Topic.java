package hrz.fokus.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

public class Topic {

    int id;

    @SerializedName("subtitle")
    String mSubtitle;

    @SerializedName("title")
    String mTitle;

    @SerializedName("images")
    TopicImage mImages;

    @SerializedName("type_content")
    String mTypeContent;

    @SerializedName("namaparent")
    String mParentName;

    @SerializedName("summary")
    String mSummary;

    @SerializedName("date")
    Date mDate;

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public TopicImage getImages() {
        return mImages;
    }
}
