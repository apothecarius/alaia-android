package de.apoth.alaia_android;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * Created by apoth on 3/31/15.
 */
public class Track extends RelativeLayout{
    private TrackNode root; //the page that was called directly


    public Track(String url,Context context)
    {
        super(context);
        this.root = new TrackNode(null,url);
    }

    /**
     * @return how many Nodes might have to be drawn in a column
     */
    public int getTreeWidth()
    {

        return root.getTreeWidth();
    }
}
