package com.example.multiplerecyclerview;

public class Model {
    public  static final int  TEXT_TYPE=0; // These three are differentiator which tells
                                            // adapter which data have to be inflate
    public static final int IMAGE_TYPE = 1;
    public static final int AUDIO_TYPE = 2;

    private String content;
    private int resId;
    private int item_viewType;

    public Model(String content, int resId, int item_viewType) {
        this.content = content;
        this.resId = resId;
        this.item_viewType = item_viewType;
    }

    public static int getTextType() {
        return TEXT_TYPE;
    }

    public static int getImageType() {
        return IMAGE_TYPE;
    }

    public static int getAudioType() {
        return AUDIO_TYPE;
    }

    public String getContent() {
        return content;
    }

    public int getResId() {
        return resId;
    }

    public int getItem_viewType() {
        return item_viewType;
    }
}
