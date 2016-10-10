package hrz.fokus.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

public class TopicImage {

    @SerializedName("caption")
    String mCaption;

    @SerializedName("story")
    String mStory;

    @SerializedName("cover")
    String mCover;

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String mCaption) {
        this.mCaption = mCaption;
    }

    public String getStory() {
        return mStory;
    }

    public void setStory(String mStory) {
        this.mStory = mStory;
    }

    public String getCover() {
        return mCover;
    }

    public void setmCover(String mCover) {
        this.mCover = mCover;
    }
}
